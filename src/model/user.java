package model;

public class user {
	
	private String account;
	private String password;
	private String email;
	private String address;
	
	
	
	public user(String account, String password, String email, String address) {
		super();
		this.account = account;
		this.password = password;
		this.email = email;
		this.address = address;
	}

	
	public user() {
		// TODO Auto-generated constructor stub
	}


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	
	
}
	

