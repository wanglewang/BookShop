<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
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
<body><form>
	<table align="center" width=90%>
      <jsp:include page="bhead.jsp"></jsp:include>
      <tr>
      	<td>
      		<table border="1" width=100%> 
      			<tr><td>订单编号</td><td>用户</td><td>订单状态</td><td>下单时间</td><td>金额</td> <td>配送</td></tr>  
       			   <c:forEach var="od" items="${Orders}">		
       					<tr>
      				<td colspan=2 align=center style="color:red">
      				<a href="<%=basePath%>back/OrderDealDetailSvl?oid=${od.oid}">订单详情</a></td>
       				<td>${od.oid}</td>
       				<td>${od.uname}</td>
       				<td>${od.stat}</td>
       				  <td>${od.payTime}</td>
       				<td>${od.allMoney}</td>    
       				<td colspan=2 align=center style="color:red">
       				<a href="<%=basePath%>back/ChangeOrderStatSvl?oid=${od.oid}">提交</a></td>	
       				</tr> 
					</c:forEach>
					
    		</table>
      	</td>
      </tr>
    </table>
    </form>
</body>
</html>