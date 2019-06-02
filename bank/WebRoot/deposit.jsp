<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网站信息</title> 
    
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
  	<form method="post" class="form-x" action="Cmoney">
    <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 还款操作：</strong></div>
  <div class="body-content">
    
      <div class="form-group">
        <div class="label">
          <label>信用卡</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="cd" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>还款金额</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="cq" value="" />
          <div class="tips"></div>
        </div>
      </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
          <button class="button bg-main icon-check-square-o" type="submit"> 取消</button>
        </div>
      </div>
 
  </div>
   </form>
  </body>
</html>
