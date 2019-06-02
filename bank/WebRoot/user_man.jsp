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
 <meta charset='utf-8'>  
 <link rel="stylesheet" href="banksys/css/bootstrap.min.css">  
 <script src='banksys/js/bootstrap.min.js'></script>
 <link rel="stylesheet" href="css/pintuer.css">
 <link rel="stylesheet" href="css/admin.css">
 <link rel="stylesheet" href="banksys/css/fenye/fenye.css">

</head>  
    <body>
    <form method="post" class="form-x" action="Usermang">
    <div class="padding border-bottom">
    <div class="form-inline">
    <div class="form-group">
    		<input type="text" name="u_ser" class="form-control" placeholder="请输入用户名">
                <select class="form-control" name="test" onchange="selectOnchang(this)">
        	
            <option>普通用户</option>
            <option value="vip">VIP用户</option>
        </select>
              </div>
              <button class="button bg-main icon-check-square-o" type="submit">设定</button>
            </div>
    </div>
    <body onload="goPage(1,6);">  
    <table width="950" cellpadding="0" cellspacing="0" class="table2" align="center">  
    <thead>  
    <tr>  
    <td colspan="6" height="33" class="td0"> </td>  
    </tr>  
    <tr align="center"> 
    	<th width="150" height="33" class="td2">姓名</th>
        <th width="300" class="td2">性别</th>       
        <th width="300" class="td2">电话</th>
        <th width="300" class="td2">身份证号</th>      
        <th width="300" class="td2">普通会员/VIP</th>      
    </tr>  
    </thead>  
    <tbody id="adminTbody">  
    
    <%
           UsersService dao=new UsersService();
           List<UsersBean> list =dao.readFirstTitle();  
                   
           for(UsersBean tl:list)
           {%>
          
          <tr>
              <td class="td2" height="33" width="150"><%=tl.getName() %></td>	              
              <td class="td2"><%=tl.getGender() %></td>
              <td class="td2"><%=tl.getTel() %></td>
              <td class="td2"><%=tl.getIdNo() %></td>
              <%String t = tl.getStatu(); if(t.equals("0")){%><td class="td2">普通会员</td><%}else{%><td class="td2">VIP会员</td><%}%>
              
          </tr>
        
            <%}
       %>
    </tbody>  
</table>  
<div id="barcon" class="barcon" >  
    <div id="barcon1" class="barcon1"></div>  
        <div id="barcon2" class="barcon2">  
            <ul>  
                <li><a href="###" id="firstPage">首页</a></li>  
                <li><a href="###" id="prePage">上一页</a></li>  
                <li><a href="###" id="nextPage">下一页</a></li>  
                <li><a href="###" id="lastPage">尾页</a></li>  
                <li><select id="jumpWhere">  
                </select></li>  
                <li><a href="###" id="jumpPage" onclick="jumpPage()">跳转</a></li>  
            </ul>  
        </div>  
</div> 
</from>
</body>
<script src="banksys/js/jquery-3.2.1.min.js"></script>  
<script src="banksys/js/page.js"></script>  
</body>   
</html>