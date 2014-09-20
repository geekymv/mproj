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
  	<h1>修改零件信息</h1>
	  	<form action="part/part-save" method="post">
	  		<%--设备id --%>
		  	<input type="hidden" name="part.id" value="${part.id }"/>	<br/>
		  	
		  	零件编号：<input type="text" name="part.num" value="${part.num }" readonly="readonly"/> <br/>
		  	零件名称：<input type="text" name="part.name" value="${part.name }"> <br/>
		  	使用年限：<input type="text" name="part.useYear" value="${part.useYear }"> <br/>
		  	已使用年限：<input type="text" name="part.usedYear" value="${part.usedYear }" readonly="readonly"> <br/>
		  	生产日期：<input type="text" name="part.proDate" value="${part.proDate }"> <br/>
		  	<s:if test="part.useDate != null">
		  	 	使用日期：<input type="text" name="part.useDate" value="${part.useDate }"> <br/>
		  	</s:if>
		 
		  	供应商：<input type="text" name="part.supplier" value="${part.supplier }"> <br/>
		  	
		  	<%--是否使用 --%>
		  	<input type="hidden" name="machine.status" value="${part.status }"> <br/>
			<%--为简单起见，这里使用struts2标签--%>
		  		<s:select list="#request.partTypes"
				name="part.type.id" label="零件类型"
				listKey="id" listValue="name">
				
				</s:select>	
		  	
		    <input type="submit" value="修改"/>	
    	</form>
  </body>
</html>


























