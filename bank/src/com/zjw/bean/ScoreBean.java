package com.zjw.bean;

public class ScoreBean {
	
public ScoreBean(String id,int score,String dataSrc,String create_date){
		
		this.id = id;
		this.score = score;
		this.dataSrc = dataSrc;
		this.create_date = create_date;
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDataSrc() {
		return dataSrc;
	}
	public void setDataSrc(String dataSrc) {
		this.dataSrc = dataSrc;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	private String dataSrc;
	private String create_date;
	private String id;	
	private int score;
}
