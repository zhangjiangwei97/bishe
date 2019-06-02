package com.xjh.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xjh.bean.UsersBean;
import com.xjh.tools.DBHelp;

public class UsersService {
	//判断用户名在数据库表users是否已经被注册过
	public boolean checkUsernameValid(UsersBean user){
		//连接数据库
		Connection  conn=DBHelp.getCon();
		String sql="select * from users where username=?";
		ResultSet rs=null;
		PreparedStatement stm=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1, user.getUsername());
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
	public boolean  registerWriteDB(UsersBean user){
		Connection  conn=DBHelp.getCon();
		String sql="insert into users values(?,?,?,?)";
		PreparedStatement stm=null;
		
		try {
			stm=conn.prepareStatement(sql);
			System.out.println("xujinghong1 registerWriteDB username="+user.getUsername());
			stm.setString(1, user.getUsername());
			stm.setString(2, user.getPwd());
			stm.setString(3, user.getEmail());
			stm.setString(4, user.getTel());
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

}
