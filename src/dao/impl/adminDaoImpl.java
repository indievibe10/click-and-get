package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.dbConnection;
import dao.adminDao;
import model.user;

public class adminDaoImpl implements adminDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(user u) {
	
	Connection conn=dbConnection.getDb();
	String SQL="insert into user(account,password,address,email)" + "values (?,?,?,?)";
			
	try
	{
	  PreparedStatement ps=conn.prepareStatement(SQL);
	  ps.setString(1, u.getAccount());
	  ps.setString(2, u.getPassword());
	  ps.setString(3, u.getAddress());
	  ps.setString(4, u.getEmail());
				
	  ps.executeUpdate();
				
				
	}	catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	}
			
		
				
	}
	@Override
	public boolean queryUsername(String account) {
		// TODO Auto-generated method stub

			Connection conn=dbConnection.getDb();
			String SQL="select * from user where account=?";
			boolean x=false;
			try {
				PreparedStatement ps=conn.prepareStatement(SQL);
				ps.setString(1, account);			
				ResultSet rs=ps.executeQuery();			
				if(rs.next()) x=true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return x;
		}
	public user queryUser(String account, String password) {
		/*
		 * 1.連線-->connection
		 * 2.SQL
		 * 3.PreparedStatement
		 * 4.ResultSet-->new member
		 */
		Connection conn=dbConnection.getDb();
		String SQL="select * from user where account=? and password=?";
		user u=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,account);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				u=new user();
				/*u.setId(rs.getInt("id")); */
				u.setAccount(rs.getString("account"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setAddress(rs.getString("address"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return u;
	}
	

	}