<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int Num=(int)request.getAttribute("NUM");
%>
<!DOCTYPE html>
<html>
  <head>
    <title>BuyinfoList</title>
	<script>
function goPage(pno,psize){
  var itable = document.getElementById("idData");
  var pageSize = psize;
  var num = parseInt(<%=Num%>);
  var p1=num/pageSize;
  var p2=parseInt(num/pageSize);
  if(p1>p2){
      totalPage=parseInt(num/pageSize)+1;
    }else{
      totalPage=parseInt(num/pageSize);
    }
  var currentPage = pno;
  var startRow = (currentPage - 1) * pageSize;
    var endRow = currentPage * pageSize;
    endRow = (endRow > num)? num : endRow; 
    var i=0;
 while(i<(num)){
    var irow = itable.rows[i];
    if(i>=startRow && i<endRow){

    	 irow.style.display="block";
    }else{

    	 irow.style.display="none";
    }
    i=i+1;
  }
  var tempStr = "共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页";
  if(currentPage>1){
    tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+","+psize+")\">首页</a>";
    tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage-1)+","+psize+")\"><上一页</a>"
  }else{
    tempStr += "首页";
    tempStr += "<上一页";
  }
  if(currentPage<totalPage){
    tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">下一页></a>";
    tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+","+psize+")\">尾页</a>";
  }else{
    tempStr += "下一页>";
    tempStr += "尾页";
  }
  document.getElementById("barcon").innerHTML = tempStr;
}
</script>

  </head>
  
  <body onLoad="goPage(1,1);">
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
      	<td><form action="<%=basePath%>back/SeekInfoSvl" method="post" id="myForm">
      		<table>
      		   <tr><td align=left>用户名 </td><td><input type="text" name="uname"/></td></tr>
               <tr>
                   <td><input type=submit value="查询"/></td>
               </tr>
      		</table>
      		</form>
      	</td>
      </tr>
      
      
      <tr>
      	<td align=left>
      	  <table border="1" width=100%> 
      	   <tr><td>用户名</td><td>书名</td><td>购买日期</td><td>总付款</td><td>配送状况</td></tr>
      	  
      	<tr>
      	<td colspan=8>
      		<table id="idData" cellSpacing="0" cellPadding="1" width="100%" border="0" style="font-family:arial;color:red;font-size:12px;">	    		
	    			
	    			<c:forEach var="unit" items="${units}">		
       					<tr>
       				<td>${unit.uname}</td>
       				<td>${unit.bname}</td>
       				<td>${unit.payTime}</td>
       				  <td>${unit.allMoney}</td>
       				<td>${unit.stat}</td>
       				</tr> 
					</c:forEach>
	    	   		
	    		</table>	    	
      	</td>
      </tr>
      	  	
      	  	
      	  </table>
    	
      	</td>
      </tr>
    </table>
      <table width="60%" align="right">
    <tr><td><div id="barcon" name="barcon"></div></td></tr>
  </table>
  </body>
</html>
