package com.xjh.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xjh.bean.UsersBean;
import com.xjh.service.UsersService;
import com.xjh.tools.DBHelp;

public class RegisterContrller extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterContrller() {
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
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
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
    //提取注册界面发送过来的数据
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("user_name");
		System.out.println("xujinghong =username"+username);
		String email=request.getParameter("user_email");
		String pwd=request.getParameter("user_password");
		String tel=request.getParameter("user_phone1");
	//把提取到的数据封装到与数据库表对应的java类的对象里
		UsersBean user= new UsersBean(username,pwd,email,tel);
		UsersService us=new UsersService();
		if(us.checkUsernameValid(user)){//用户名合法 
			 //把数据插入到数据库的表uses
			us.registerWriteDB(user);
			//把用户的当前信息写入到session中
			HttpSession session=request.getSession();
			session.setAttribute("login_user", user);
//			request.getRequestDispatcher("index.jsp").forward(request, response);//跳转到购物主页面index.jsp
		    response.sendRedirect("index.jsp");
		}else{
			response.addHeader("refresh", "5;url=\"register.jsp\"");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print("用户名已经存在，请重新注册 ，若5秒内未跳转，请点击<a href=\"register.jsp\"> 注册</a>");
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
