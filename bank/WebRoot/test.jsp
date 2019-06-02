<%@ page contentType="text/html;charset=UTF-8" language="java" %> <html> 
<head> 
 <style type="text/css">

        .p1{
            font-size: 14px;
            color: #000;
        }
        .p2{
            font-size: 12px;
            color: #b0b0b0;
        }
        .p3{
            font-size: 14px;
            color: #ff5f19;
        }
        .product{
            width:100%;
            position: relative;
            margin: 20px 0 5px 0;
            height: 100px;
            background: #fafafa;
        }

        .img{
            width: 100px;
            height: 100px;
            float: left;
            margin-right: 20px;
        }
        .p{
            display:inline-block;
            float:left;
            width:50%;
            margin-top:6px;
            font-family: Microsoft YaHei;
        }
        .p1{
            margin-top:16px;
        }



    </style>
<script src="banksys/js/jquery.js"></script> 
<script>
        //function getCourse() {
            $.ajax({
                url : "getCourse.do",
                type: "GET",
                dataType : "text",
                async : true,
                timeout : 50000,
                success : function(json) {
                      document.getElementById("box").innerHTML = json;  
                    $.each(json, function(i, item) {
						//循环获取数据    
						var id = item.id;
						var name = item.name;
						var pwd = item.pwd;
						var z = item.z;
						var j = item.j;
						var zzz=[id,name,pwd,z,j];
					
						document.getElementById("course").innerHTML = zzz;
						//document.getElementById("box").innerHTML = time;
 
					});
 
				
 			


                },
                error : function() {
                    var errorMsg = "无法获取课程";
                    document.getElementById("course").innerHTML = errorMsg;
                }
            });
          /*    $(function(){
            $.ajax({
                
                url: "getCourse.do",//地址，就是json文件的请求路径
                type: "GET",//请求方式
                dataType: "json",//数据类型可以为 text xml json  script  jsonp
                async : true,
                timeout : 50000,
                success: function(result){//返回的参数就是 action里面所有的有get和set方法的参数
                    addBox(result);
                }
            });
            $.get("item.json",function(result){
                //result数据添加到box容器中;
                addBox(result);
            });
        });
            function addBox(result){
            //result是一个集合,所以需要先遍历
            $.each(result,function(index,obj){
                $("#box").append("<div class='product'>"+//获得图片地址
                    //获得名字
                    "<div class='p1 p'>"+obj['id']+"</div>"+
                    //获得性别
                    "<div class='p2 p'>"+obj['name']+"</div>"+
                    //获得邮箱地址
                    "</div>");
            });*/
       // }
    </script> 
    </head> 
    <body> 
    <input type="button" id="me" value="查看课程" onclick="getCourse()"/> <div id="course"></div> 
    <div id="box"></div> 
     <ul id="list"> </ul> 
    </body> 
    </html>
