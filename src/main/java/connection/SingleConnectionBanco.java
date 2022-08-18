package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {
	private static String driver = "com.mysql.cj.jdbc.Driver";

	private static String url = "jdbc:mysql://127.0.0.1:3306/dbcursojsp?useTimezone=true&serverTimezone=UTC";

	private static String user = "root";

	private static String password = "123456789";
	private static Connection con = null;

	public static Connection getConnection() {
		return con;
	}

	static {
		conectar();
	}

	public SingleConnectionBanco() {/* quando tiver um instancia vai conectar */
		conectar();
	}

	private static void conectar() {
		try {
			if (con == null) {

				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				con.setAutoCommit(false);
			}
		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
