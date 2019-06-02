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
 <style type="text/css">  
    
     a{  
    text-decoration: none;  
    }  
      
    .table2{  
     border:#C8C8C8 solid;     
    border-width:1px 0px 0px 1px;   
    background: #F2F9FD;  
    margin-top:25px;  
    }  
      
    .td0{  
        border:#C8C8C8 solid;    
    border-width:0 0 1px 0;  
    }  
      
    .td2{  
        border:#C8C8C8 solid;     
    border-width:0 1px 1px 0 ;  
    }  
      
    .barcon {  
     width: 1000px;  
     margin: 0 auto;  
     text-align: center;  
        }  
  
    .barcon1 {  
        font-size: 17px;  
        float: left;  
        margin-top: 20px;  
    }  
  
    .barcon2 {  
     float: right;  
    }  
  
    .barcon2 ul {  
        margin: 20px 0;  
        padding-left: 0;  
        list-style: none;  
        text-align: center;  
    }  
  
    .barcon2 li {  
        display: inline;  
    }  
  
    .barcon2 a {  
        font-size: 16px;  
    font-weight: normal;  
    display: inline-block;  
    padding: 5px;  
    padding-top: 0;  
    color: black;  
    border: 1px solid #ddd;  
    background-color: #fff;  
    }  
  
    .barcon2 a:hover{  
    background-color: #eee;  
    }  
  
    .ban {  
        opacity: .4;  
    }  
 </style>  
</head>  
    <body>
    <body onload="goPage(1,6);">  
    <table width="950" cellpadding="0" cellspacing="0" class="table2" align="center">  
    <thead>  
    <tr>  
    <td colspan="6" height="33" class="td0"> </td>  
    </tr>  
    <tr align="center"> 
    	<th width="150" height="33" class="td2">编号</th>
        <th width="300" class="td2">姓名</th>       
        <th width="300" class="td2">性别</th>      
        <th width="300" class="td2">电话</th>    
        <th width="300" class="td2">身份证号</th>     
    </tr>  
    </thead>  
    <tbody id="adminTbody">  
    
    <%
           UsersService dao=new UsersService();
           List<UsersBean> list =dao.readFirstTitle();        
           for(UsersBean tl:list)
           {%>
          
          <tr>
              <td class="td2" height="33" width="150"><%=tl.getId() %></td>	              
              <td class="td2"><%=tl.getName() %></td>
              <td class="td2"><%=tl.getGender() %></td>
              <td class="td2"><%=tl.getTel() %></td>
              <td class="td2"><%=tl.getIdNo() %></td>
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
</body>
<script src="banksys/js/jquery-3.2.1.min.js"></script>  
<script src="banksys/js/page.js" charset="utf-8"></script>
</body>   
</html>
