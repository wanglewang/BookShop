<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<tr>
      	<td align=right>
      	        <c:if test="${user !=null}">
      	           welcome you ${user.uname} &nbsp;<a href="<%=basePath%>user/ShopCarSvl">购物车</a>
      	  		   &nbsp;<a href="<%=basePath%>user/LogoutSvl">退出</a>    
      	  		
      	        <c:if test="${user.role==3}">
      	         &nbsp;   <a href="<%=basePath%>user/UpdateUserInfoSvl">修改密码</a>
      	  		  
</c:if>
    <c:if test="${user.role==3}">
      	         &nbsp;   <a href="<%=basePath%>user/OrderDealSvl?">订单</a>
      	  		  
</c:if>
   
  &nbsp;   <a href="<%=basePath%>ComeBack">casf</a>
      	  		   <c:if test="${user.role==1}">
      	  		   &nbsp;    <a href="<%=basePath%>back/BookAddSvl">后台</a>   
      	  		   </c:if>   	 
      	        </c:if>
      	        <c:if test="${user==null}">
      	           <a href="<%=basePath%>LoginSvl2">登录</a>
      	        </c:if>       	  	
      	</td>
</tr>