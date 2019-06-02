package com.zjw.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.zjw.bean.UserBean;
import com.zjw.bean.UsersBean;
import com.zjw.tools.DBHelp;

public class UserService {
	
	public boolean checkUsernameValid(UserBean user){
		//�������ݿ�
		Connection  conn=DBHelp.getCon();
		String sql="select * from us where iname=?";
		ResultSet rs=null;
		PreparedStatement stm=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1, user.getName());
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
	public int userch(UserBean user){
		
		int i = 0;
		
		try{
 			
			 Connection conn = DBHelp.getCon();
			 System.out.println("test+++++"+user.getIname());
			 System.out.println("test+++++"+user.getPwd());
			
			 String sql = "UPDATE us set pwd='"+user.getPwd()+"' where name='"+user.getIname()+"'";
			 PreparedStatement stm=conn.prepareStatement(sql);
			 
			 i=stm.executeUpdate();
	
			}catch(SQLException e){
				
				e.printStackTrace();

				
			}
		return i;
	}
	public int userdel(UserBean user){
		
		int i = 0;
		
		try{
 			
			 Connection conn = DBHelp.getCon();
			 System.out.println("test+++++"+user.getIname());
			 System.out.println("test+++++"+user.getPwd());
			
			 String sql = "delete from us where iname='"+user.getIname()+"'";
			 PreparedStatement stm=conn.prepareStatement(sql);
			 i=stm.executeUpdate();
	
			}catch(SQLException e){
				
				e.printStackTrace();

				
			}
	return i;
	}
	public boolean  registerWriteDB(UserBean user){
		Connection  conn=DBHelp.getCon();
		String sql="insert into us values(?,?,?,?,?)";
		PreparedStatement stm=null;
		
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1, user.getIname());
			stm.setString(2, user.getPwd());
			stm.setString(3, user.getName());
			stm.setString(4, user.getIdno());
			stm.setString(5, user.getStatu());
			int num=stm.executeUpdate();
			if(num==1)//˵��Ӱ���������һ����˵�����ݲ���ɹ�
				return true;						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBHelp.closeDBResource(null, stm, conn);
		}
		return false;	
	}
	public int loginSuccess(String userName,String password){
		 int returnValue = 0;
		 String sql = "SELECT * FROM us";
		 
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 try{
		 Connection conn = DBHelp.getCon();
		 stmt = conn.createStatement();
		 rs = stmt.executeQuery(sql);
		 while(rs.next()){
		 String username = rs.getString("iname");
		 String pwd = rs.getString("pwd");
		 if(username.equals(userName) &&
		 pwd.equals(password)){
	     if(rs.getString("statu").equals("0")){
		 returnValue = 1;
		 }
	     else if(rs.getString("statu").equals("1")){
	     returnValue = 2;	 
	     }
		 break;
		 }
		 }
		 }catch (SQLException e) {
		 e.printStackTrace();
		 }
		 
		 return returnValue;
		 //return true;
		 
		 }
	public String userkahao(String u){
		String sql = "select num from card,us,Users where us.idno=Users.idNo and Users.id=card.id and us.iname='"+u+"'";
		 
		 Statement stmt = null;
		 ResultSet rs = null;
		 String kahao = null;
	
			
			try{
				Connection conn = DBHelp.getCon();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery(sql);
				while(rs.next()){
					
					kahao =rs.getString("num");
					//System.out.print("statuzjw"+statu);
					//System.out.print("11111111"+rs.getString("statu"));
				}				 
			
				}catch(SQLException e){
					
					e.printStackTrace();

					
				}
		return kahao;
		}
	public String research(String u){
		String sql = "select idno from us where iname='"+u+"'";
		 
		 Statement stmt = null;
		 ResultSet rs = null;
		 String idnoreturn = null;
			
			try{
				Connection conn = DBHelp.getCon();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery(sql);
				while(rs.next()){
					
					idnoreturn =rs.getString("idno");
					
				}				 
			
				}catch(SQLException e){
					
					e.printStackTrace();

					
				}
		return idnoreturn;
		}
	
	public String userstat(String u){
		String sql = "select Users.statu from Users,us where Users.idNo=us.idno and iname='"+u+"'";
		 
		 Statement stmt = null;
		 ResultSet rs = null;
		 String statu = null;
	
			
			try{
				Connection conn = DBHelp.getCon();
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery(sql);
				while(rs.next()){
					
					statu =rs.getString("statu");
					//System.out.print("statuzjw"+statu);
					//System.out.print("11111111"+rs.getString("statu"));
				}				 
			
				}catch(SQLException e){
					
					e.printStackTrace();

					
				}
		return statu;
		}
	
	public int usermang(UserBean user){
		 
		int i=0;
		
		try{
 			
			 Connection conn = DBHelp.getCon();
			 System.out.println("test+++++"+user.getStatu());
			 System.out.println("test+++++"+user.getIname());
			
			 String sql = "UPDATE us set statu='"+user.getStatu()+"' where iname='"+user.getIname()+"'";
			 PreparedStatement stm=conn.prepareStatement(sql);
			 
			 i=stm.executeUpdate();
	
			}catch(SQLException e){
				
				e.printStackTrace();

				
			}
	return i;
	}
	
	public int passch(UserBean user){
		 
		int i=0;
		
		try{
 			
			 Connection conn = DBHelp.getCon();
			 System.out.println("test+++++"+user.getStatu());
			 System.out.println("test+++++"+user.getIname());
			
			 String sql = "UPDATE us set pwd='"+user.getPwd()+"' where iname='"+user.getIname()+"'";
			 PreparedStatement stm=conn.prepareStatement(sql);
			 
			 i=stm.executeUpdate();
	
			}catch(SQLException e){
				
				e.printStackTrace();

				
			}
	return i;
	}
	

}
