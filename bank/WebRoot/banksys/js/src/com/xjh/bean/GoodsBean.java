package com.xjh.bean;

public class GoodsBean {
	
	public GoodsBean(int id,String name,String info,String imgpath,int category,float price,int num){
		this.id = id;
		this.name = name;
		this.info = info;
		this.imgpath = imgpath;
		this.category = category;
		this.price = price;
		this.num = num;
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	private int id; //货物id 主键 
	private String name; //货物名字
	private String info; //货物简介
	private  String imgpath;//货物图片路径
	private int category; //货物分类
	private float price;//货物价格
	private int num;//货物库存

}
