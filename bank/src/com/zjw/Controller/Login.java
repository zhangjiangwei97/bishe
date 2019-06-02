package com.zjw.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.zjw.bean.AdminBean;
import com.zjw.bean.UsersBean;
import com.zjw.service.ScoreService;
import com.zjw.service.UserService;
import com.zjw.service.UsersService;
import com.zjw.service.AdminService;
import com.zjw.tools.DBHelp;
public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
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
		String userName=request.getParameter("username");
		String password=request.getParameter("psw");
		UserService us=new UserService();
		int log = us.loginSuccess(userName, password);
		String a = us.research(userName);
		String statu = us.userstat(userName);
		String kahao = us.userkahao(userName);
		System.out.print("xinyongka"+a);
		System.out.print("stat"+statu);
		System.out.print("zjwkahao"+kahao);
		AdminService ad=new AdminService();
		boolean flag = ad.loginSuccess(userName, password);
		HttpSession session=request.getSession();
		
		
		if(log==1){
			
			session.setAttribute("login_user", userName);
			response.sendRedirect("mainpage.jsp?test=A");
			
			
		}
		if(log==2){
			if(statu.equals("0")){
			session.setAttribute("getidno", a);
			//System.out.print(b)
			System.out.println();
			session.setAttribute("kahao", kahao);
			session.setAttribute("login_user", userName);
			response.sendRedirect("mainpage.jsp?test=C");}
			else{
				session.setAttribute("kahao", kahao);
				session.setAttribute("getidno", a);
				session.setAttribute("login_user", userName);
				response.sendRedirect("mainpage.jsp?test=D");
				
				
			}
			
		}
		else if(flag){
			
			session.setAttribute("login_user", userName);
			response.sendRedirect("mainpage.jsp?test=B");
			
			
		}
		else{
			response.addHeader("refresh","5;url=\"index.jsp\"");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("请确认用户名及密码是否正确，若5秒未跳转，请点击<a href=\"index.jsp\">重新登录</a>");}
			
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
