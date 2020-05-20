<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>订单详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- //for-mobile-apps -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div class="main">
		<form>
			<table align="center" width=90%>
				<jsp:include page="mhead.jsp"></jsp:include>
				<tr>
					<td>
						<table border="1" width=100%>
							<tr>
								<td>Dno:</td>
								<td>订单编号</td>
								<td>订单状态</td>
								<td>书号</td>
								<td>数量</td>
								<td>价格</td>
							</tr>
							<c:forEach var="od" items="${ods}">
								<tr>
									<td>${od.dno}</td>
									<td>${od.oid}</td>
									<td>${od.isbn}</td>
									<td>${od.buyNum}</td>
									<td>${od.rprice}</td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>