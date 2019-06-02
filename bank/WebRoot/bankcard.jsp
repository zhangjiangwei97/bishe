<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>开卡</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="banksys/layui/css/layui.css"> 
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
  
    

  </head>
  
  <body>
    <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 开卡：</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="Cardinsert">
     
      <div class="form-group">
        <div class="label">
          <label>编号</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="id" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>姓名</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="u_ser" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>卡号</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="num" value="" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>开卡时间</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="create_date" placeholder="请选择日期" id="test1">
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>有效期</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="expire_date" placeholder="请选择日期" id="test2">
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>限额</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="limited" value="" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>账单日</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="billdate" placeholder="请选择日期" id="test3">
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 保存</button>
          <button class="button bg-main icon-check-square-o" type="submit"> 重置</button>
        </div>
      </div>
    </form>
  </div>
</div>
  </body>
<script src="banksys/js/laydate/laydate.js"></script>
<script src="banksys/js/laydate/datectl.js"></script>
<script src="banksys/layui/layui.js"></script> 

</html>
