<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加设备</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="jquery/jquery-1.11.1.js"></script>
	
	<script type="text/javascript">

		$(function(){
	

			alert("hello world");




		});
	
	</script>

  </head>
  
  <body>
  		<h1>添加设备</h1>
	  	<form action="machine/machine-save" method="post">
		  	
		  	设备编号：<input type="text" name="machine.num" /> <br/>
		  	设备名称：<input type="text" name="machine.name" /> <br/>
		  	使用年限：<input type="text" name="machine.useYear" /> <br/>
		  	生产日期：<input type="text" name="machine.proDate" /> <br/>
		  	供应商：<input type="text" name="machine.suppliper" /> <br/>
		  	功能简介：<input type="text" name="machine.function" /> <br/>
		  	
			<%--
				为简单起见，这里使用struts2标签
			 --%>
		  		<s:select list="#request.machineTypes"
				name="machine.type.id" label="设备类型"
				listKey="id" listValue="name">
				
				</s:select>	
		  	
		    <input type="submit" value="添加"/>	
    	</form>
  </body>
</html>


























