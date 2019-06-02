package com.xjh.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xjh.bean.GoodsBean;
import com.xjh.tools.DBHelp;

public class GoodsService {
	private GoodsBean gd;
	
//	public GoodsService(GoodsBean gd){
//		
//		this.gd=gd;		
//	}
	//业务逻辑：去数据库goods表查询，把查到的记录封装到ArrayList数组里返回
	public ArrayList<GoodsBean> getGoodsList(int category,int page,int counts){
		Connection con=DBHelp.getCon();
		PreparedStatement pst=null;
		ArrayList<GoodsBean> arr=new ArrayList<GoodsBean>();		
		String sql=null;
		ResultSet rs=null;
		switch(category){
		case 1:
		case 2:
		case 3:
			sql="select * from goods where category=?";
			break;
		default:
			sql="select * from goods";		
		}				
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, category);
			rs=pst.executeQuery();
		    while(rs.next()){
		    	
		    	int id=rs.getInt("id");
		    	String name=rs.getString("name");
		    	String info=rs.getString("info");
		    	String imgpath=rs.getString("imgpath");
		    	int fenlei=rs.getInt("category");
		    	float price=rs.getFloat("price");
		    	int num=rs.getInt("num");
		    	GoodsBean gb= new GoodsBean(id,name,info,imgpath,fenlei,price,num);
		    	arr.add(gb);		    			    	
		    }
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBHelp.closeDBResource(rs, pst, con);
		}
		
		
		return arr;
	}

}
