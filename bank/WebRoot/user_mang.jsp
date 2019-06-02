<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zjw.service.UsersService"%>
<%@page import="com.zjw.bean.UsersBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>  
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8"/>   
	<link rel="stylesheet" href="banksys/css/bootstrap.min.css">  
	<link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
	<script src='banksys/js/bootstrap.min.js'></script>
	    <style>
.demo--label{margin:20px 20px 0 0;display:inline-block}.demo--radio{display:none}.demo--radioInput{background-color:#fff;border:2px solid rgba(0,0,0,0.15);border-radius:100%;display:inline-block;height:36px;margin-right:10px;margin-top:-1px;vertical-align:middle;width:36px;line-height:1}.demo--radio:checked + .demo--radioInput:after{background-color:#00A1E9;border-radius:100%;content:"";display:inline-block;height:26px;margin-left:5px;margin-top:5px;width:26px}.demo--checkbox.demo--radioInput,.demo--radio:checked + .demo--checkbox.demo--radioInput:after{border-radius:0}.demo--radio:checked + .demo--radioInput{border:2px solid #00A1E9;}


    </style>
  </head>
  
    <body>
    <form method="post" class="form-x" action="Authmag">
    <input type="text" name="name" class="form-control" placeholder="请输入用户名">
    <label class="demo--label">    <input class="demo--radio" type="radio" name="test" value="0">    <span class="demo--radioInput"></span>余额查看</label><label class="demo--label">    <input class="demo--radio" type="radio" name="test" value="1">    <span class="demo--radioInput"></span>禁用查看</label>
	<button class="button bg-main icon-check-square-o" type="submit"> 确定</button>
            
    </form>
       
           
  </body>
</html>
