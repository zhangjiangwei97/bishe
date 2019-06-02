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
<script type="text/JavaScript"> 
function checktelephone() {
var cellPhone=document.getElementById("tel");
var RegCellPhone = /^([0-9]{11})?$/;
falg=cellPhone.value.search(RegCellPhone);
if (falg==-1){
alert("手机号不合法！");
return false;
}
var id = document.getElementById("id");//用户名
if(id.value.length=="") {
 alert("编号不能为空");
 return false;
}
var name = document.getElementById("name");//用户名
if(name.value.length=="") {
 alert("用户名不能为空");
 return false;
}
var pwd = document.getElementById("pwd");//用户名
if(pwd.value.length=="") {
 alert("密码不能为空");
 return false;
}
var gender = document.getElementById("gender");//用户名
if(gender.value.length=="") {
 alert("用户名不能为空");
 return false;
}
var tel = document.getElementById("tel");//用户名
if(tel.value.length=="") {
 alert("电话号不能为空");
 return false;
}
var idno = document.getElementById("idno");//用户名
if(idno.value.length=="") {
 alert("身份证号不能为空");
 return false;
}

}


</script>
  </head>

  <body>
   <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 开卡人：</strong>
  <a href="user.jsp">修改</a>
  <a href="deluser.jsp">删除</a></div>
  <div class="body-content">
    <form method="post" class="form-x" action="Acctinsert" >
      <div class="form-group">
        <div class="label">
          <label>用户名</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="id" value="" />
          <div class="tips"></div>
        </div>
      </div>         
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" onclick="return checktelephone();"> 提交</button>
          <button class="button bg-main icon-check-square-o" type="submit"> 取消</button>
        </div>
      </div>
    </form>
  </div>
</div>
  </body>
</html>
