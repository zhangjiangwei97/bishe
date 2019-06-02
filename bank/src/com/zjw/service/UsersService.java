package com.zjw.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zjw.bean.AdminBean;
import com.zjw.bean.Complain;
import com.zjw.bean.UsersBean;
import com.zjw.tools.DBHelp;

public class UsersService {
	//判断用户名在数据库表users是否已经被注册过
	public boolean checkUsernameValid(UsersBean user){
		//连接数据库
		Connection  conn=DBHelp.getCon();
		String sql="select * from U_ser where name=?";
		ResultSet rs=null;
		PreparedStatement stm=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(2, user.getName());
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
	
	public boolean  userWrite(UsersBean user){
		Connection  conn=DBHelp.getCon();
		String sql="insert into Users values(?,?,?,?,?,?,?,?)";
		PreparedStatement stm=null;
		
		try {
			stm=conn.prepareStatement(sql);
			System.out.println("zjw="+user.getName());
			System.out.println("zjw="+user.getStat());
			stm.setString(1, user.getId());
			stm.setString(2, user.getName());
			stm.setString(3, user.getGender());
			stm.setString(4, user.getTel());
			stm.setString(5, user.getIdNo());
			stm.setString(6, user.getStatu());
			stm.setString(7, user.getStat());
			stm.setString(8, user.getAccban());
			int num=stm.executeUpdate();
			if(num==1)//说明影响的行数是一条，说明数据插入成功
				return true;						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBHelp.closeDBResource(null, stm, conn);
		}
		return false;	
	}
	
	
	public boolean loginSuccess(String userName,String password){
		 boolean returnValue = false;
		 String sql = "SELECT * FROM Users";
		 
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
	
	public boolean sucess(String userName,String password){
		 boolean returnValue = false;
		 String sql = "SELECT * FROM U_ser";
		 
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
		 
		 }
	public List readFirstTitle(){
        List<UsersBean> list =new ArrayList<UsersBean>();
        Connection  con=DBHelp.getCon();
        PreparedStatement psmt=null;
        ResultSet rs=null;
        
        
        try {
            String sql="select * from Users";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            
            while(rs.next())
            {
            	String id=rs.getString("id");
                String name=rs.getString("name");
                String Gender=rs.getString("Gender");
                String Tel=rs.getString("Tel");
                String idNo=rs.getString("idNo");
                String statu=rs.getString("statu");
                String stat=rs.getString("stat");
                String accban=rs.getString("accban");
                UsersBean tl=new UsersBean(id,name,Gender,Tel,idNo,statu,stat,accban);
                list.add(tl);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            try {
                if(rs!=null)
                {
                    rs.close();
                }
                if(psmt!=null)
                {
                    psmt.close();
                }
                if(con!=null)
                {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
	public boolean usermang(UsersBean user){
		
		try{
 			
			 Connection conn = DBHelp.getCon();
			
			 String sql = "UPDATE Users set statu='"+user.getStatu()+"' where name='"+user.getName()+"'";
			 PreparedStatement stm=conn.prepareStatement(sql);
			 stm.executeUpdate();
	
			}catch(SQLException e){
				
				e.printStackTrace();

				
			}
	return true;
	}
	public int cgtel(UsersBean user){
		
		 int i=0;
		 try{
			 Connection conn = DBHelp.getCon();
				
			 String sql = "UPDATE Users set tel='"+user.getTel()+"' where name='"+user.getName()+"'";
			 PreparedStatement stm=conn.prepareStatement(sql);
			 
			 i = stm.executeUpdate();
		
			 
			
			 
			 }
			catch(SQLException e){
	
					e.printStackTrace();

			}
		 return i;
		}
	





}
		 
