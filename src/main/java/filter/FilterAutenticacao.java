package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import connection.SingleConnectionBanco;

@WebFilter(urlPatterns = { "/principal/*" })
public class FilterAutenticacao extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	private static Connection connection;

	public FilterAutenticacao() {
		super();
	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			String usuarioLogado = (String) session.getAttribute("usuario");
			String urlPaaraAuntenticar = req.getServletPath();

			if (usuarioLogado == null && !urlPaaraAuntenticar.equalsIgnoreCase("/principal/ServletLogin")) {
				RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlPaaraAuntenticar);
				request.setAttribute("msg", "Por favor realize o login!");
				redireciona.forward(request, response);
				return;
			} else {

				chain.doFilter(request, response);
			}
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("error.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnectionBanco.getConnection();
	}

}
