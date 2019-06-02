<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <meta charset="UTF-8">
 <title>Title</title>
 <script src="banksys/js/jquery-3.3.1.js"></script>
 <link rel="stylesheet" href="banksys/css/bootstrap.min.css" rel="external nofollow" >
</head>
<body>
  
<div>
 <div class="row clearfix">
  <div class="col-md-12 column">
   <table class="table table-bordered table-hover">
    <thead>
    <tr>
     <th>City_ID</th>
     <th>City_EN</th>
     <th>City_CN</th>
     <th>Country_code</th>
     <th>Country_EN</th>
     <th>Country_CN</th>
     <th>Province_EN</th>
     <th>Province_CN</th>
    </tr>
    </thead>
    <tbody id="tbody">
  
    </tbody>
   </table>
   <!--分页-->
   第<span id="paging">1</span>页/
   共<span id="countPage">1</span>页/
   <a id="homePage">Home</a>/
   <a id="prevPage">Prev</a>/
   <a id="nextPage">Next</a>/
   转到第：
   <input type="text" style="width: 2em" id="pageNum">
   页
   <a id="goPage">Go</a>
  
  
  </div>
 </div>
</div>
</body>
<script>
 $(function () {
  //页面初始化 （显示第一页）
  selectPage(1);
  home();
  prev();
  next();
  goPage();
 })
 function selectPage(pageCode) {
  //分页查询 pageCode：页数
  $.ajax("getCity",{
   type:"get",
   data:{"currenPage":pageCode},
   success:function (data) {
    $("#tbody").html("");
    //总页数
    $("#countPage").text(data.totalPage);
  
    $.each(data.pageData,function (index,obj) {
     var clazz="";
     if(index%2==0){
      clazz="success";
     }
     $("#tbody").append(
      "<tr class='"+clazz+"'>\n" +
      "<td>"+obj.cityId+"</td>\n" +
      "<td>"+obj.cityEn+"</td>\n" +
      "<td>"+obj.cityCn+"</td>\n" +
      "<td>"+obj.countryCode+"</td>\n" +
      "<td>"+obj.countryEn+"</td>\n" +
      "<td>"+obj.countryCn+"</td>\n" +
      "<td>"+obj.provinceEn+"</td>\n" +
      "<td>"+obj.provinceCn+"</td>\n" +
      "</tr>"
     );
    })
  
   }
  });
 }
 //第一页
 function home() {
  $("#homePage").on("click",function () {
   $("#paging").text(1);
   selectPage(1);
  })
 }
  
 //上一页
 function prev() {
  $("#prevPage").on("click",function () {
   var prevText=$("#paging").text();
   var prevNum=parseInt(prevText);
   prevNum=prevNum-1;
   if(prevNum<=1){
    selectPage(1);
    $("#paging").text(1);
    return;
   }
   $("#paging").text(prevNum);
   selectPage(prevNum);
  })
 }
 //下一页
 function next() {
  $("#nextPage").on("click",function () {
   //获取文本的值 页数
   var prevText=$("#paging").text();
   //类型转换
   var prevNum=parseInt(prevText);
   //总页数
   var countText=$("#countPage").text();
   //类型转换
   var countNum = parseInt(countText);
   //页数加1
   prevNum=prevNum+1;
   //判断超出了总页码
   if(prevNum>=countNum){
    selectPage(countNum);
    $("#paging").text(countNum);
    return;
   }
   //设置网页增加的值
   $("#paging").text(prevNum);
   //调用分页查询
   selectPage(prevNum);
  })
 }
 //去到几页
 function goPage() {
  $("#goPage").on("click",function () {
   var pageNum=parseInt($("#pageNum").val());
   var countPage=parseInt($("#countPage").text())
   //判断超出了总页码
   if(pageNum>=countPage){
    selectPage(countPage);
    $("#paging").text(countPage);
    $("#pageNum").val(countPage);
    return;
   }
   //判断低于了总页码
   if(pageNum<=1){
    selectPage(1);
    $("#paging").text(1);
    $("#pageNum").val(1);
    return;
   }
   selectPage(pageNum);
   $("#paging").text(pageNum);
  })
 }
  
</script>
</html>
