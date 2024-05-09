package dao;

import java.util.ArrayList;
import java.util.List;

import model.query;

public interface queryDao {
	
	
	//read
	
	List<query> querypoint(String name); //商品頁查詢點數
	ArrayList<Object[]> record(String name); //使用者查詢孵化紀錄
	ArrayList<Object[]>	items(String name); //使用者查詢兌換紀錄


	
}
