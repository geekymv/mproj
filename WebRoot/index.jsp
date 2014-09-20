<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="zh-CN">
	<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<title>首页</title>
	
	<link rel="stylesheet" type="text/css" href="bootmetro/css/bootmetro.css" />
	<link rel="stylesheet" type="text/css" href="bootmetro/css/bootmetro-icons.css" />
	<link rel="stylesheet" type="text/css" href="bootmetro/css/bootmetro-ui-light.css" />

	<script type="text/javascript" src="bootmetro/js/jquery-1.10.0.js"></script>
	<script type="text/javascript" src="bootmetro/js/bootmetro.js"></script>
	
	
	<style type="text/css">
		body {
			background:url("img/bkg.jpg");
		}
		.container {
			width: 80%;
		}
		
		.listview-item {
			width: 280px;
		}
		/*		
		.span9 {
			background: red;
		}
		.span3 {
			background: blue;
		}
		*/
		.footer {
			background-color:  #333;
			width: 100%;
			height: 200px;
			
			margin-top: 150px;
		}
	</style>
	
	
	</head>

<body>
	<div class="container">
	
	<div class="navbar">
		<div class="navbar navbar-static-top">
			<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a>
			 
			<!-- Be sure to leave the brand out there if you want it shown -->
			<a class="brand" href="#">煤矿机械设备溯源系统</a>
			 
			<!-- Everything you want hidden at 940px or less, place within here -->
			<div class="nav-collapse collapse">
			<!-- .nav, .navbar-search, .navbar-form, etc -->
			</div>
			 
			</div>
		</div>
	</div>
    
    <div class="row">
      <div class="span9">
       <pre>
       	系统简介：
	    	通过RFID技术读取设备和零件的ID号，掌握设备的使用、维修情况，
	    	实现煤矿机械设备整个生命周期的质量跟踪，为设备的安全可靠运行提供保障。
	    	通过设备管理、零件管理、溯源管理和系统管理几个模块，实现系统的功能，达到用户的要求。
		</pre>
      </div>
      
      <div class="span3">
			<div class="listview list-layout">
			<div class="listview-item bg-color-blue" onclick="location.href='<%=basePath%>machine/machine-list.do';">
				<div class="pull-left">
					<img class="listview-item-object icon icon-box" /> 
				</div>
				<div class="listview-item-body">
					<h4 class="listview-item-heading">设备管理</h4>
					<p class="two-lines">Body text that wraps over two lines.
						Vivamus elementum semper nisi.</p>
				</div>
			</div>
	
			<div class="listview-item bg-color-green" onclick="location.href='<%=basePath%>part/part-list.do';">
				<div class="pull-left">
					<img class="listview-item-object icon icon-wrench" />
				</div>
				<div class="listview-item-body">
					<h4 class="listview-item-heading">零件管理</h4>
					<p>Single line. Lorem ipsum sin ut dolorem</p>
					<p>Single line. Lorem ipsum sin ut dolorem</p>
				</div>
			</div>
	
			<div class="listview-item bg-color-orange">
				<div class="pull-left" href="#">
					<img class="listview-item-object icon icon-paperplane">
				</div>
				<div class="listview-item-body">
					<h4 class="listview-item-heading">溯源管理</h4>
					<p class="two-lines">
						Body text that wraps over three lines.
					</p>
				</div>
			</div>
			<div class="listview-item bg-color-purple">	<!--  selected -->
				<div class="pull-left" href="#">
					<img class="listview-item-object icon icon-users">
				</div>
				<div class="listview-item-body">
					<h4 class="listview-item-heading">用户管理</h4>
					<p class="two-lines">Body text that wraps over two lines.
						Vivamus elementum semper nisi.</p>
				</div>
			</div>
	
			<div class="listview-item bg-color-blue">
				<div class="pull-left" href="#">
					<div class="listview-item-object">
						<img class="listview-item-object icon icon-cog"></img>
					</div>
				</div>
				<div class="listview-item-body">
					<h4 class="listview-item-heading">系统设置</h4>
					<p class="two-lines">Body text that wraps over two lines,
						IcoMoon icon on the left.</p>
				</div>
			</div>
			</div>
      </div>
      
	</div>
    
   </div><!-- /.container -->
   
   
   <div class="footer">
   
   </div>


<script type="text/javascript" src="jquery/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
