package com.zjw.bean;

public class CardBean {
	
public CardBean(String id,String u_ser,String num,String create_date,String expire_date,int limited,int balance,String billdate){
		
		this.id = id;
		this.u_ser = u_ser;
		this.num = num;
		this.create_date = create_date;
		this.expire_date = expire_date;
		this.limited = limited;
		this.balance = balance;
		this.billdate = billdate;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getU_ser() {
		return u_ser;
	}
	public void setU_ser(String u_ser) {
		this.u_ser = u_ser;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}
	public int getLimited() {
		return limited;
	}
	public void setLimited(int limited) {
		this.limited = limited;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getBilldate() {
		return billdate;
	}
	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}
	private String billdate;
	private String id;	
	private String u_ser;
	private String num;
	private String create_date;
	private String expire_date;
	private int limited;
	private int balance;
}
