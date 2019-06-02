<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zjw.service.ScoreService"%>
<%@page import="com.zjw.bean.ScoreBean"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="banksys/css/style.css">
	<style type="text/css">
	.test {
    display: inline-block;
    padding: .3em .5em;
    background-image: linear-gradient(#f5c153, #ea920d);
    border: 1px solid rgba(0,0,0,.2);
    border-radius: .3em;
    box-shadow: 0 1px white inset;
    text-align: center;
    text-shadow: 0 1px 1px black;
    color:white;
    font-weight: bold; }
.test:active{
    box-shadow: .05em .1em .2em rgba(0,0,0,.6) inset;
    border-color: rgba(0,0,0,.3);
    background: #bbb; }
    </style>
  </head>
  
  <body>
  
<form action="SendCar" method="post">

<div class="danpin center">
<div class="biaoti center">积分兑换</div>
<%   
	 ScoreService sc = new ScoreService(); 
	 String kahao = (String)session.getAttribute("kahao");
	 String total_score = sc.userscore(kahao);
	 
%>

您拥有的总积分数为：<%=total_score %>
  <%
  session.setAttribute("sum", 0);
  session.setAttribute("爱奇艺月卡", 2000);
  session.setAttribute("移动充值卡", 3000);
  session.setAttribute("熊娃娃", 1799);
  session.setAttribute("保暖杯", 3999);
  session.setAttribute("戴尔笔记本", 59999); %>
			<div class="main center">
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href=""><img src="banksys/img/skin_/aiqiyi.jpg" alt=""></a></div>
					<div class="pinpai"><a href="">爱奇艺月卡</a></div>
					<div class="youhui">面值RMB35元，积分兑换</div>
					<div class="jiage">2000积分 <input type="checkbox" value="爱奇艺月卡" name="item"></div>
					
				</div>
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href=""><img src="banksys/img/skin_/yidong.jpg" alt=""></a></div>
					<div class="pinpai"><a href="">移动充值卡</a></div>
					<div class="youhui">面值RMB30元，积分兑换</div>
					<div class="jiage">3000积分 <input type="checkbox" value="移动充值卡" name="item"></div>
				</div>
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href=""><img src="banksys/img/skin_/xiong.jpg" alt=""></a></div>
					<div class="pinpai"><a href="">熊娃娃</a></div>
					<div class="youhui">美丽可爱，材质柔软</div>
					<div class="jiage">1799积分 <input type="checkbox" value="熊娃娃" name="item"></div>
				</div>
				<div class="mingxing fl"> 	
					<div class="sub_mingxing"><a href=""><img src="banksys/img/skin_/beizi.jpg" alt=""></a></div>
					<div class="pinpai"><a href="">保暖杯</a></div>
					<div class="youhui">保温新榜样，户外正能量</div>
					<div class="jiage">3999积分 <input type="checkbox" value="保暖杯" name="item"></div>
				</div>
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href=""><img src="banksys/img/skin_/daier.jpg" alt=""></a></div>
					<div class="pinpai"><a href="">戴尔笔记本</a></div>
					<div class="youhui">更轻更薄，像杂志一样随身携带</div>
					<div class="jiage">59999积分 <input type="checkbox" value="戴尔笔记本" name="item"></div>
				</div>
				<p>
				<button class="test" type="submit">加入购物车</button>
				</p>
				<div class="clear"></div>
			</div>
		</div>
</form>
</body>
</html>
