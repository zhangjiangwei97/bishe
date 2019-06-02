<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zjw.service.CardService"%>
<%@page import="com.zjw.bean.CardBean"%>
<%@page import="com.zjw.bean.UserBean"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>账单查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit"> 
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  

  </head>
  
  <body>
   <form method="post" action="">
     <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 账单查看</strong></div>
    <div class="padding border-bottom">
    </div>
    <table class="table table-hover text-center">
  
       <tr align="center"> 
    	<th width="150" height="33" class="td2">卡号</th>
        <th width="300" class="td2">姓名</th>       
        <th width="300" class="td2">银行卡额度</th>
        <th width="300" class="td2">需归还金额</th>      
        <th width="300" class="td2">账单日</th>    
    </tr> 
        <% 
           String getidno = request.getSession().getAttribute("getidno").toString();
           CardService dao=new CardService();
           List<CardBean> list =dao.readFirstTitle1(getidno);    
           for(CardBean tl:list)
           {%>
          <tr>
              
              <td><%=tl.getNum() %></td>  
              <td><%=tl.getU_ser() %></td>          
              <td><%=tl.getLimited() %></td> 
              <%int t = (tl.getLimited()-tl.getBalance()); if(t>0){%><td><%=tl.getLimited()-tl.getBalance() %></td><%}else{%><td><%=tl.getBalance()-tl.getLimited() %></td><%}%>
              <td><%=tl.getBilldate() %></td> 


          </tr>
            <%}
       %>
        	
    </table>
  </div>
</form>
<script type="text/javascript">

</script>
  </body>
</html>
