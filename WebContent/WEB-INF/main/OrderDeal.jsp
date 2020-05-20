<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- //for-mobile-apps -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div class="main">
		<table align="center" width=90%>
			<jsp:include page="mhead.jsp"></jsp:include>
			<tr>
				<td>
					<table border="1" width=100%>
						<tr>
							<td>详情</td>
							<td>编号</td>
							<td>用户</td>
							<td>状态</td>
							<td>下单时间</td>
							<td>金额</td>
						</tr>
						<c:forEach var="od" items="${Orders}">
							<tr>
								<td style="color: red"><a
									href="<%=basePath%>user/OrderDealDetailSvl?oid=${od.oid}">订单详情</a></td>
								<td>${od.oid}</td>
								<td>${od.uname}</td>
								<td>${od.stat}</td>
								<td>${od.payTime}</td>
								<td>${od.allMoney}</td>
							</tr>
						</c:forEach>
						<tr>
							<td><a href="<%=basePath%>MainSvl">返回</a></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>