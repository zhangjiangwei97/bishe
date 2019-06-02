<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<script src='banksys/js/jquery-3.2.1.min.js'></script>  
	<script src='banksys/js/bootstrap.min.js'></script>
  </head>
<style>
    /* layout.css Style */
        .upload-drop-zone {
          height: 200px;
          border-width: 2px;
          margin-bottom: 20px;
        }
 
        /* skin.css Style*/
        .upload-drop-zone {
          color: #ccc;
          border-style: dashed;
          border-color: #ccc;
          line-height: 200px;
          text-align: center
        }
        .upload-drop-zone.drop {
          color: #222;
          border-color: #222;
        }
</style>  
  <body>
   <div class="container">
       <div class="panel panel-primary">  
        
        <div class="panel-body">
 
          <!-- Standar Form -->
          <h4 class="badge alert-success pull-right">上传客户帮助文件</h4>
          <form action="UploadServlet" method="post" enctype="multipart/form-data" id="js-upload-form">
            <div class="form-inline">
              <div class="form-group">
                <input type="file" name="files[]" id="js-upload-files" multiple>
              </div>
              <button type="submit" class="btn btn-sm btn-primary" id="js-upload-submit">上传</button>
            </div>
          </form>
          </div>
          </div>
          </div>
           
  </body>
</html>
