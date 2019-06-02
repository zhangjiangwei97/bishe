package com.zjw.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjw.bean.AdminBean;
import com.zjw.bean.UsersBean;
import com.zjw.service.UsersService;
import com.zjw.service.AdminService;
import com.zjw.tools.DBHelp;
public class Chartacc extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Chartacc() {
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
			     String sql="select top 6 accban,count(*) as num from Users group by accban"; 
			     conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); //执行查询 ResultSet rs=stmt.executeQuery(query);
			     ResultSet rs = stmt.executeQuery(sql);
			     //JSONArray jsonarray = new JSONArray();
			    
			     JSONArray jsonarray = new JSONArray();

	
	
				while(rs.next()) { 
					ResultSetMetaData data=rs.getMetaData();

					JSONObject json_object=new JSONObject();
	                for(int i=1;i<=data.getColumnCount();++i){
	                    //列名
	                    String columnName=data.getColumnName(i);
	                    String rst=rs.getString(i);
	                    json_object.put(columnName, rst);
	                }
	                
	                jsonarray.add(json_object);

				/*	System.out.println("id"+rs.getString(1));
					System.out.println("name"+rs.getString(2));
					System.out.println("pwd"+rs.getString(3));
					jsonobj.put("id", rs.getString(1));  
				    jsonobj.put("name", rs.getString(2));  
					jsonobj.put("pwd", rs.getString(3)); 
					jsonobj.put("z", rs.getString(4));
					jsonobj.put("j", rs.getString(5));
					jsonarray.add(jsonobj); 
                    */
				//	s.append(rs.getString(2)); 
				//	if(!rs.isLast()) 
					//{ s.append("、"); }
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