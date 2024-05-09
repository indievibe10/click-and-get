package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.dbConnection;
import dao.itemsDao;
import model.items;

public class itemsDaoImpl implements itemsDao {

	public static void main(String[] args) {
		
		/* items i=new items(2,1,1);
		new itemsDaoImpl().add(i); */
	}

	@Override
	public void add(items i) {
	
		Connection conn=dbConnection.getDb();
		String SQL="insert into items(name,sandwich,don,water,sumpoint,balance) values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, i.getName());
			ps.setInt(2, i.getSandwich());
			ps.setInt(3, i.getDon());
			ps.setInt(4, i.getWater());
			ps.setInt(5, i.getSum());
			ps.setInt(6, i.getBalance());
			
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<items> querylist(String name) {
		Connection conn=dbConnection.getDb();
		String SQL="select * from items where name=?";
		List<items> l=new ArrayList<items>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(2, name); 
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
				
			{
				items i=new items(null,null,null,null,null);
				i.setName(rs.getString("name"));
				i.setSandwich(rs.getInt("sandwich"));
				i.setDon(rs.getInt("don"));
				i.setWater(rs.getInt("water"));
				i.setSum(rs.getInt("sumpoint"));
				
			
				l.add(i);
			}
		
		} catch (SQLException e) {
	        e.printStackTrace();
	   
	    }
		return l;

	}
		
}
		

	
	
	

	

	



