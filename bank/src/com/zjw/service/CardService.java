package com.zjw.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjw.bean.CardBean;
import com.zjw.tools.DBHelp;

public class CardService {

	public boolean  cardWrite(CardBean cd){
		Connection  conn=DBHelp.getCon();
		String sql="insert into card values(?,?,?,?,?,?,?,?)";
		PreparedStatement stm=null;
		
		try {
			stm=conn.prepareStatement(sql);
			System.out.println("zjw="+cd.getId());
			stm.setString(1, cd.getId());
			stm.setString(2, cd.getU_ser());
			stm.setString(3, cd.getNum());
			stm.setString(4, cd.getCreate_date());
			stm.setString(5, cd.getExpire_date());
			stm.setInt(6, cd.getLimited());
			stm.setInt(7, cd.getLimited());
			stm.setString(8, cd.getBilldate());
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
        List<CardBean> list =new ArrayList<CardBean>();
        Connection  con=DBHelp.getCon();
        PreparedStatement psmt=null;
        ResultSet rs=null;
        
        
        try {
            String sql="select * from card";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            
            while(rs.next())
            {
             
                String u_ser=rs.getString("u_ser");
                String num=rs.getString("num");
                String create_date=rs.getString("create_date");
                String expire_date=rs.getString("expire_date");
                int limited=rs.getInt("limited");
                int balance=rs.getInt("balance");
                String billdate=rs.getString("billdate");
              
                CardBean tl=new CardBean("",u_ser, num, create_date,expire_date,limited,balance,billdate);
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
	
	public List readFirstTitle1(String getidno){
        List<CardBean> list =new ArrayList<CardBean>();
        Connection  con=DBHelp.getCon();
        PreparedStatement psmt=null;
        ResultSet rs=null;
        
        
        try {
            String sql="select us.idno,u_ser,num,limited,balance,expire_date,create_date,billdate from card,us,Users where us.idno=Users.idNo and Users.id=card.id and us.idno='"+getidno+"'";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            
            while(rs.next())
            {
             
                String u_ser=rs.getString("u_ser");
                String num=rs.getString("num");
                String create_date=rs.getString("create_date");
                String expire_date=rs.getString("expire_date");
                int limited=rs.getInt("limited");
                int balance=rs.getInt("balance");
                String billdate=rs.getString("billdate");
              
                CardBean tl=new CardBean("",u_ser, num, create_date,expire_date,limited,balance,billdate);
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
public boolean cardmang(CardBean c){
		
		try{
 			
			 Connection conn = DBHelp.getCon();
			 System.out.println("zzzzzzz"+c.getBalance());
			 String sql = "UPDATE card set balance -='"+c.getBalance()+"' where num='"+c.getNum()+"'";
			 PreparedStatement stm=conn.prepareStatement(sql);
			 stm.executeQuery();
	
			}catch(SQLException e){
				
				e.printStackTrace();

				
			}
	return true;
	}
	public boolean cardmoc(CardBean c){
	
	try{
			
		 Connection conn = DBHelp.getCon();
		 System.out.println("zzzzzzz"+c.getBalance());
		 String sql = "UPDATE card set balance +='"+c.getBalance()+"' where num='"+c.getNum()+"'";
		 PreparedStatement stm=conn.prepareStatement(sql);
		 stm.executeQuery();

		}catch(SQLException e){
			
			e.printStackTrace();

			
		}
	return true;
}
	
}
