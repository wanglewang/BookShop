<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>BuyinfoList.html</title>
	

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
      <tr><td align="left"><h2>购买记录</h2></td></tr>
      
      <!-- 查询条件 -->
      <tr>
      	<td>
      		<table>
      		   <tr><td align=left>用户名 </td><td><input type="text" name="uname"/></td></tr>
               <tr>
                   <td align=left>开始日期 </td><td><input type="text" name="beginDate"/></td>
                   <td align=left>结束日期 </td><td><input type="text" name="endDate"/></td>
                   <td><input type=submit value="查询"/></td>
               </tr>
      		</table>
      	</td>
      </tr>
      
      
      <tr>
      	<td align=left>
      	  <table border="1" width=100%> 
      	   <tr><td>用户名</td><td>书名--购买数量(本)</td><td>书单价</td><td>出版社</td><td>作者</td><td>购买日期</td><td>总付款</td><td>购书总数(本)</td></tr>
      	  	
      	  	  <tr><td>tom</td><td>战争与和平--5</td><td>28.5</td><td>外文出版社</td>
      	  	  <td>托尔斯泰</td><td>2015-10-1 </td><td>102</td><td>32</td></tr>
      	  	  
      	  	  
      	<tr>
      	<td colspan=8>
      		<table id="tblTurnPage" cellSpacing="0" cellPadding="1" width="100%" border="0" style="font-family:arial;color:red;font-size:12px;">	    		
	    			<tr>
	    				<td>总记录数：${RecordAllCount}</td> 
	    				<td>总页数：${PageAllCount}</td>
	    				<td>当前页：${CurrentPageNo}</td>
	    				<td><a href="back/BuyRecordSvl?page=1">首页|</a>
	    				    <a href="back/BuyRecordSvl?page=${CurrentPageNo-1}">《前页|</a>
	    				    <a href="back/BuyRecordSvl?page=${CurrentPageNo+1}">后页》|</a>
	    				    <a href="back/BuyRecordSvl?page=${PageAllCount}">末页|</a></td>
	    				<td >跳转到:第<input type="text" size="3" >页<input type="button" value="go"></td>
	    			</tr>	    		
	    		</table>	    	
      	</td>
      </tr>
      	  	
      	  	
      	  </table>
    	
      	</td>
      </tr>
    </table>
  </body>
</html>
