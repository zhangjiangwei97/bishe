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
	<meta charset="UTF-8">
    
    <style>
        #pic1{
            width:700px;
            height:400px;
            margin: 20px auto;
        }
    </style>
    <script type="text/javascript" src='banksys/js/echarts.js'></script>
    <script type="text/javascript" src='banksys/js/echarts.min.js'></script>

  </head>
  
  <body>
    <div id="pic1"></div>
  </body>
  <script type="text/javascript"></script> 
<script src="banksys/js/jquery.js"></script> 
  <script>

		var myChart = echarts.init(document.getElementById('pic1'));
		myChart.setOption({
    		title: {
        	text: '本行各支行开户统计(开户数量前五名省份)',
        	subtext: '数据来自网络'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {
        data: ['2011年']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {

        type : 'value',
		minInterval : 1
    },
    yAxis: {
        type: 'category',
        data: []
    },
    series: [
        {
            name: '2011年',
            type: 'bar',
            data: []
        },
       
    ]
});
	
		$.ajax({
                url : "getAcct.do",
                type: "Post",
                dataType : "json",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                async : true,
                timeout : 1000,
                success : function(json) {
                    if(json){            
                    var diqu=[];
                    var count=[];            
                    for (var i = 0; i < json.length; i++) {

                    diqu.push(json[i].accban);
                    
 
                }

                 for (var i = 0; i < json.length; i++) {

                    count.push(json[i].num);
                }

                    
					    myChart.hideLoading();

						myChart.setOption({        //加载数据图表
						yAxis: {
        					//type: 'category',
        					data: diqu
    					},
                        series: [{
   
                            name: '',
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
