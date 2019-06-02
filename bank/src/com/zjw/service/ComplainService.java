package com.zjw.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjw.bean.CardBean;
import com.zjw.bean.Complain;
import com.zjw.tools.DBHelp;

public class ComplainService {

	public boolean  complainWrite(Complain cm){
		Connection  conn=DBHelp.getCon();
		String sql="insert into comp values(?,?,?)";
		PreparedStatement stm=null;
		
		try {
			stm=conn.prepareStatement(sql);
			System.out.println("zjw="+cm.getName());
			stm.setString(1, cm.getName());
			stm.setString(2, cm.getTalk());
			stm.setString(3, cm.getSys_time());
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
	public List readFirstTitle(){
        List<Complain> list =new ArrayList<Complain>();
        Connection  con=DBHelp.getCon();
        PreparedStatement psmt=null;
        ResultSet rs=null;
        
        
        try {
            String sql="select * from comp";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            
            while(rs.next())
            {
                //int id=rs.getInt("id");
                String name=rs.getString("name");
                String talk=rs.getString("talk");
                String sys_time=rs.getString("sys_time");
                //Date createTime=rs.getDate("createTime");
                Complain tl=new Complain(name, talk, sys_time);
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
}
