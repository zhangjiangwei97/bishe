package com.xjh.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xjh.bean.GoodsBean;
import com.xjh.service.GoodsService;

public class MainPageController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MainPageController() {
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

         doPost(request,response);
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
		//获取传递过来的参数
		int category=Integer.parseInt(request.getParameter("category"));
		int page=Integer.parseInt(request.getParameter("page"));
		int pagecounts=Integer.parseInt(request.getParameter("pagecounts"));

		//准备主页面需要的数据
		GoodsService gs= new GoodsService();
		ArrayList<GoodsBean> arr=gs.getGoodsList(category, page, pagecounts);
		//把数据放到request
		request.setAttribute("goodsArr", arr);
		
		//跳转到整正的主页面
		//response.sendRedirect("./mainPage.jsp");
		request.getRequestDispatcher("./mainPage.jsp").forward(request, response);
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
