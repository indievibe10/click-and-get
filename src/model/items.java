package model;

public class items {
	
	private String name;
	private Integer point;   
	private Integer sandwich;
	private Integer don;
	private Integer water;
	private Integer sum;
	private Integer balance;

	public items(String name,Integer sandwich, Integer don, Integer water, Integer point) {
		super();
		this.name=name;
		this.sandwich = sandwich;
		this.don = don;
		this.water = water;
		this.point=point;
		

		sum=5*sandwich+15*don+30*water;
		balance=point-sum;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSandwich() {
		return sandwich;
	}

	public void setSandwich(Integer sandwich) {
		this.sandwich = sandwich;
	}

	public Integer getDon() {
		return don;
	}

	public void setDon(Integer don) {
		this.don = don;
	}

	public Integer getWater() {
		return water;
	}

	public void setWater(Integer water) {
		this.water = water;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getBalance() {
	
		return balance;
	}
	
	public void setBalance(Integer balance) {
		this.balance=balance;
	}
	
}
