<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="header_T">
	<div class="header_T_C">
		<a id="regBtn">注册</a> | <a id="loginBtn">登录</a> | <a href="<%=basePath%>jsp/personalCenter.jsp">个人中心</a>
	</div>
</div>
<div class="header_C">
	<img src="<%=basePath%>img/logo.jpg" alt="" class="logo" />
	<input type="text" name="" class="serchTxt" value="" />
	<button class="serchBtn">搜索</button>
	<div class="shopcarBtn">
		<a href="<%=basePath%>jsp/ShopCar.jsp" class="num">购物车 0</a>
		<a href="" class="order">我的订单</a>
	</div>
</div>
<ul class="banner">
	<li id="liOne">全部商品分类</li>
	<li class="bannerLi"><a href="">首页</a></li>
	<li class="bannerLi"><a href="">电子书</a></li>
	<li class="bannerLi"><a href="">特色书店</a></li>
	<li class="bannerLi"><a href="">文化用品</a></li>
	<li class="bannerLi"><a href="">数字音乐</a></li>
	<li class="bannerLi"><a href="">特价</a></li>
</ul>
<div class="bannerBorder" style="width: 100%; height: 2px; background-color: #FF2832;" ></div>
<div id="login" title="用户登录">
	<div id="txt1" >
		<label for="uname">账号 : </label><input type="text" name="uname" id="uname" class="text" />
	</div>
	<div id="txt1">
		<label for="pwd">密码 : </label><input type="text" name="password" id="pwd" class="text" />
	</div>
	
</div>

<div id="reg" title="用户注册">
	
</div>