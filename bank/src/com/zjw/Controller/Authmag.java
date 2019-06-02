package com.zjw.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjw.bean.UserBean;
import com.zjw.service.UserService;

public class Authmag extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Authmag() {
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

		//System.out.println("test+++++"+id);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		/*String name=request.getParameter("name");
		String yeck=request.getParameter("yeck");
		System.out.println("test+++++"+name);
		System.out.println("test+++++"+yeck);
		String jyck=request.getParameter("jyck");
		System.out.println("test+++++"+jyck);
		
		if(yeck.equals("余额查看")&&jyck.equals("")){			
			String yeckt = "1";
			UserBean user= new UserBean(name,"","",0,yeckt);
			UserService u=new UserService();
			if(u.usermang(user)){
				
				response.addHeader("refresh","1;url=\"user_mang.jsp\"");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("成功操作，3秒后返回！");}
			else{
				response.addHeader("refresh","1;url=\"user_mang.jsp\"");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("成功失败，3秒后返回！");}
			}
			
			else if(jyck.equals("禁用余额")&&yeck.equals("")){
				String jyckt = "0";
				UserBean user= new UserBean(name,"","",0,jyckt);
				UserService u=new UserService();
				if(u.usermang(user)){
					
					response.addHeader("refresh","1;url=\"user_mang.jsp\"");
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.print("成功操作，3秒后返回！");}
				else{
					response.addHeader("refresh","1;url=\"user_mang.jsp\"");
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.print("成功失败，3秒后返回！");}
		}*/
		String name=request.getParameter("name");
		String yeck=request.getParameter("yeck");
		System.out.println("test+++++"+name);
		System.out.println("test+++++"+yeck);
		String jyck=request.getParameter("jyck");
		System.out.println("test+++++"+jyck);
		String[]test=request.getParameterValues("test");
		for(int i=0;i<test.length;i++) {
			if(test[i].equals("0")) {		
				String yeckt = "1";
				System.out.println("test+++++zz"+name);
				UserBean user= new UserBean(name,"","","0",yeckt);
				UserService u=new UserService();
				if(u.usermang(user)==1){
					
					response.addHeader("refresh","1;url=\"user_mang.jsp\"");
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.print("成功操作，3秒后返回！");}
				else{
					response.addHeader("refresh","1;url=\"user_mang.jsp\"");
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.print("操作失败，3秒后返回！");}
				}else {	
					String jyckt = "0";
					UserBean user= new UserBean(name,"","","0",jyckt);
					UserService u=new UserService();
					if(u.usermang(user)==1){
						
						response.addHeader("refresh","1;url=\"user_mang.jsp\"");
						response.setCharacterEncoding("utf-8");
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
						out.print("成功操作，3秒后返回！");}
					else{
						response.addHeader("refresh","1;url=\"user_mang.jsp\"");
						response.setCharacterEncoding("utf-8");
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
						out.print("操作失败，3秒后返回！");
				}}
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
