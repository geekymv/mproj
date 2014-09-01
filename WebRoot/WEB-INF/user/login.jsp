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
    <title>用户登录</title>

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
    	}
    	
    	.errors{
    		background-color: red;
    	}
    	
    </style>
  </head>
  <body>

	<div class="container">
		<h1 class="page-header">用户登录</h1>
		<form class="form-horizontal" role="form"  action="user/user!login" method="post">
			<fieldset> 
				<legend>登录也是一种美德哦！</legend>	
				<div class="errors">
					<s:property value="actionErrors[0]"/>
				</div>
			  	<div class="form-group">
			    	<label class="col-sm-5 control-label" for="usermame">用户名</label>
			   		<div class="col-sm-3">
			      		<input type="text" class="form-control" placeholder="username" id="usermame" name="user.username" required autofocus>
			  			<span class="help-block">请输入用户名</span>
			  		</div>
			  	</div>
			  
			  	<div class="form-group">
			    	<label class="col-sm-5 control-label" for="password">密码</label>
			    	<div class="col-sm-3">
			      		<input type="password" class="form-control" id="password" placeholder="password" name="user.password" required>
			    		<span class="help-block">请输入密码</span>
			    	</div>
			  	</div>
			  
			  	<div class="form-group">
			  		<div class="col-sm-offset-5 col-sm-7">
			  			<div class="checkbox">
					 	<label>
					  	  <input type="checkbox" name="rememberMe" value="rememberMe"/>  记住我一辈子
					    </label>
					    </div>
				    </div>
 				</div>

				<input type="submit" class="btn btn-success col-sm-offset-5 col-md-3" value="登录"/> 
			</fieldset>
		</form>
		
    </div> 

    <script src="jquery/jquery-1.11.1.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>




