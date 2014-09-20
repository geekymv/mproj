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
    <title>使用设备</title>

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
			  <a href="machine/prerepair.do" class="list-group-item">维修设备</a>
			</div>
		</div>
      </div>
      
      <div class="col-md-10">
        <div class="panel panel-primary">
          <div class="panel-heading">使用设备</div>
          	
          	请输入设备编号：<input type="text" id="mNum" name="num"/>
          	
          	<button id="use">使用</button>
          	
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
			
			/*验证设备是否已使用*/
			$(":input[id=mNum]").change(function(){
				
				var val = $(this).val();
				val = $.trim(val);
				var $this = $(this);
				
				if(val != ""){
					$this.nextAll("font").remove();
					
					var url = "<%=request.getContextPath()%>/isuse.do";
					var args = {"num":val};

					$.post(url, args, function(data){
						if(data == "notuse"){	
						}else if(data == "isuse"){
							$("#use").after("<font color='red'>该设备已使用</font>");
						}else {
							alert("没有该设备！");
						}
					});
					
				}else {
					alert("设备编号不能为空！");
					this.focus();
				}
			});
			
			/*使用设备*/
			$("#use").button().on( "click", function() {
				$.post("<%=request.getContextPath()%>/use.do", 
						{"num":$("#mNum").val()}, function(data){
				});
			});
			
		});

	</script>

  </body>
</html>

