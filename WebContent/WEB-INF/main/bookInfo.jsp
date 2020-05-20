<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
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
							<td rowspan=3><img width=100 height=100
								src="<%=basePath%>${book.pic}" /></td>
							<td colspan=2 align=center style="color: red">${book.bname}</td>
						</tr>
						<tr>
							<td>商品价格</td>
							<td>${book.price}</td>
						</tr>
						<tr>
							<td>出版社</td>
							<td>${book.press}</td>
						</tr>
						<tr>
							<td height=300 colspan=3>${book.info}</td>
						</tr>
						<tr>
							<td colspan=3 align=center><a
								href="<%=basePath%>user/ShopCarAddSvl?isbn=${book.isbn}">加入购物车</a>
								&nbsp; <a href="<%=basePath%>MainSvl">返回</a></td>
						</tr>

					</table>

				</td>
			</tr>

		</table>
	</div>
</body>
</html>