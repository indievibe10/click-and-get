package model;

import java.io.Serializable;

public class task implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private static int complete; //完成孵化的蛋
	private static int point; //得到的點數
	

	public task(String name, int complete, int point) {
		super();
		this.name = name;
		task.complete = complete;
		task.point = point;
	}


	public task() {
		super();
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public static int getComplete() {
		return complete;
	}


	public static void setComplete(int complete) {
		task.complete = complete;
	}


	public static int getPoint() {
		return point;
	}


	public static void setPoint(int point) {
		task.point = point;
	}
}
	