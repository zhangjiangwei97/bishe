package com.zjw.bean;

public class Complain {
	
public Complain(String name,String talk,String sys_time){
		
		this.name = name;
		this.talk = talk;
		this.sys_time = sys_time;
		
	}
			
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTalk() {
		return talk;
	}
	public void setTalk(String talk) {
		this.talk = talk;
	}
	public String getSys_time() {
		return sys_time;
	}
	public void setSys_time(String sys_time) {
		this.sys_time = sys_time;
	}
	private String name;
	private String talk;	
	private String sys_time;
}
