<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>中国某某银行登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
	<link rel="stylesheet" type="text/css" href="banksys/css/style.css" />
	<link rel="stylesheet" type="text/css" href="banksys/css/skin_/login.css" />
	<script type="text/javascript" src="banksys/js/jquery.js"></script>
	<script type="text/javascript" src="banksys/js/jquery.select.js"></script>
  </head>

  <body>
  <form  action="Login" method="post">
    <div id="container">
    <div id="bd">
    	<div id="main">
        	<div class="login-box">
                <div id="logo"></div>
                <h1></h1>
                <div class="input username" id="username">
                    <label for="username">用户名</label>
                    <span></span>
                    <input type="text" id="username" name="username"/>
                </div>
                <div class="input psw" id="psw">
                    <label for="psw">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                    <span></span>
                    <input type="password" id="psw" name="psw"/>
                </div>
               
                
                <div id="btn" class="loginButton">
                
                    <input type="submit" class="button" value="登录" onclick="return Login();"/>
                    <a href="reg.jsp">注册</a>
                </div>
            </div>
        </div>
        <div id="ft">CopyRight&nbsp;2018&nbsp;&nbsp;版权所有&nbsp;&nbsp;上海建桥学院&nbsp;&nbsp;&nbsp;&nbsp; - Creative person 张江伟&nbsp;&nbsp;</div>
    </div>
   
</div>
</form>
  </body>
  <script type="text/javascript">
	var height = $(window).height() > 445 ? $(window).height() : 445;
	$("#container").height(height);
	var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
	$('#bd').css('padding-top', bdheight);
	$(window).resize(function(e) {
        var height = $(window).height() > 445 ? $(window).height() : 445;
		$("#container").height(height);
		var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
		$('#bd').css('padding-top', bdheight);
    });
	$('select').select();
	
	$('.loginButton').click(function(e) {
        document.location.href = "";
    });
</script>
</html>
