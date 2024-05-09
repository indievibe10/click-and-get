package dao;

import model.user;

public interface adminDao {
	
	//create
	void add(user u);
	
	//read

	boolean queryUsername(String username);
	
}
