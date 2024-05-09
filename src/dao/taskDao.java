package dao;

import java.util.List;

import model.task;

public interface taskDao {
		//create
		void add(task t);
		//read
		List<task> queryAll();
		
}
