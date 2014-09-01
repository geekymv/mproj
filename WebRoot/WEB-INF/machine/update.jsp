<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新设备信息</title>
    
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
	<s:property value="machine.id"/>
	<form action="machine/machine!update" method="post">
		<%--设备的id--%>
		<input type="hidden" name="machine.id" value="<s:property value="machine.id"/>">
		<%--设备的状态(使用与未使用) --%>	
		<input type="hidden" name="machine.status" value="<s:property value="machine.status"/>">
		<!-- 设备的类型对应的id -->	
		<input type="hidden" name="machine.type.id" value="<s:property value="machine.type.id"/>">	
		
		设备编号 <s:property value="machine.num"/>	<br/>
		设备名称<input type="text" name="machine.name" value="<s:property value="machine.name"/>" /><br/>
		使用年限<input type="text" name="machine.useYear" value="<s:property value="machine.useYear"/>" /><br/>
		生产日期<input type="text" name="machine.proDate" value="<s:property value="machine.proDate"/>" /><br/>
		使用日期<input type="text" name="machine.useDate" value="<s:property value="machine.useDate"/>" /><br/>
		供应商<input type="text" name="machine.suppliper" value="<s:property value="machine.suppliper"/>" /><br/>
		<!-- 
		设备类型<input type="text" name="machine.type.typeName" value="<s:property value="machine.type.typeName"/>" /><br/>
		 -->
		 
		功能简介<input type="text" name="machine.function" value="<s:property value="machine.function"/>" /><br/>
		
		<input type="submit" value="更新"/>
		
	</form>

	<s:debug></s:debug>
  </body>
</html>










