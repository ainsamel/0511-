package com.company.biz.home;

public class HomeVO {
	
	private int number;
	private String usertype;
	private String userid;
	private String password;
	private String username;
	private String tel;
	private String eamil;
	private String address;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "HomeVO [number=" + number + ", usertype=" + usertype + ", userid=" + userid + ", password=" + password
				+ ", username=" + username + ", tel=" + tel + ", eamil=" + eamil + ", address=" + address + "]";
	}
	
	
}
