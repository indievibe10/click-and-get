package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static Connection getDb()
	{
		Connection conn=null;
		String Url="jdbc:mysql://localhost:3306/reedeem";
		String username="root";
		String password="94041000";
		
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(Url, username, password);			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return conn;		
	}

	
}