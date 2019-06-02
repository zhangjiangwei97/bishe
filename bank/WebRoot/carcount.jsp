<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
    <script type="text/javascript" src='banksys/js/echarts.js'></script>
    <script type="text/javascript" src='banksys/js/echarts.min.js'></script>
  </head>
  
  <body>
    <div id="chart" style="width:400px;height:400px; margin: 20px auto;"></div>
  </body>

<script type="text/javascript"></script> 
<script src="banksys/js/jquery.js"></script> 
<script>
        //function getCourse() {
        var myChart = echarts.init(document.getElementById('chart'));
        myChart.setOption({
        	 color: ['#3398DB'],
        	 tooltip : {
        		 trigger: 'axis',
                 axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                 	type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
             title: {
                 text: '近五年发卡量'
             },
             tooltip: {},
             legend: {
                 data:['金额']
             },
             xAxis: {
                 data:[]
             },
             yAxis: {
             	 type : 'value',
				 minInterval : 1
             },
             series: [{
                 name: '发卡量',
                 type: 'bar',
                 data: []
             }]
         });
         myChart.showLoading(); 
         
        
      
            $.ajax({
                url : "getCard.do",
                type: "Post",
                dataType : "json",
                async : true,
                timeout : 1000,
                success : function(json) {
                    if(json){            
                    var year=[];
                    var count=[];            
                    for (var i = 0; i < json.length; i++) {

                    year.push(json[i].create_date);
                }
                 for (var i = 0; i < json.length; i++) {

                    count.push(json[i].num);
                }

                    
					    myChart.hideLoading();

						myChart.setOption({        //加载数据图表
						xAxis: {
                       			data:year
             					},	
                        series: [{
   
                            name: '发卡量',
                            type:'bar',
                            data: count
                        }]
                    });} 
                    
                },
                error : function(errorMsg) {
                   //请求失败时执行该函数
        		 alert("图表请求数据失败!");
        		 myChart.hideLoading();
                }
            });	
    </script> 
</html>
