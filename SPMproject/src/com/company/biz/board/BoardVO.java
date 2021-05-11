package com.company.biz.board;

import java.sql.Date;

public class BoardVO {
	private int number;
	private String usertype;
	private String userid;
	private String username;
	private String tel;
	private String email;
	private String address;
	
	@Override
	public String toString() {
		return "BoardVO [number=" + number + ", usertype=" + usertype + ", userid=" + userid + ", username=" + username
				+ ", tel=" + tel + ", email=" + email + ", address=" + address + "]";
	}
	public int getnumber() {
		return number;
	}
	public void setnumber(int seq) {
		this.number = number;
	}
	public String getusertype() {
		return usertype;
	}
	public void setusertype(String usertype) {
		this.usertype = usertype;
	}
	public String getuserid() {
		return userid;
	}
	public void setuserid(String userid) {
		this.userid = userid;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String gettel() {
		return tel;
	}
	public void settel(String tel) {
		this.tel = tel;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
}
