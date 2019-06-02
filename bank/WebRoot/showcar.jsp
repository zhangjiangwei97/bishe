<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>购物车页面</title>	
		<style type="text/css">
table {
    background-color: #FFF;
    border: none;
    color: #565;
    font: 12px arial;
}

table caption {
    font-size: 24px;
    border-bottom: 2px solid #B3DE94;
    border-top: 2px solid #B3DE94;
}

table, td, th {
    margin: 0;
    padding: 0;
    vertical-align: middle;
    text-align:left;
}

tbody td, tbody th {
    background-color: #DFC;
    border-bottom: 2px solid #B3DE94;
    border-top: 3px solid #FFFFFF;
    padding: 9px;
}


tfoot td, tfoot th {
    font-weight: bold;
    padding: 4px 8px 6px 9px;
    text-align:center;
}

thead th {
    font-size: 14px;
    font-weight: bold;
    line-height: 19px;
    padding: 0 8px 2px;
    text-align:center;
}

tbody tr.odd th,tbody tr.odd td { /*odd就是偶数行*/
    background-color: #CEA;
    border-bottom: 2px solid #67BD2A;
}

td+td+td, /*第三个td以及之后的td元素*/
col.price{ /*类样式*/
    text-align:right;
}

tbody tr:hover td, tbody tr:hover th { /*tr也有hover样式*/
    background-color: #8b7;
    color:#fff;
}
.test {
    display: inline-block;
    padding: .3em .5em;
     background-image: linear-gradient(#8eb349, #5f7c22);
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
.body {
font-size:12px;
font-family:"楷体"
} 
</style>
</head>
	<body>
	<form method="post" class="form-x" action="Scorecl" >
		<table width="450" cellspacing="0" cellpadding="0" border="1" rules="none" 
			align="center">
			<tbody>
				<tr height="50" bgcolor="84A8DA">
					<td align="center" >
						序号
					</td>
					<td align="center">
					商品名称
					</td>
					<td align="center">
					积分
					</td>
					<td align="center">
						删除
					</td>
					<td align="center">
						
					</td>
				</tr>
				<%!int i=0; %>
				
				<% 
				
				ArrayList<String> goods = (ArrayList) request.getSession().getAttribute("goods");
				
				if (goods == null || goods.size() == 0) {
					
				 %>
				 <tr height="100">
				<td colspan="3" align="center">
					没有商品可显示！
				</td>
			</tr>
			<%
				} else {int sum=0;
					for (int i = 0; i < goods.size(); i++) {
						
						String single = (String) goods.get(i);
						single = new String(single.getBytes("ISO-8859-1"), "utf-8");
						
						Integer count=(Integer)session.getAttribute(single);
						session.setAttribute("count", count);
						sum=sum+count;
						session.setAttribute("sum", sum);
						
			%>
			<tr height="50">
				<td align="center">
					<%=i + 1%>
				</td>
				<td align="center">
					<%=single%>			
				</td>
				<td align="center">
					<%=session.getAttribute(single)%>	
				</td>
				<td align="center">
					<a href="delcar.jsp?action=delete&id=<%=i%>">删除</a>					<%
						session.setAttribute("goods", goods);
					%>
				</td>
			</tr>
			<%
				}  }%>
				<td align="center" style="padding-left:12px" bgcolor="#FFB6C1">
				
					<p>总积分：<%=request.getSession().getAttribute("sum")%></p>
					
				</td>	
				<tr height="20">
			    
				<td colspan="4" align="center" style="padding-left:350px" bgcolor="84A8DA">
					<button class="test" type="submit"> 结算</button>
					<p><a href="delcar.jsp?action=clear">清空购物车</a></p>
					
				</td>
				
			</tr>					
			</tbody>
		</table>
		</form>
	</body>
</html>
