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
	private int id; //����id ���� 
	private String name; //��������
	private String info; //������
	private  String imgpath;//����ͼƬ·��
	private int category; //�������
	private float price;//����۸�
	private int num;//������

}
