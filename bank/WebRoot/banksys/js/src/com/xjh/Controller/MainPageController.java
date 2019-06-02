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
		//��ȡ���ݹ����Ĳ���
		int category=Integer.parseInt(request.getParameter("category"));
		int page=Integer.parseInt(request.getParameter("page"));
		int pagecounts=Integer.parseInt(request.getParameter("pagecounts"));

		//׼����ҳ����Ҫ������
		GoodsService gs= new GoodsService();
		ArrayList<GoodsBean> arr=gs.getGoodsList(category, page, pagecounts);
		//�����ݷŵ�request
		request.setAttribute("goodsArr", arr);
		
		//��ת����������ҳ��
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
