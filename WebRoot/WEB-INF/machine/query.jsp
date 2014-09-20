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
	
	<link rel="stylesheet" type="text/css" href="jquery-ui/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="jquery-ui/jquery-ui.theme.css">
	
	
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
	    /*
    	function show(num){
			var num = num;
		//	window.open("/lbrms/admin/showBookInfo.jsp?bookId="+bookId,"dzxx","width=500px,height=300px,left=400px,top=200px");
		//	window.open("index.jsp","dzxx","width=500px,height=300px,left=400px,top=200px");
	   		alert(num);
	    }
    	*/
    	
    	$(function(){
    		/*获得设备上所有的零件*/
    		$("#getParts").button().on("click", function() {
    			$.post("<%=request.getContextPath()%>/listParts.do", {"num":$("#mNum").val()}, function(data){
				
				$("#listParts").empty();
				if(data.parts == null || data.parts.length == 0){
					alert("没有查到该设备上的零件！");
					return;
				}

				var html = "<table class='table table-bordered table-hover table-condensed'>"
					 + "<caption>零件信息</caption>"
					 + "<tr>"
					 + "<th>零件编号</th> <th>零件名称</th> <th>设备类型</th>"
			  		 + "<th>生产日期</th> <th>使用日期</th> "
			  		 + "<th>使用年限</th> <th>供应商</th>"
					 + "</tr>";
					 
    			for(var i = 0; i < data.parts.length; i++){
    				
    				var part = data.parts[i];
    				
    				html += "<tr>"

						 + "<td align='center'>"+part.num+"</td>"+ "<td>"+part.name+"</td>"
						 + "<td>"+part.type.name+"</td>" + "<td>"+part.proDate+"</td>"
						 + "<td>"+part.useDate+"</td>" + "<td>"+part.useYear+"</td>" 
						 + "<td>"+part.supplier+"</td>"
						 +"</tr>";
    			}
    				html += "</table>";
    			
    				
    				$("#listParts").append(html);	
    			});
    		});
    		
    		/*异步查询设备*/
    		$("#search").button().on("click", function(){
				$.post("<%=request.getContextPath()%>/queryMachine.do", {"num":$("#mNum").val()}, function(data){
					
					$("#content").empty();
					 
					if(data.machine == null){
						
						alert("没有查到该设备！");
						return;
					}
					
					/*
					var operator = "";
					var addPart = "";
					
					if(data.machine.status == true){	//使用
						operator = 	"<th>操作</th>";					
					
						addPart = '<td><button type="button" onclick="addPart()">添加零件</button></td>';
					}
					*/
					
					var html = "<table class='table table-bordered table-hover table-condensed'>"
							 + "<caption>设备信息</caption>"
							 + "<tr>"
							 + "<th>设备编号</th> <th>设备名称</th> <th>使用年限</th>"
					  		 + "<th>生产日期</th> <th>使用日期</th> <th>供应商</th> <th>设备类型</th>"
					  		 + "<th>设备状态</th>" //+ operator
							 + "</tr>";
						
					var status = "未使用";
					var isUser = "无";
					if(data.machine.status == true){
						status = "已使用";
						isUser = data.machine.useDate;
					}	

					var id = data.machine.id;	/* 设备的id*/
						html += "<tr>"
							 + "<td align='center'>"+data.machine.num+"</td>"+ "<td>"+data.machine.name+"</td>"
							 + "<td>"+data.machine.useYear+"</td>" + "<td>"+data.machine.proDate+"</td>"
							 + "<td>"+isUser+"</td>" + "<td>"+data.machine.suppliper+"</td>"
							 + "<td>"+data.machine.type.name+"</td>" + "<td>"+status+"</td>" //+ addPart
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
			  <a href="machine/use.do" class="list-group-item">使用设备</a>
			</div>
		</div>
      </div>
      
      <div class="col-md-10">
        <div class="panel panel-primary">
          <div class="panel-heading">查询设备</div>
          	
          	请输入设备编号：<input type="text" id="mNum" name="num"/>
          	
          	<button id="search">查询</button>
          	
          	<button id="getParts">查看零件</button>
          	
          	<button id="addParts" class="">添加零件</button>
          	
			<%-- 设备显示区--%>
          	<div id="content"></div>
          	
          	<%-- 零件显示区--%>
          	<div id="listParts"></div>
          	
          	
          	<%-- 显示添加零件的弹出框--%>
          	<div id="addDialog" title="添加零件">
          		输入零件编号：<input type="text" id="pNum" name="pNum"/> <br />
          	</div>
          	
        </div> <!-- end of panel -->
      </div>
	</div>
	</div>
	
   <div class="footer">
   
   </div>

    <script src="bootstrap/js/bootstrap.min.js"></script>

	<script src="jquery-ui/jquery/jquery.js"></script>
	<script src="jquery-ui/jquery-ui.js"></script>
	
	<script type="text/javascript">
		
		$(function() {
			var dialog;
			
			function add(){
				//异步添加零件
				$.post("<%=request.getContextPath()%>/addPart.do", 
						{"machineNum":$("#mNum").val(), "partNum":$("#pNum").val()}, function(data){
							
					dialog.dialog( "close" );	//关闭添加零件弹出框
				});
			}
			
			dialog = $("#addDialog").dialog({
				autoOpen : false,
				height : 200,
				width : 350,

				buttons : {
					"添加" : add,
					"取消 ": function() {
						dialog.dialog("close");
					}
				},
			});
				
			$("#addParts").button().on( "click", function() {
				 dialog.dialog( "open" );
			});
			
		});

	</script>

  </body>
</html>

