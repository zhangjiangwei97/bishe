package com.zjw.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjw.bean.CardBean;
import com.zjw.bean.ScoreBean;
import com.zjw.bean.UsersBean;
import com.zjw.service.CardService;
import com.zjw.service.ScoreService;
import com.zjw.service.UsersService;

public class Cardinsert extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Cardinsert() {
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
		String id=request.getParameter("id");
		String u_ser=request.getParameter("u_ser");
	//	System.out.println("test+++++"+id);
		HttpSession session=request.getSession();
		String num=request.getParameter("num");
		String create_date=request.getParameter("create_date");
		String expire_date=request.getParameter("expire_date");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String sys_time = df.format(new Date());
		int limited=Integer.parseInt(request.getParameter("limited"));
		String billdate=request.getParameter("billdate");
		//String kahao = (String)session.getAttribute("kahao");
		
		CardBean cdb= new CardBean(id,u_ser,num,create_date,expire_date,limited,limited,billdate);
		CardService cd=new CardService();
		ScoreBean sc = new ScoreBean(num,0,"xiaofei",sys_time);
		ScoreService scs = new ScoreService();

		if(cd.cardWrite(cdb)&&scs.up_userc(sc)==1){
			
			response.addHeader("refresh","5;url=\"bankcard.jsp\"");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("成功操作，3秒后返回！");}
		else{
			
			response.addHeader("refresh","5;url=\"bankcard.jsp\"");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("添加数据失败，3秒后返回！");}
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
