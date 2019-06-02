package com.zjw.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjw.bean.CardBean;
import com.zjw.bean.UsersBean;
import com.zjw.service.CardService;
import com.zjw.service.UsersService;

public class Usermang extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Usermang() {
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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String u_ser=request.getParameter("u_ser");
		//System.out.println("test+++++"+u_ser);
		String se=request.getParameter("test");
		String num=request.getParameter("num");
		if(se.equals("vip")){			
			String vip = "1";
			UsersBean us= new UsersBean("",u_ser,"","","",vip,"","");
			UsersService u=new UsersService();
			if(u.usermang(us)){
				
				response.addHeader("refresh","1;url=\"user_man.jsp\"");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("成功操作，3秒后返回！");}
			else{
				response.addHeader("refresh","1;url=\"user_man.jsp\"");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("成功失败，3秒后返回！");}
			}
			
			else{
				String comm = "0";
				UsersBean us= new UsersBean("",u_ser,"","","",comm,"","");
				UsersService u=new UsersService();
				if(u.usermang(us)){
					
					response.addHeader("refresh","1;url=\"user_man.jsp\"");
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.print("成功操作，3秒后返回！");}
				else{
					response.addHeader("refresh","1;url=\"user_man.jsp\"");
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.print("成功失败，3秒后返回！");}
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
