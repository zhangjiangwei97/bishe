<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>统计图</title>
    
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
    <script type="text/javascript" src='banksys/js/echarts.common.min.js'></script>

  </head>
  
  <body>
     <div id="pic1"></div>

  </body>
<script type="text/javascript"></script> 
<script src="banksys/js/jquery.js"></script> 
<script>
    var myCharts1 = echarts.init(document.getElementById('pic1'));
     myCharts1.setOption({
        backgroundColor: 'white',

        title: {
            text: '本行信用卡总人口消费情况',
            left: 'center',
            top: 20,
            textStyle: {
                color: '#ccc'
            }
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {d}%"
        },

        visualMap: {
            show: false,
            min: 500,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'',
                type:'pie',
                clockwise:'true',
                startAngle:'0',
                radius : '60%',
                center: ['50%', '50%'],
                data:[
                    {
                        value:[],
                        name:'网购',
                        itemStyle:{
                            normal:{
                                color:'rgb(255,192,0)',
                              //  shadowBlur:'90',
                                //shadowColor:'rgba(0,0,0,0.8)',
                               // shadowOffsetY:'30'
                            }
                        }
                    },
                    {
                        value:[],
                        name:'转账',
                        itemStyle:{
                            normal:{
                                color:'rgb(1,175,80)'
                            }
                        }
                    },
                    {
                        value:[],
                        name:'消费',
                        itemStyle:{
                            normal:{
                                color:'rgb(122,48,158)'
                            }
                        }
                    },
                    {
                        value:[],
                        name:'其他',
                        itemStyle:{
                            normal:{
                                color:'rgb(192,48,120)'
                            }
                        }
                    }

                ],
            }
        ]});
        myCharts1.showLoading(); 
        $.ajax({
                url : "getSpend.do",
                type: "Post",
                dataType : "json",
                async : true,
                timeout : 1000,
                success : function(json) {
                                 
                    $.each(json, function(i, item) {
						//循环获取数据    
						var onlinesp = item.onlinesp;
						var userspend = item.userspend;
						var zhz = item.zhz;
						var oth = item.oth;

						var zzz=new Array();
						var aaa=new Array();
						var bbb=new Array();
						var kkk=new Array();
						zzz[0]=onlinesp;
						aaa[0]=userspend;
						bbb[0]=zhz;
						kkk[0]=oth;
						//var zzz=[id,name,pwd,z,j];
					    myCharts1.hideLoading();
						//document.getElementById("course").innerHTML = zzz;
						//document.getElementById("box").innerHTML = time;
						myCharts1.setOption({        //加载数据图表	
                        series : [
            {
                name:'',
                type:'pie',
                clockwise:'true',
                startAngle:'0',
                radius : '60%',
                center: ['50%', '50%'],
                data:[
                    {
                        value:zzz,
                        name:'网购(淘宝，京东，拼多多购物)',
                        itemStyle:{
                            normal:{
                                color:'rgb(255,192,0)',
                              //  shadowBlur:'90',
                                //shadowColor:'rgba(0,0,0,0.8)',
                               // shadowOffsetY:'30'
                            }
                        }
                    },
                    {
                        value:bbb,
                        name:'转账(好友之间转账)',
                        itemStyle:{
                            normal:{
                                color:'rgb(1,175,80)'
                            }
                        }
                    },
                    {
                        value:aaa,
                        name:'消费(水电缴费，生活缴费)',
                        itemStyle:{
                            normal:{
                                color:'rgb(122,48,158)'
                            }
                        }
                    },
                    {
                        value:kkk,
                        name:'其他(柜台取款等交易)',
                        itemStyle:{
                            normal:{
                                color:'rgb(192,48,120)'
                            }
                        }
                    }

                ],
            }
        ]
                    });
						
 
					});
 
				
 			


                },
                error : function(errorMsg) {
                   //请求失败时执行该函数
        		 alert("图表请求数据失败!");
        		 myCharts1.hideLoading();
                }
            });	
    
</script>
</html>
