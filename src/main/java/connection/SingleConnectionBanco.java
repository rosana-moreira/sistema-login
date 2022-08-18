package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {
	private String driver = "com.mysql.cj.jdbc.Driver";

	private String url = "jdbc:mysql://127.0.0.1:3306/dbcursojsp?useTimezone=true&serverTimezone=UTC";

	private String user = "root";

	private String password = "123456789";
	private static Connection con = null;

	public static Connection getConnection() {
		return con;
	}

	public SingleConnectionBanco() {/* quando tiver um instancia vai conectar */
		conectar();
	}

	private Connection conectar() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
