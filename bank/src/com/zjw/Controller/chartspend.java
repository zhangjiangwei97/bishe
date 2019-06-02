package com.zjw.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjw.tools.DBHelp;

public class chartspend extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public chartspend() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
	    	 Connection  conn=DBHelp.getCon();
	    	 
	    	 //String sql="select * from test";		
		     //ResultSet rs = statement.executeQuery(sql);
		     Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); //查询语句 
		     String sql="select sum(wg) as onlinesp,sum(xf) as userspend,sum(zz) as zhz,sum(qmoney) as oth from spend a inner join trans b on a.id=b.num"; 
		     conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); //执行查询 ResultSet rs=stmt.executeQuery(query);
		     ResultSet rs = stmt.executeQuery(sql);
		     JSONArray jsonarray = new JSONArray();  
		     JSONObject jsonobj = new JSONObject(); 
			while(rs.next()) { 
				
				jsonobj.put("onlinesp", rs.getString(1));  
			    jsonobj.put("userspend", rs.getString(2));  
				jsonobj.put("zhz", rs.getString(3)); 
				jsonobj.put("oth", rs.getString(4)); 
                jsonarray.add(jsonobj); 

				}
		//	String test="{\"id\":\""+a+"\",\"name\":\""+b+"\"}"; 
		/*	String[] strs=str.split(",");
			response.setCharacterEncoding("utf-8"); 
			PrintWriter out = response.getWriter();
			out.print(str);
			out.print(a);
			*/
			//String jsonStr =JSON.toJSONString("{\"id\":\"123\",\"name\":\"小黎\"}");
			//String jsonStr ="{\"id\":\"123\",\"name\":\"小黎\"}";

			//String jsonStr=JSON.toJSONString(test);
			System.out.println("zzzzzzzzzzzzzzzzzzzzzz"+jsonarray);
			 String jsonStr=JSON.toJSONString(jsonarray);
			 PrintWriter out =null ;
			 out =response.getWriter() ;
			// out.print(b);
			 //out.write(jsonStr);
			 out.print(jsonStr);
			// out.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
