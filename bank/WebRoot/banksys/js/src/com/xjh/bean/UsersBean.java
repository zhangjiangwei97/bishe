package com.xjh.bean;

public class UsersBean {
	
	public UsersBean(String username,String pwd,String email,String tel){
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.tel = tel;				
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	private String username;
	private String pwd;
	private String email;
	private String tel;
}
