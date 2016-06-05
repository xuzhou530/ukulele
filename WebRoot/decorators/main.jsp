<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="sitemesh-decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <!-- 这里并不会载入title 要单独加 -->
	<sitemesh-decorator:head />
	<title><sitemesh-decorator:title /></title>
  </head>
  	
  <body>
  hahaha
    <sitemesh-decorator:body />
  </body>
</html>
