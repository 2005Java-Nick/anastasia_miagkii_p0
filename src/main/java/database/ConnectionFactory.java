package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String url;
	
	private static String username;
	
	private static String password;
	
	private static String db ;
	
	private static ConnectionFactory cf;
	
	private ConnectionFactory() {
		
		url = System.getenv("soft_url");
		db = System.getenv("soft_dbname");
		url = "jdbc:postgresql://" + url + ":5432/" + db + "?";
		username = System.getenv("soft_username");
		password = System.getenv("soft_password");

		
	}
	
	private Connection createConnection() {
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Unable to make connection");
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static Connection getConnection() {
		
		if (cf == null) {
			cf = new ConnectionFactory();
		}
		
		return cf.createConnection();
		
	}

}