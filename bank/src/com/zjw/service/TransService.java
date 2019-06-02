package com.zjw.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjw.bean.CardBean;
import com.zjw.bean.TraflowBean;
import com.zjw.bean.TransBean;
import com.zjw.tools.DBHelp;

public class TransService {

	
	public boolean  transWrite(TransBean cd){
		Connection  conn=DBHelp.getCon();
		String sql="insert into trans values(?,?,?,?)";
		PreparedStatement stm=null;
		
		try {
			stm=conn.prepareStatement(sql);
			stm.setString(1, cd.getNum());
			stm.setInt(2, cd.getCmoney());
			stm.setInt(3, cd.getQmoney());
			stm.setString(4, cd.getOperatime());
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
        List<TraflowBean> list =new ArrayList<TraflowBean>();
        Connection  con=DBHelp.getCon();
        PreparedStatement psmt=null;
        ResultSet rs=null;
        
        
        try {
            String sql="select card.num,name,cmoney,qmoney,operatime from trans,Users,card where trans.num=card.num and card.id=Users.id;";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            
            while(rs.next())
            {
             
                String num=rs.getString("num");
                String name=rs.getString("name");
                int cmoney=rs.getInt("cmoney");
                int qmoney=rs.getInt("qmoney");
                String operatime=rs.getString("operatime");
              
                TraflowBean tl=new TraflowBean(num,name,cmoney,qmoney,operatime);
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
