<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>信用卡管理中心</title> 
    
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
    <script src="banksys/js/base-loading.js"></script>
    <script src="js/jquery.js"></script>  

  </head>
  
  <body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1>信用卡管理系统</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 退出登录</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;</div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  
  
   <%String flag_z=request.getParameter("test");
		   if(flag_z.equals("B")) {%>
    <h2><span class="icon-user"></span>账户管理</h2>
    <ul>
	<li><a href="info.jsp" target="right"><span class="icon-caret-right"></span>账户添加</a></li>
    <li><a href="maintain.jsp" target="right"><span class="icon-caret-right"></span>信息维护</a></li>
    <li><a href="deposit.jsp" target="right"><span class="icon-caret-right"></span>柜台还款</a></li>  
    <li><a href="withdraw.jsp" target="right"><span class="icon-caret-right"></span>柜台取款</a></li>   
    <li><a href="bill.jsp" target="right"><span class="icon-caret-right"></span>账单查询</a></li>         
	</ul>	
		<%}else if(flag_z.equals("A")){ %>
		     <h2><span class="icon-user"></span>账户</h2>
    <ul>
			 <li><a href="pass_u.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
	</ul>
		<%}
		else if(flag_z.equals("C")||flag_z.equals("D")){ %>
		     <h2><span class="icon-user"></span>账户</h2>
    <ul>
			 <li><a href="pass_u.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
			 <li><a href="bookS.jsp" target="right"><span class="icon-caret-right"></span>账单查询</a></li>
	</ul>
		<%}
		
		
		 %>
     
  
    <%String flag=request.getParameter("test");
		   if(flag.equals("B")) {%>
	<h2><span class="icon-th-large"></span>后台管理</h2>
  <ul>
	<li><a href="user.jsp" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
    <li><a href="user_mang.jsp" target="right"><span class="icon-caret-right"></span>用户权限管理</a></li>
    <li><a href="showcomplain.jsp" target="right"><span class="icon-caret-right"></span>用户投诉</a></li>
    <li><a href="upload.jsp" target="right"><span class="icon-caret-right"></span>帮助管理</a></li>          
  </ul>	
		<%}else if(flag.equals("A")||flag.equals("C")||flag.equals("D")){ %>
		<h2><span class="icon-th-large"></span>投诉</h2>
  <ul>
			 <li><a href="complain.jsp" target="right"><span class="icon-caret-right"></span>用户投诉</a></li>
			 <li><a href="help.jsp" target="right"><span class="icon-caret-right"></span>帮助管理</a></li>
  </ul> 
		<%} %>
         
      <%String flag_tz=request.getParameter("test");
		   if(flag_tz.equals("D")) {%>
	<h2><span class="icon-pencil-square-o"></span>积分</h2>
  <ul>
    <li><a href="listshop.jsp" target="right"><span class="icon-caret-right"></span>积分兑换</a></li>
    <li><a href="showcar.jsp" target="right"><span class="icon-caret-right"></span>兑换结算</a></li> 
  </ul>	
		<%} 		
		%> 
		
  	  <%String flag_t=request.getParameter("test");
		   if(flag_t.equals("B")) {%>
	<h2><span class="icon-pencil-square-o"></span>报表管理</h2>
  <ul>
    <li><a href="opacct.jsp" target="right"><span class="icon-caret-right"></span>开户查看</a></li>
    <li><a href="account.jsp" target="right"><span class="icon-caret-right"></span>开户统计</a></li>
    <li><a href="opcard.jsp" target="right"><span class="icon-caret-right"></span>开卡查看</a></li>
    <li><a href="carcount.jsp" target="right"><span class="icon-caret-right"></span>开卡统计</a></li>
    <li><a href="transflow.jsp" target="right"><span class="icon-caret-right"></span>交易流水</a></li>
    <li><a href="spendcount.jsp" target="right"><span class="icon-caret-right"></span>流水统计</a></li>          
  </ul>	
		<%}else if(flag.equals("C")){ %>
	<h2><span class="icon-pencil-square-o"></span>交易</h2>
  <ul>
	<li><a href="cate.html" target="right"><span class="icon-caret-right"></span>消费查看</a></li>
    <li><a href="cate.html" target="right"><span class="icon-caret-right"></span>消费统计</a></li> 
  </ul>	
		<%} 		
		%>
            
  
  <%String flag_k=request.getParameter("test");
		   if(flag_k.equals("B")) {%>
  <h2><span class="icon-magic"></span>信用卡管理</h2>  
  <ul>
    <li><a href="bankcard.jsp" target="right"><span class="icon-caret-right"></span>开卡</a></li>
    <li><a href="user_man.jsp" target="right"><span class="icon-caret-right"></span>维护管理</a></li>    
  </ul>          
		
		<%}else if(flag.equals("A")){ %>
 
		<%} %>

</div>
<script src="banksys/js/time.js"></script>
<script src="banksys/js/shouye.js"></script>
<ul class="bread">
  <li><a href="bank_backg.html" target="right" class="icon-home"> 首页</a></li>
  <li><a>网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
  <img src="banksys/img/skin_/time.png" alt="" />
  <span id="time" style="float:right"></span>
  <span id="hours"></span></li>
</ul>

<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="bank_backg.html" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
  </body>
  <script src="banksys/js/time.js"></script>
</html>
