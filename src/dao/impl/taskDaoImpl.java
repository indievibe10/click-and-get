package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.dbConnection;
import dao.taskDao;
import model.task;

public class taskDaoImpl implements taskDao {

	public static void main(String[] args) {
	

	}

	@Override
	public void add(task t) {
	
		Connection conn=dbConnection.getDb();
		String SQL="insert into task(name,complete,point) values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, t.getName());
			ps.setInt(2, task.getComplete());
			ps.setInt(3, task.getPoint());
			
			ps.executeUpdate();
			
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	}
	@Override
	public List<task> queryAll() {
		Connection conn=dbConnection.getDb();
		String SQL="select * from task";
		List<task> l=new ArrayList<task>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				  	task t = new task(); 
		            t.setId(rs.getInt("id"));
		            t.setName(rs.getString("name")); 
		            task.setComplete(rs.getInt("complete"));
		            task.setPoint(rs.getInt("point"));

		            l.add(t);
		        }
				
			
			
		} catch (SQLException e) {
	        e.printStackTrace();
	   
	    }

	    return l;
	}
}
