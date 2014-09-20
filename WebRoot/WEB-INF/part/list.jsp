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
    <title>零件管理</title>

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
			  <a href="part/query.do" class="list-group-item">查询零件</a>
			  <a href="part/part-list.do" class="list-group-item">零件列表</a>
			</div>
		</div>
      </div>
      
      <div class="col-md-10">
        <div class="panel panel-primary">
          <div class="panel-heading">零件管理</div>
          <div class="panel-body">
            <p>Panel body</p>
          </div>
        
          <!-- Table -->
          <table class="table table-bordered table-hover table-condensed">
            <thead>
                <tr>
                   	<th>零件编号</th> <th>零件名称</th> <th>使用年限</th> <th>已使用年限</th>
		  			<th>生产日期</th> <th>使用日期</th> <th>供应商</th> <th>零件类型</th>
		  			<th>零件状态</th> <th>选择操作</th>
                </tr>
            </thead>
            <tbody>
            	<s:if test="#request.pageUtil == null || #request.pageUtil.datas.size() == 0">
            		没有零件信息！
            	</s:if>
            	<s:else>
            		<s:iterator value="#request.pageUtil.datas">
				  		<tr>
				  			<td>${num }</td>
				  			<td><s:property value="name"/></td>
				  			<td><s:property value="useYear"/></td>
				  			<td><s:property value="usedYear"/></td>
				  			
				  			<td>
				  				<s:date name="proDate" format="yyyy-MM-dd"/>
				  			</td>
				  			<td>
				  				<s:date name="useDate" format="yyyy-MM-dd"/>
				  			</td>
				  			<!-- 
				  			<td><s:property value="#m.useDate"/></td>
				  			 -->
				  			<td><s:property value="supplier"/></td>
				  			<td><s:property value="type.name"/></td>
				  			
				  			<%--设备状态 --%>
				  			<s:if test="status == false">
				  				<td>未使用</td>
				  			</s:if>
				  			<s:else>
				  				<td>已使用</td>
				  			</s:else>

				  			<td>
				  				<a href="part/part-edit.do?id=${id }">修改</a>|
				  				<a href="part/part-delete.do?id=${id }">删除</a>
				  			</td>
				  			
				  		</tr>
	  				</s:iterator>
            	</s:else>
              
            </tbody>
            
          </table>
            <div class="panel-footer">
          	 <ul class="pager">

          	 	<li>当前页 ：<s:property value="page"/>&nbsp;&nbsp;</li>
          	 	<li>总页数：<s:property value="#request.pageUtil.totalPage"/></li>
          	 	
          	 	<s:if test="page-1 > 0">
          	 		<li><a href="machine/machine-list.do?page=<s:property value=" page-1 "/>" >上一页</a></li>
          	 	</s:if>
		
				<s:set var="totalPage" value="#request.pageUtil.totalPage"></s:set>
				<%-- totalPage: <s:property value="#totalPage"/>--%>
          	 	<s:if test="page+1 <= #totalPage">
			  		<li><a href="machine/machine-list.do?page=<s:property value=" page+1 "/>" >下一页</a></li>
          	 	</s:if>
          	 	
			</ul>
          </div>
        </div> <!-- end of panel -->
      </div>
	</div>
	</div>
	
   <div class="footer">
   </div>

    <script src="jquery/jquery-1.11.1.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>

