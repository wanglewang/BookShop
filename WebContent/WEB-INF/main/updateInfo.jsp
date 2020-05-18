<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
   function tijiao(){
	   var pwd = document.getElementById("pwd").value;
	   if(pwd == ""){
		   alert("密码不能为空!")
		   return false;
	   }
	   var myform = document.getElementById("myform");
	   myform.submit();	   
   } 
</script>
</head>
<body>
	 <form action="<%=basePath%>user/UpdateUserInfoSvl" method="post" id="myform">
        <table align="center"> 
                    
            <tr><td height=200></td></tr>
            <tr><td>新密码：</td><td><input type="password" name="pwd" id="pwd"></td></tr>
            <tr><td colspan="2" align="center">
            	<input type="button" value="提交" onclick="tijiao()"/></td>
            </tr>
            <tr><td colspan="2" align="center"><span style="color:red;font-size:8px">${msg}</span></td></tr>
        </table>
         
    </form>	
</body>
</html>