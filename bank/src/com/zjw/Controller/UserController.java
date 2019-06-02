package com.zjw.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjw.bean.UserBean;
import com.zjw.service.UserService;

public class UserController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserController() {
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
		String us=request.getParameter("name");
		System.out.println("aaaaaaaaaaaaaaaa"+us);		
		String pwd=request.getParameter("pwd");
		System.out.println("ccccccccccccccc"+pwd);
		String iname=request.getParameter("name");
		UserBean u = new UserBean(us,pwd,"","0","");
		UserBean u2 = new UserBean(iname,"","","0","");
		UserService user = new UserService();
		int flag = user.userch(u);
		int flag2 = user.userdel(u2);
		if(flag==1){
			response.addHeader("refresh","1;url=\"user.jsp\"");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("成功操作，1秒后返回！");
			
		}
		else{
			response.addHeader("refresh","1;url=\"user.jsp\"");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("操作失败，1秒后返回！");
			
			
		}
		if(flag2==1){
			response.addHeader("refresh","1;url=\"userdel.jsp\"");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("成功操作，1秒后返回！");
			
			
		}
		else{
			response.addHeader("refresh","1;url=\"userdel.jsp\"");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("操作失败，1秒后返回！");
			
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
