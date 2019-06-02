<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testzjw.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
  var idx = 1;
  myChart.setOption({
    timeline : {
        data : [
            '2013-01-01', '2013-02-01', '2013-03-01', '2013-04-01', '2013-05-01',
            { name:'2013-06-01', symbol:'emptyStar6', symbolSize:8 },
            '2013-07-01', '2013-08-01', '2013-09-01', '2013-10-01', '2013-11-01',
            { name:'2013-12-01', symbol:'star6', symbolSize:8 }
        ],
        label : {
            formatter : function(s) {
                return s.slice(0, 7);
            }
        }
    },
    options : [
        {
            title : {
                text: '浏览器占比变化',
                subtext: '纯属虚构'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                data:['Chrome','Firefox','Safari','IE9+','IE8-']
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {
                        show: true, 
                        type: ['pie', 'funnel'],
                        option: {
                            funnel: {
                                x: '25%',
                                width: '50%',
                                funnelAlign: 'left',
                                max: 1700
                            }
                        }
                    },
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    center: ['50%', '45%'],
                    radius: '50%',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        },
        {
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        },
        {
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        },
        {
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        },
        {
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        },
        {
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        },
        {
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        },
        {
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        },
        {
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        },
        {
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        },
        {
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        },
        {
            series : [
                {
                    name:'浏览器（数据纯属虚构）',
                    type:'pie',
                    data:[
                        {value: idx * 128 + 80,  name:'Chrome'},
                        {value: idx * 64  + 160,  name:'Firefox'},
                        {value: idx * 32  + 320,  name:'Safari'},
                        {value: idx * 16  + 640,  name:'IE9+'},
                        {value: idx++ * 8  + 1280, name:'IE8-'}
                    ]
                }
            ]
        }
    ]
});

  
  
  
  </script>
</html>
