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
    <title>添加零件</title>

	<!-- jquery ui 
	<link rel="stylesheet" type="text/css" href="jquery-ui/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="jquery-ui/jquery-ui.theme.css">
	-->

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
		
	</style>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
			</div>
		</div>
      </div>
      
      <div class="col-md-10">
        <div class="panel panel-primary">
          <div class="panel-heading">添加设备</div>
          
          <div class="form">
	          <form action="part/part-save" method="post">
			  	
			  	零件编号：<input type="text" name="part.num" /> <br/>
			  	零件名称：<input type="text" name="part.name" /> <br/>
			  	使用年限：<input type="text" name="part.useYear" /> <br/>
			  	生产日期：<input type="text" name="part.proDate" /> <br/>
			  	供应商：<input type="text" name="part.supplier" /> <br/>
			  	零件类型：<s:select list="#request.partTypes"
					name="part.type.id"
					listKey="id" listValue="name">
					
					</s:select>	
			  	<br />
			    <input type="submit" id="add" value="添加"/>	
	    	</form>
		</div>
        </div> <!-- end of panel -->
      </div>
	</div>
	</div>
	
	<%--添加成功确认框 
	<div id="dialog-message" title="添加成功">
		<p>
			<span class="ui-icon ui-icon-circle-check"
				style="float:left; margin:0 7px 50px 0;">
			</span> 
			添加设备成功！
		</p>
	</div>
	--%>
	
	
	
   <div class="footer">
   </div>

    <script src="jquery/jquery-1.11.1.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    

<%--    
<script src="jquery-ui/jquery/jquery.js"></script>
<script src="jquery-ui/jquery-ui.js"></script>    
<script type="text/javascript">
	$(function() {
		$("#add").click(function(){
			$("#dialog-message").dialog("open");			
		});
		
		
		$("#dialog-message").dialog({
			//	modal : true,
			autoOpen: false,
			buttons : {
				确定 : function() {
					$(this).dialog("close");
			//		window.location.href="index.jsp"; 
				}
			}
		});
	});
	
</script>
--%>    
    
  </body>
</html>

