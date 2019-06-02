package com.zjw.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zjw.bean.AdminBean;
import com.zjw.tools.DBHelp;

public class AdminService {

		//判断用户名在数据库表users是否已经被注册过
		public boolean checkUsernameValid(AdminBean ad){
			//连接数据库
			Connection  conn=DBHelp.getCon();
			String sql="select * from Persons where name=?";
			ResultSet rs=null;
			PreparedStatement stm=null;
			try {
				stm=conn.prepareStatement(sql);
				stm.setString(2, ad.getName());
				rs=stm.executeQuery();
				if(rs.next())//为真说明当前用户名被查到了，已经被注册过了，所以不合法
					return false;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				DBHelp.closeDBResource(rs, stm, conn);
			}
			return true;						
		}
		
		public boolean loginSuccess(String userName,String password){
			 boolean returnValue = false;
			 String sql = "SELECT * FROM Persons";
			 
			 Statement stmt = null;
			 ResultSet rs = null;
			 
			 try{
			 Connection conn = DBHelp.getCon();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql);
			 while(rs.next()){
			 String username = rs.getString("name");
			 String pwd = rs.getString("pwd");
			 if(username.equals(userName) &&
			 pwd.equals(password)){
			 returnValue = true;
			 break;
			 }
			 }
			 }catch (SQLException e) {
			 e.printStackTrace();
			 }
			 
			 return returnValue;
			 //return true;
			 
			 }
}
