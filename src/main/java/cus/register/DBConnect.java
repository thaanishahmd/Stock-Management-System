package cus.register;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static String url="jdbc:mysql://localhost:3306/stock_management";
	private static String user = "root";
	private static String pass = "Root@mysql";
	private static Connection con;
	private static String var = "myDB";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, pass);
		}
		catch(Exception e){
			System.out.println("Database connection is not successful");
		}
		
		return con;
	}
}
