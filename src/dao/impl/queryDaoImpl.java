package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.dbConnection;
import dao.dbConnection_b;
import dao.queryDao;
import model.query;

public class queryDaoImpl implements queryDao {

	public static void main(String[] args) {
		
		
		
			
	}

	@Override
	public List<query> querypoint(String name) {
	    // TODO Auto-generated method stub
	    Connection conn = dbConnection_b.getDb("reedeem");
	    List<query> l = new ArrayList<query>();
	    String SQL = "select * from reedeem.new_view where 帳戶名稱=?";
	    
	    
	    try {
	        PreparedStatement ps = conn.prepareStatement(SQL);
	        ps.setString(1,name);
	        ResultSet rs = ps.executeQuery();
	       
	        
	        while (rs.next()) 
	        {
	            query q = new query();
	            q.setName(rs.getString("帳戶名稱"));
	            q.setComplete(rs.getInt("孵化次數"));
	            q.setPoint(rs.getInt("累積點數"));
	            q.setBalance(rs.getInt("已使用點數"));

	            l.add(q);
	        }
	    } catch (SQLException e) {
	       
	        e.printStackTrace();
	    } 

	    return l;
	}

	@Override
	public ArrayList<Object[]> record(String name) {
		
		ArrayList<Object[]> record =new ArrayList<Object[]>();
			try {
			Connection conn=dbConnection.getDb();
			String SQL = "select * from task where name=?";
			PreparedStatement ps = conn.prepareStatement(SQL);
		     
			ps.setString(1, name); 
		    ResultSet rs = ps.executeQuery();
		            
		    while (rs.next()) {
		                	Object[] row = {
		                	rs.getInt("id"),
		                	rs.getString("name"),
		                    rs.getInt("complete"),
		                    rs.getInt("point"),
		                };
		                record.add(row);
		            }
		    	System.out.println(record.size());
		    
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return record;
		}

	@Override
	public ArrayList<Object[]> items(String name) {
		
		ArrayList<Object[]> items =new ArrayList<Object[]>();
		try {
		Connection conn=dbConnection.getDb();
		String SQL = "select * from items where name=?";
		PreparedStatement ps = conn.prepareStatement(SQL);
	     
		ps.setString(1, name); 
	    ResultSet rs = ps.executeQuery();
	            
	    while (rs.next()) {
	                	Object[] row = {
	                	rs.getInt("id"),
	                	rs.getString("name"),
	                	rs.getInt("sandwich"),
	                    rs.getInt("don"),
	                    rs.getInt("water"),
	                    rs.getInt("sumpoint"),
	                    rs.getInt("balance"),
	                };
	                items.add(row);
	            }
	    	System.out.println(items.size());
	    
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return items;
	}
}