<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>购物车主页面</title>
	</head>
	<body>
		<form method="post" name="">
			<p>
				&nbsp;
			</p>
			<p>
				&nbsp;
			</p>
			<p>
				&nbsp;
			</p>
			<p>
				&nbsp;
			</p>
			<p>
				&nbsp;
			</p>
			<p align="center">
				<strong>您选购的商品如下：</strong>
				<br>
				<hr color="red"/>
			</p>
			<%=request.getSession().getAttribute("goods")%>
			
			<%
			 ArrayList list = (ArrayList) request.getSession().getAttribute("goods");
			 
			  if(list!=null||list.size()!=0){
			  response.sendRedirect("listshop.jsp");}
			  else { out.print("<script language='javascript'>alert('请选择你要购买的商品');</script>");
			  response.setHeader("refresh","i:url=buy.jsp");}	  
						 %>
			<div align="center"><a href="showcar.jsp">清空购物车</a></div>
		</form>
	</body>
</html>

