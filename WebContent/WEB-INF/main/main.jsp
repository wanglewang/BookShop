<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	 <table align="center" width=90%>
    	<tr>
	      	<td align=right>
		  		welcome you 张三 &nbsp;<a href="#">购物车</a>
		  		&nbsp;<a href="LogoutSvl">退出</a>       	   
		    	<a href="#">登录</a>         	          	  	
				<a href="#">后台</a>
	      	</td>
      	</tr>
		<tr>
	      	<td>
	      		<table border="1" width=100%>       		
	      		    <c:forEach var="bk" items="${books}">
	      				<tr><td rowspan=3><img width=100 height=100 src="<%=basePath%>${bk.pic}"/></td>
	      				<td colspan=2 align=center style="color:red"><a href="<%=basePath%>bookInfo?isbn=${bk.isbn}">${bk.bname}</a></td></tr>
	       				<tr><td>商品价格</td><td>${bk.price}</td></tr>
	       				<tr><td>出版社</td><td>${bk.press}</td></tr>           		       			
	       			</c:forEach>			
	    		</table>
	      	</td>
	    </tr>
    </table>

</body>
</html>