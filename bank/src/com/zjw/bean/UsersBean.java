package com.zjw.bean;

public class UsersBean {
	
	public UsersBean(String id,String name,String Gender,String Tel,String idNo,String statu,String stat,String accban){
		
		this.id = id;
		this.name = name;
		this.Gender = Gender;
		this.Tel = Tel;
		this.idNo = idNo;
		this.statu = statu;
		this.stat = stat;
		this.accban = accban;
		
		
	}
	
	
public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getAccban() {
		return accban;
	}
	public void setAccban(String accban) {
		this.accban = accban;
	}
private String id;	
private String name;
private String Gender;
private String Tel;
private String idNo;
private String statu;
private String stat;
private String accban;



}
