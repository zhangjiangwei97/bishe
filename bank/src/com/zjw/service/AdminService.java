package com.zjw.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zjw.bean.AdminBean;
import com.zjw.tools.DBHelp;

public class AdminService {

		//�ж��û��������ݿ��users�Ƿ��Ѿ���ע���
		public boolean checkUsernameValid(AdminBean ad){
			//�������ݿ�
			Connection  conn=DBHelp.getCon();
			String sql="select * from Persons where name=?";
			ResultSet rs=null;
			PreparedStatement stm=null;
			try {
				stm=conn.prepareStatement(sql);
				stm.setString(2, ad.getName());
				rs=stm.executeQuery();
				if(rs.next())//Ϊ��˵����ǰ�û������鵽�ˣ��Ѿ���ע����ˣ����Բ��Ϸ�
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
