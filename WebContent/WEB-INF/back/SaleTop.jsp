<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>销售情况</title>
     <meta charset="utf-8">
      <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
      <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
  </head>
  
  <body">
  <table align="center" width=90%>
    	 <tr>
      	<td align=right>
      	    
      	  		管理员: admin &nbsp;	  		
      			<a href="#">退出</a>
      		      	
      	</td>       	
      </tr>
      <jsp:include page="bhead.jsp"></jsp:include>
      <tr><td align="left"><h2>图书销量排名</h2></td></tr>
      
      <!-- 查询条件 -->
      <tr>
      	<td>
      	   <form action="<%=basePath%>back/SaleTopSvl" method="post">
      		<table border=0>
               <tr>
                     <td><input type="radio" name="pie" value="1" onclick="pieChart.style.display='';barChart.style.display='none';" checked>Pie Chart
                     
 &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="pie" value="2" onclick="pieChart.style.display='none';barChart.style.display='';">Bar Chart
                 
                      <td><input type=submit value="查询"/></td>
               </tr>  
      		</table>
      	   </form>
      	</td>
    </table>
      <div id="pieChart" style="width: 600px;height:400px;"></div>
    <div id="barChart" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
   
        // 基于准备好的dom，初始化echarts实例
        var BARChart = echarts.init(document.getElementById('barChart'));
        var PIEChart = echarts.init(document.getElementById('pieChart'));
        var books=[];
 	   <c:forEach var="od" items="${units}">
        books.push("${od.bname}");
        </c:forEach>
        var  nums=[];
        <c:forEach items="${units}" var="l">
        nums.push("${l.sumNum}");
        </c:forEach>
        
        var f = [];

        for(var i=0; i < books.length; i++) {
            f.push({
                value:nums[i],
                name:books[i]           
            });        
        }    var option = {
                title: {
                    text: '图表'
                },
                tooltip: {},
                legend: {
                    data:['销量']
                },
                xAxis: {
                    data:books
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data:nums
                }]
            };
     
            // 使用刚指定的配置项和数据显示图表。
            BARChart.setOption(option);
        PIEChart.setOption({
            series : [
                {
                    name: '访问来源',
                    type: 'pie',    // 设置图表类型为饼图
                    radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                    data:f
                    }
            ]
        })

        

    </script>
  </body>
</html>
