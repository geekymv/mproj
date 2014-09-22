<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
  	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>零件使用记录</title>

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<style type="text/css">
		.custom{
			height:51px;
		}
		.footer {
			background-color:  #333;
			width: 100%;
			height: 200px;
			margin-top: 450px;
		}
		.form{
			margin-left: 300px;
		}
		input {
			margin: 6px;
		}
		.panel {
			min-height: 400px;
		}
		
	</style>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="jquery/jquery-1.11.1.js"></script>
    <script type="text/javascript">
    
    	$(function(){
    		
    		$("#show").click(function(){
				$.post("<%=request.getContextPath()%>/part/record-list.do", {"partNum":$("#num").val()}, function(data){
					
					$("#content").empty();
					 
					if(data.partUsageRecords == null || data.partUsageRecords.length == 0){
						alert("查无结果！");
						return;
					}
					var html = "<table class='table table-bordered table-hover table-condensed'>"
							 + "<caption>零件使用记录</caption>"
							 + "<tr>"
							 + "<th>零件编号</th> <th>零件名称</th> <th>设备名称</th>"
					  		 + "<th>使用日期</th> <th>截止日期</th> <th>是否可用</th>"
							 + "</tr>";
						
						var usable = "可用";	 
						for(var i = 0; i < data.partUsageRecords.length; i++){
							var record = data.partUsageRecords[i];
							
							if(record.usable == false){
								usable = "不可用";
							}
							
						html += "<tr>"
							 + "<td align='center'>"+record.part.num+"</td>"+ "<td>"+record.part.name+"</td>"
							 + "<td>"+record.machine.name+"</td>" + "<td>"+record.startDate+"</td>"
							 + "<td>"+record.endDate+"</td>" 
							 + "<td>"+usable+"</td>"
							 +"</tr>";
						}	 

						html += "</table>";
					 
					 $("#content").append(html);
					
				}, "json");
				
			});
    		
    	});
    
    
    </script>
    
    
    
  </head>
  <body>
  	<div class="container">
  	
  	<jsp:include page="nav.jsp"></jsp:include>
  	
 	<div class="row">
      <div class="col-md-2">
   	 	<div class="panel panel-primary">
	        <div class="panel-heading">功能导航</div>
		   	<div class="list-group">
		   		<a href="part/part-add.do" class="list-group-item">添加零件</a>
				<a href="part/part-list.do" class="list-group-item">零件列表</a>
				<a href="part/record.do" class="list-group-item">使用记录</a>
				<a href="part/prescrap.do" class="list-group-item">报废零件</a>
				<a href="type/parttype-add.do" class="list-group-item">添加零件类型</a>
			</div>
		</div>
      </div>
      
      <div class="col-md-10">
        <div class="panel panel-primary">
          <div class="panel-heading">零件使用记录</div>
          	
          	请输入零件编号：<input type="text" id="num" name="partNum"/>
          	
          	<input type="button" id="show" value="查询">
          	
          	<div id="content"></div>
          	
        </div> <!-- end of panel -->
      </div>
	</div>
	</div>
	
   <div class="footer">
   </div>

  
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>

