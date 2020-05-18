<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<tr>
      	<td align=center>
      	        <a href="<%=basePath%>back/BookAddSvl">新书上架</a> &nbsp;  <a href="<%=basePath%>back/BookAddNumSvl">书增加库存</a> 
      	        
      	         &nbsp;  <a href="<%=basePath%>back/BookDeleteSvl">书下架</a> &nbsp;  <a href="<%=basePath%>back/UserManageSvl">用户管理</a>
      	 &nbsp;  <a href="<%=basePath%>back/TopUpSvl">充值</a>    &nbsp; <a href="<%=basePath%>back/BookUpdatePriceSvl">修改售价</a> &nbsp; <a href="<%=basePath%>back/BuyinfoListSvl">用户购买记录</a>
      	    &nbsp; <a href="<%=basePath%>back/DealOrderSvl">订单处理</a>
      	</td>
</tr>