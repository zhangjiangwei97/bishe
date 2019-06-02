package com.zjw.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjw.bean.CardBean;
import com.zjw.bean.UsersBean;
import com.zjw.service.CardService;
import com.zjw.service.UsersService;
import com.zjw.tools.DBHelp;

public class Mimachg extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Mimachg() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		
	//	HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String u_ser=request.getParameter("u_ser");
		System.out.println("biaoshi"+u_ser);
		
		String tel=request.getParameter("tel");
		System.out.println("biaoshi"+tel);
		UsersBean u=new UsersBean("",u_ser,"",tel,"","","","");
		UsersService us=new UsersService();
		int flag = us.cgtel(u);
		if(flag==1){
			
			response.addHeader("refresh","3;url=\"maintain.jsp\"");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("修改手机号成功，3秒后返回！");
			
			
		}
		else{
			
			response.addHeader("refresh","3;url=\"maintain.jsp\"");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("信息错误，请重新输入，3秒后返回！");
			
			
		}
	
	/*		try{
				 
				// UsersBean user = (UsersBean)session.getAttribute("login_user");
				// String us= user.getName();
				 Connection conn = DBHelp.getCon();
				 String sql = "UPDATE Users set pwd='"+pwden+"' where name='"+u_ser+"'";
				 PreparedStatement stm=conn.prepareStatement(sql);
				 stm.executeQuery();
		
	}catch(SQLException e){
		
	e.printStackTrace();
	
	
	
	}*/
		//UsersBean us= new UsersBean(id,name,pwd,Gender,tel,idno);
		//UsersService u=new UsersService();
		//CardBean cdb= new CardBean("",u_ser,num,create_date,expire_date,limited,"0",billdate);
		//CardService cd=new CardService();
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
