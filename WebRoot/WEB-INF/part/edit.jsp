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
    
    <title>修改零件信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1>修改设备信息</h1>
	  	<form action="machine/machine-save" method="post">
	  		<%--设备id --%>
		  	<input type="hidden" name="machine.id" value="${machine.id }"/>	<br/>
		  	
		  	设备编号：<input type="text" name="machine.num" value="${machine.num }" readonly="readonly"/> <br/>
		  	设备名称：<input type="text" name="machine.name" value="${machine.name }"> <br/>
		  	使用年限：<input type="text" name="machine.useYear" value="${machine.useYear }"> <br/>
		  	生产日期：<input type="text" name="machine.proDate" value="${machine.proDate }"> <br/>
		  	<s:if test="machine.useDate != null">
		  	 	使用日期：<input type="text" name="machine.useDate" value="${machine.useDate }"> <br/>
		  	</s:if>
		 
		  	供应商：<input type="text" name="machine.suppliper" value="${machine.suppliper }"> <br/>
		  	功能简介：<input type="text" name="machine.function" value="${machine.function }"> <br/>
		  	
		  	<%--是否使用 --%>
		  	<input type="hidden" name="machine.status" value="${machine.status }"> <br/>
			<%--为简单起见，这里使用struts2标签--%>
		  		<s:select list="#request.machineTypes"
				name="machine.type.id" label="设备类型"
				listKey="id" listValue="name">
				
				</s:select>	
		  	
		    <input type="submit" value="修改"/>	
    	</form>
  </body>
</html>


























