<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>

<script type="text/javascript">
   function tijiao(){
	   var bname = $('#bname').val();
	   if(bname==""){
		  alert("图书名不能为空"); 
		  return false;
	   }
	   var price = $('#price').val();
	   if(price==""){
		   alert("价格不能为空！"); 
		   return false;
	   }
	   //MVC提交
	   var myform = document.getElementById("myform");
	   myform.submit();	   
   }
   
   function validISBN(){
	   var isbn = $('#isbn').val();
	   var span = document.getElementById("ISBNNull");
	   if(isbn != ""){
		   var target = "<%=basePath%>back/ValidIsbnSvl";
		   $.ajax({
			   type: "POST",
			   url: target,
			   data: "isbn="+isbn,
			   success: function(msg){
			     if(msg == "1"){
			    	 span.innerHTML="isbn重复，请重新输入!";
			     }else if(msg == "0"){
			    	 span.innerHTML="isbn可以使用!";
			     }else if(msg == "-1"){
			    	 span.innerHTML="网络异常....";
			     }else{
			    	 
			     }
			   }
			}); 
	   }else{
		   span.innerHTML="isbn不能为空!";
	   }
   }

</script>
</head>
<body>
 <table align="center" width=90%>
     <jsp:include page="bhead.jsp"></jsp:include>      
      <tr><td align="left"><h2>新书上架</h2></td></tr>
      <tr>
      	<td>
      	<form action="<%=basePath%>back/BookAddSvl" method="post" id="myform" enctype="multipart/form-data" >
      		<table border="0" width=60% align="center">       		
      		    <tr>
					<td>目录</td>
					<td>
					  <select name="ca">
					      <option value="c001">历史</option>
						  <option value="c002">科技</option>
						  <option value="c003">小说</option>
					  </select>
					</td>				
				</tr>      		    
      			<tr><td>书号ISBN</td><td><input type="text" name="isbn" id="isbn" onkeyup="validISBN()"/>
      			      <span id="ISBNNull" style="color:red;font-size:8px"></span></td></tr>
       			<tr><td>书名</td><td><input type="text" name="bname" id="bname"/><span id="NameNull"></span></td></tr>
       			<tr><td>作者</td><td><input type="text" name="author"/></td></tr>
       			<tr><td>出版社</td><td><input type="text" name="press"/></td></tr>
       			<tr><td>出版日期</td><td><input type="text" name="pdate"  class="easyui-datebox"/></td></tr>
       			<tr><td>价格</td><td><input type="text" name="price" id="price" class="easyui-numberbox" precision="2"/></td></tr>
       			<tr><td>图片上传</td><td><input type="file"  name="pic"/></td></tr>
       			<tr><td colspan=2 align=center><input type="button" value=提交 onclick="tijiao()" /></td></tr>
       			<tr><td colspan=2 align="center"> <p style="color:red;font-size:8px">${msg} </p></td></tr>
    		</table>
    	</form>
      	</td>
      </tr>
    </table>

</body>
</html>