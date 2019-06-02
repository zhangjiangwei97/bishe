package com.zjw.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zjw.bean.ScoreBean;
import com.zjw.tools.DBHelp;

public class ScoreService {

	
public int scorej(ScoreBean score){
		
		int i = 0;
		try{
 			 
			 Connection conn = DBHelp.getCon();
			 System.out.println("test+++++"+score.getId());
			 String sql = "UPDATE user_score set score-='"+score.getScore()+"' where id='"+score.getId()+"'";
			 PreparedStatement stm=conn.prepareStatement(sql);

			 i=stm.executeUpdate();
			 
			}catch(SQLException e){
				
				e.printStackTrace();

				
			}
	return i;
	}
	
public String userscore(String u){
	String sql = "select score from user_score where id='"+u+"'";
	 
	 Statement stmt = null;
	 ResultSet rs = null;
	 String score = null;

		
		try{
			Connection conn = DBHelp.getCon();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql);
			while(rs.next()){
				
				score =rs.getString("score");
				//System.out.print("statuzjw"+statu);
				//System.out.print("11111111"+rs.getString("statu"));
			}				 
		
			}catch(SQLException e){
				
				e.printStackTrace();

				
			}
	return score;
	}
	
public int up_userc(ScoreBean sc){  
	
	Connection  conn=DBHelp.getCon();
	int i = 0;
	String sql="insert into user_score values(?,?,?,?)";
	PreparedStatement stm=null;
	try {
		stm=conn.prepareStatement(sql);
		stm.setString(1, sc.getId());
		stm.setInt(2, sc.getScore());
		stm.setString(3, sc.getDataSrc());
		stm.setString(4, sc.getCreate_date());
		i =stm.executeUpdate();
						
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		
		DBHelp.closeDBResource(null, stm, conn);
	}
	return i;	

}
}
