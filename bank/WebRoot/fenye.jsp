<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.zjw.bean.UsersBean" %> 
<%@ page import="com.zjw.tools.DBHelp" %> 
<%@ page import="java.sql.*" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fenye.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><%!  int pageSize=4;
    int pageCount;
    int showPage;
    %>
     
<!-- 连接数据库并从数据库中调取记录-->
<%
    Connection con;
    Statement sql;
    ResultSet rs;
         
    try{Class.forName("com.mysql.jdbc.Driver"); 
    }catch(ClassNotFoundException e){
    }
         
    try{con=DBHelp.getCon();
        sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //返回可滚动的结果集 
        rs=sql.executeQuery("select * from card");
        //将游标移到最后一行 
        rs.last();
        //int lastRow=rs.last();
        //获取最后一行的行号 
        int recordCount=rs.getRow();
        //计算分页后的总数 
        pageCount=(recordCount%pageSize==0)?(recordCount/pageSize):(recordCount/pageSize+1);
         
        //获取用户想要显示的页数：
        String integer=request.getParameter("showPage");
        if(integer==null){
            integer="1";
        }
        try{showPage=Integer.parseInt(integer);
        }catch(NumberFormatException e){
            showPage=1;
        }
        if(showPage<=1){
            showPage=1;
        }
        if(showPage>=pageCount){
            showPage=pageCount;
        }
         
        //如果要显示第showPage页，那么游标应该移动到的posion的值是：
        int posion=(showPage-1)*pageSize+1;
        //设置游标的位置
        rs.absolute(posion);
        //用for循环显示本页中应显示的的记录
        for(int i=1;i<=pageSize;i++){        
    %>
            <table>
                <tbody><tr> 
                    <th><%=rs.getString("id") %></th>
                    <td>发表于：<%=rs.getString("u_ser") %></td>
                </tr>
                
            </tbody></table>
                     
    <%       
            rs.next();
        }   
        rs.close();
        con.close();
        }
        catch(Exception e){
        e.printStackTrace();}
    %>
    <br>
    第<%=showPage %>页（共<%=pageCount %>页）
    <br>
    <a href="showPage=${showPage-1}" value="shouye"></a>
    <jsp?showPage=1">首页
    ">上一页
<%   //根据pageCount的值显示每一页的数字并附加上相应的超链接
        for(int i=1;i<=pageCount;i++){
    %>
            "><%=i%>
<%   }
    %>   
    ">下一页
    ">末页
    <!-- 通过表单提交用户想要显示的页数 -->
    <form action="" method="get">
        跳转到第<input type="text" name="showPage" size="4">页
        <input type="submit" name="submit" value="跳转">
    </form> This is my JSP page. <br>
  </body>
</html>
