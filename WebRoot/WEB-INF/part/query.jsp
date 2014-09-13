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
    <title>设备管理</title>

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
    		
    		$("#search").click(function(){
				$.post("<%=request.getContextPath()%>/queryMachine.do", {"num":$("#num").val()}, function(data){
					
					$("#content").empty();
					 
					if(data.machine == null){
						
						alert("查无结果！");
						return;
					}
					
					var html = "<table class='table table-bordered table-hover table-condensed'>"
							 + "<caption>设备信息</caption>"
							 + "<tr>"
							 + "<th>设备编号</th> <th>设备名称</th> <th>使用年限</th>"
					  		 + "<th>生产日期</th> <th>使用日期</th> <th>供应商</th> <th>设备类型</th>"
					  		 + "<th>设备状态</th> <th>选择操作</th>"
							 + "</tr>";
						
					var status = "未使用";
					var isUser = "无";
					if(data.machine.status == true){
						status = "已使用";
						isUser = data.machine.useDate;
					}	

					var id = data.machine.id;	/* 设备的id*/
					
					var operator =  '<div class="btn-group">' + 
					  '<button type="button" class="btn btn-success btn-sm">操作</button>'+
					  '<button type="button" class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown">'+
					    '<span class="caret"></span>'+
					    '<span class="sr-only">Toggle Dropdown</span>'+
					  '</button>'+
					  '<ul class="dropdown-menu" role="menu">'+
					    '<li><button type="button" class="btn btn-success">零件列表</li>'+
					 	'<li><a href="addPart.jsp?id='+id+'">添加零件</a></li>'+
					    '<li><a href="#">Something else here</a></li>'+
					    '<li class="divider"></li>'+
					    '<li><a href="#">Separated link</a></li>'+
					  '</ul>'+
					'</div>';
					
					
						html += "<tr>"

							 + "<td align='center'>"+data.machine.num+"</td>"+ "<td>"+data.machine.name+"</td>"
							 + "<td>"+data.machine.useYear+"</td>" + "<td>"+data.machine.proDate+"</td>"
							 + "<td>"+isUser+"</td>" + "<td>"+data.machine.suppliper+"</td>"
							 + "<td>"+data.machine.type.name+"</td>" + "<td>"+status+"</td>" + "<td>"+ operator +"</td>"
							 +"</tr>";

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
			  <a href="machine/machine-add.do" class="list-group-item">添加设备</a>
			  <a href="machine/query.do" class="list-group-item">查询设备</a>
			  <a href="machine/machine-list.do" class="list-group-item">设备列表</a>
			</div>
		</div>
      </div>
      
      <div class="col-md-10">
        <div class="panel panel-primary">
          <div class="panel-heading">查询设备</div>
          	
          	请输入设备编号：<input type="text" id="num" name="num"/>
          	
          	<input type="button" id="search" value="查询">
          	
          	
          	<div id="content"></div>
          	
          	<div id="listParts"></div>
          	
          	
        </div> <!-- end of panel -->
      </div>
	</div>
	</div>
	
   <div class="footer">
   </div>

  
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>

