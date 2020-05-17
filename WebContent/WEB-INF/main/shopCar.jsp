<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table align="center" width=90%>
		<jsp:include page="mhead.jsp"></jsp:include>
		<tr>
			<td>
				<table border="1" width=100%> 
					<tr><td>书名</td><td>作者</td><td>商品价格</td><td width="5%">数量</td><td>操作</td></tr>		       
					<c:forEach var="bk" items="${books }">	
						<tr>
							<td>${bk.bname }</td>
							<td>${bk.author }</td>
							<td>${bk.price }</td>
							<td ><input type="text"  name="#" value="1" /></td>
							<td><a href="#">移除</a></td>
						</tr>    
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" value="结算"> &nbsp; <a href="<%=basePath%>main">返回</a>
			</td>
 		</tr>
    </table>
</body>
</html>