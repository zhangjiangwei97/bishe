package com.zjw.bean;

public class TransBean {
	

public TransBean(String num,int cmoney,int qmoney,String operatime){
		
		this.num = num;
		this.cmoney = cmoney;
		this.qmoney = qmoney;
		this.operatime = operatime;
		
	}


	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getCmoney() {
		return cmoney;
	}
	public void setCmoney(int cmoney) {
		this.cmoney = cmoney;
	}
	public int getQmoney() {
		return qmoney;
	}
	public void setQmoney(int qmoney) {
		this.qmoney = qmoney;
	}
	
	
	public String getOperatime() {
		return operatime;
	}


	public void setOperatime(String operatime) {
		this.operatime = operatime;
	}


	private String num;
	private int cmoney;	
	private int qmoney;
	private String operatime;
}
