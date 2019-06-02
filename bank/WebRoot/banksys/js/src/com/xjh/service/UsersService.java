package com.xjh.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xjh.bean.UsersBean;
import com.xjh.tools.DBHelp;

public class UsersService {
	//�ж��û��������ݿ��users�Ƿ��Ѿ���ע���
	public boolean checkUsernameValid(UsersBean user){
		//�������ݿ�
		Connection  conn=DBHelp.getCon();
		String sql="select * from users where username=?";
		ResultSet rs=null;
		PreparedStatement stm=null;
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1, user.getUsername());
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

}
