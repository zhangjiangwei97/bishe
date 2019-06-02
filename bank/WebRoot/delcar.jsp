<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>购物车主页面</title> </head>  
  <body>
  <% String action=request.getParameter("action");   
     ArrayList goods=(ArrayList)session.getAttribute("goods");
     if (action.equals("clear")){goods.clear();
       session.setAttribute("sum", 0);
       response.sendRedirect("showcar.jsp");}
     else if(action.equals("delete")){
       int i=Integer.parseInt(request.getParameter("id"));
     goods.remove(i);
     session.setAttribute("sum", 0);
     response.sendRedirect("showcar.jsp");
     }%>
    
  </body>
</html>
