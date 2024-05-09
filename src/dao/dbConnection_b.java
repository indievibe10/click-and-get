package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection_b {

	
	public static void main(String[] args) {
		System.out.println(dbConnection_b.getDb("reedeem"));

	}
	
	public static Connection getDb(String url)
	{
		Connection conn=null;
		String Url="jdbc:mysql://localhost:3306/"+url;
		String username="root";
		String password="94041000";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(Url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}

}

