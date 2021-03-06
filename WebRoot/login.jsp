<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>用户登录</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

*:focus {
	outline: none
}

html,body {
	width: 100%;
	height: 100%;
}

body {
	font-family: Microsoft Yahei, Arial;
	/*
	 	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#4ea1e9', endColorstr='#cee9f8' );
	*/
	background: linear-gradient(top, #4ea1e9, #cee9f8);
	background: -moz-linear-gradient(top, #4ea1e9, #cee9f8);
	background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#4ea1e9), to(#cee9f8));
	box-shadow: none;
	background-size: 100% 100%;
}

.login_tit {
	width: 300px;
	height: 34px;
	background: url("img/login_tit.png") no-repeat left top;
	margin: 150px auto 0px;
	text-align: center;
	font-size: 25px;
	color: #1d89e3;
}

.login_main {
	position: relative;
	width: 448px;
	height: 228px;
	padding-top: 20px;
	background: url("img/login_main.png") no-repeat left top;
	margin: 30px auto 0px;
}

.login_main p {
	width: 448px;
	float: left;
	margin-top: 25px;
}

.login_main p span {
	width: 100px;
	height: 33px;
	line-height: 33px;
	float: left;
	text-align: right;
	color: #0d1215;
	font-size: 14px;
	font-family: "微软雅黑";
}

.login_main p .input_01 {
	width: 238px;
	height: 33px;
	line-height: 33px;
	float: left;
	margin-left: 15px;
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#dde4ec',
		endColorstr='#f0f2f1' );
	background: linear-gradient(top, #dde4ec, #f0f2f1);
	background: -moz-linear-gradient(top, #dde4ec, #f0f2f1);
	background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#dde4ec),
		to(#f0f2f1) );
	-moz-border-radius: 5px;
	-khtml-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	color: #7a8288;
	text-indent: 10px;
	font-family: "微软雅黑";
	box-shadow: 0px 1px 1px #7d8b8e inset;
	border: 1px solid #f5fdff;
}

.login_main p .input_02 {
	width: 147px;
	height: 38px;
	float: left;
	margin-left: 15px;
	border: 0px;
	background: url("img/login_but.png") no-repeat left top;
	cursor: pointer;
}

.login_main p .input_02:hover {
	width: 147px;
	height: 38px;
	float: left;
	margin-left: 15px;
	border: 0px;
	background: url("img/login_but_hov.png") no-repeat left top;
	cursor: pointer;
}

.login_user {
	width: 97px;
	height: 135px;
	position: absolute;
	right: -2px;
	bottom: -4px;
	margin-top: -33px;
	margin-left: 134px;
	background: url("img/login_user.png") no-repeat left top;
	z-index: 1;
}
</style>

</head>
<body>
	<div class="login_tit"></div>

	<div class="login_main">
		<s:form action="user/user-login.do" method="post">
			<p>
				<span>用户名</span> <input name="username" type="text" id="logid"
					class="input_01" placeholder="用户名" />
				
				<s:fielderror fieldName="username">
				</s:fielderror>	
					
			</p>
			<p>
				<span>密&nbsp;&nbsp;&nbsp;码</span> <input name="password"
					type="password" id="password" class="input_01" placeholder="密码" />
				
					<s:fielderror fieldName="password">
					</s:fielderror>	
				
			</p>
			<p>
				<span></span> <input id="btnLogin" name="btnLogin" type="submit" value=""
					class="input_02" />
			</p>
		</s:form>

		<div class="login_user"></div>

	</div>
</body>
</html>
