<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
 	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>

    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style type="text/css">
    	.container {
    		width: 960px;
    		background: #ccc;
    	}
    </style>
  </head>
  <body>

	<div class="container">
	
		<ul class="nav nav-pills" role="tablist">

			<li role="presentation" class="active">
				<a href="#">Home</a>
			</li>

 			<li role="presentation">
 				<a href="#">Profile</a>
 			</li>
 			<li role="presentation"><a href="#">Messages</a></li>
 			<li role="presentation"><a href="#">Home</a></li>
 			<li role="presentation"><a href="#">Profile</a></li>
 			<li role="presentation"><a href="#">Messages</a></li>
 			
			
			<li role="presentation" class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">
					Dropdown 
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu" role="menu">
				    <li><a href="#">Action</a></li>
				    <li><a href="#">Another action</a></li>
				    <li><a href="#">Something else here</a></li>
				    <li class="divider"></li>
				    <li><a href="#">Separated link</a></li>
				</ul>	
			</li>
		
		</ul>
	
		<hr/>		
	
		<div class="btn-group">
		  <button type="button" class="btn btn-danger">Action</button>
		  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
		    <span class="caret"></span>
		    <span class="sr-only">Toggle Dropdown</span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
		    <li><a href="#">Action</a></li>
		    <li><a href="#">Another action</a></li>
		    <li><a href="#">Something else here</a></li>
		    <li class="divider"></li>
		    <li><a href="#">Separated link</a></li>
		  </ul>
		</div>
		
		
		<hr/>

		<ul class="nav nav-pills  nav-stacked" role="tablist">
		  <li role="presentation" class="active"><a href="#">Home</a></li>
		  <li role="presentation"><a href="#">Profile</a></li>
		  <li role="presentation"><a href="#">Messages</a></li>
		</ul>
		
		
    </div> 

    <script src="jquery/jquery-1.11.1.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>




