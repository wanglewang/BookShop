<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>">
		<title>购物车</title>
		<link rel="stylesheet" href="<%=basePath%>css/reset.css" />
		<script type="text/javascript" src="<%=basePath%>js/jquery.min.js" ></script>
		<script type="text/javascript" src="<%=basePath%>jQueryUI/jquery-ui.min.js"></script>
		<link rel="stylesheet" href="<%=basePath%>jQueryUI/jquery-ui.min.css" />
		<link rel="stylesheet" href="<%=basePath%>jQueryUI/jquery-ui.theme.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/HeaAndFoo.css"/>
		<script type="text/javascript" src="<%=basePath%>js/public.js" ></script>
		<script type="text/javascript" src="<%=basePath%>js/ShopCar.js" ></script>
		<style>
			
			.ulTop,.ulBot,table{ width: 960px; height: 50px; margin: 0px auto; color: #646464; }
			
			table{ height: 100%; }
			
			.ulTop>li,.ulBot>li{ float: left; width: 160px; height: 50px; line-height: 50px; text-align: center;  }
			
			
			.goods{ display: block; width: 958px; height: 123px; border: 1px solid #ccc; background-color: #FAFAFA;}
			
			.select,.bkInfo,.price,.numPrice,.addMinus,.do{ width: 160px; height: 123px;  text-align: center; }
			
			#bknum{ width: 30px; height: 30px; margin: 0px -5px 0px -5px; text-align: center; }
			
			#addBtn,#minusBtn{ width: 35px; height: 34px; }
			
			#staBtn{ width: 120px; height: 40px; font-size: 18px; background-color: #FF2832; color: #fff; border: none; border-radius: 6px;}
		</style>
	</head>
	<body>
		<div class="header"><%@include file="header.jsp"  %></div>
		
		<div class="content">
			<ul class="ulTop">
				<li><input type="checkbox" name="" id="" value="" /><span class="space"></span>全选</li>
				<li>商品信息</li>
				<li>单价（元）</li>
				<li>数量</li>
				<li>金额</li>
				<li>操作</li>
			</ul>
			<table>
				<tr class="goods">
					<td class="select"><input type="checkbox" name="" id="" value="" /></td>
					<td class="bkInfo">鬼吹灯全集（套装共8册） </td>
					<td class="price">￥35.60</td>
					<td class="addMinus">
						<button id="minusBtn">-</button>
						<input type="text" name="" id="bknum" value="1"  />
						<button id="addBtn">+</button>
					</td>
					<td class="numPrice">￥35.60</td>
					<td class="do">移入收藏<br />删除</td>
				</tr>
			</table>
			<ul class="ulBot">
				<li><input type="checkbox" name="" id="" value="" /><span class="space"></span>全选</li>
				<li>批量删除</li>
				<li>已选择1件商品</li>
				<li></li>
				<li>总计：35.60</li>
				<li><button id="staBtn">结算</button></li>
			</ul>
		</div>
		<div class="clear"></div>
		<div class="footer"><%@include file="footer.jsp"  %></div>
	</body>
</html>

