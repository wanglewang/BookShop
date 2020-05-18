<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <script type="text/javascript">	
	function validName(){
		var name = document.getElementById("bkname").value;
		var NameNull = document.getElementById("NameNull");	
		
		if(name == null || name == ""){
			NameNull.innerHTML = "<font color=\"red\">书名不能为空！</font>";
			return false;
		}else{
			NameNull.innerHTML = "";
			return true;
		}		
	}	
</script>
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
      	<form action="<%=basePath%>back/BookAddSvl" method="post" onsubmit="return validName()">
      		<table border="0" width=60% align="center">  		
      			<tr><td>书号ISBN</td><td><input type="text" name="isbn"/></td></tr>
       			<tr><td>书名</td><td><input type="text" name="bkname"/><span id="NameNull"></span></td></tr>
       			<tr><td>作者</td><td><input type="text" name="author"/></td></tr>
       			<tr><td>出版社</td><td><input type="text" name="press"/></td></tr>
       			<tr><td>出版日期</td><td><input type="text" name="publishdate"/></td></tr>
       			<tr><td>价格</td><td><input type="text" name="price"/></td></tr>
       			<tr><td>种类</td><td> <select name="selectType">
                 <option value="c002">科幻</option>
                 <option value="c001">历史</option>
                 <option value="c003">小说</option>
           </select> </td></tr>
       			<tr><td>图片上传</td><td><input type="file" name="pic"/></td></tr>
       			<tr><td colspan=2 align=center><input type=submit value=提交 /></td></tr>
    		</table>
    	</form>
      	</td>
      </tr>
    </table>
${msg}
</body>
</html>