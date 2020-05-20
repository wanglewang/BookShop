<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>图书下架</title>
</head>
<body>
 <table align="center" width=90%>
    	 <tr>
      	<td align=right>
      	    
      	  		管理员: admin &nbsp;	  		       	         	    
      			<a href="<%=basePath%>user/LogoutSvl">退出</a>
      	</td>       	
      </tr>
     <tr>
      <jsp:include page="bhead.jsp"></jsp:include>    
      </tr>
      <tr>
      	<td>
      	<form action="<%=basePath%>back/BookAddNumSvl" method="post" id="myform">
      		<table border="0" width=60% align="center">  		
      			<tr><td>书号ISBN</td><td><input type="text" name="isbn"/></td></tr>
      				<tr><td>数量</td><td><input type="text" name="num"/></td></tr>
       			<tr><td colspan=2 align=center>	<input type="submit" value="提交"  class="button"/></td></tr>
    		</table>
    	</form>
      	</td>
      </tr>
    </table>
${msg}
</body>
</html>