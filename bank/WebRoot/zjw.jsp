<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zjw.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<table id="table1">

</table>
<script>
    /*需要两层遍历的json对象结构*/
    var json = [
        {"firstName":"John" , "lastName":"Doe" },
        {"firstName":"Anna" , "lastName":"Smith"},
        {"firstName":"Peter" , "lastName":"Jones"}
    ];
    for(i = 0; i<getJsonLength(json); i++){
        var html = '<tr>';
        for(var attr in json[i]){
            html+='<td>'+ json[i][attr] +'</td>';
            console.log(json[i][attr]);
        }
        html+='</tr>';
        document.getElementById('table1').innerHTML+= html;
    }
</script>
</body>
</html>
