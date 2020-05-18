<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>用户管理</title>
</head>
<body>
 <table align="center" width=90%>
    	 <tr>
      	<td align=right>
      	    
      	  		管理员: admin &nbsp;	  		       	         	    	         	          	  	
      		
      			<a href="<%=basePath%>user/LogoutSvl">退出</a>
      		      	
      	</td>       	
      </tr>
      <jsp:include page="bhead.jsp"></jsp:include>    
      <tr>
      	<td>
      	<form action="<%=basePath%>back/TopUpSvl" method="post" id="myForm">
      		<table border="0" width=60% align="center">  		
      			<tr><td>账户：</td><td><input type="text" name="pid"/></td></tr>
      			<tr><td>金额：</td><td><input type="text" name="price"/></td></tr>
       			<tr><td colspan=2 align=center>	<input type="submit" value="充值" /></td></tr>
    		</table>
    	</form>
      	</td>
      </tr>
    </table>
${msg}
</body>
</html>