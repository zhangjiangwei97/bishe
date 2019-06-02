package com.zjw.bean;


public class UserBean {
	
	private String iname;	
	private String pwd;
	private String name;
	private String idno;
	private String statu;
	
	public UserBean(String iname,String pwd,String name,String idno,String statu){
		
		this.iname = iname;
		this.pwd = pwd;
		this.name = name;
		this.idno = idno;
		this.statu = statu;
		
		
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}

}
