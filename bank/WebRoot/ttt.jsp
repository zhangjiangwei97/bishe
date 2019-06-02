<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.io.*"%>
<html>
<title></title>
<body>
<%
ServletContext context = this.getServletContext();
String path = context.getRealPath("/download");
File dir=new File(path);
File file[]=dir.listFiles();//用file对象的listFiles()方法返回指定目录下的文件
%>

<p>文件有:
<%
for(int i=0;i<file.length;i++)
{
  if(file[i].isFile())
  out.print("<br>"+file[i].toString());
 
}
  %>
</body>
</html>