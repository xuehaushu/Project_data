<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <frameset rows="63,*,23" frameborder="no" border="0" framespacing="0">
	  <frame src="<%=path %>/admin/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
	  <frame src="<%=path %>/admin/center.jsp" name="mainFrame" id="mainFrame" />
	  <frame src="<%=path %>/admin/down.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
  </frameset>
  <noframes><body></body></noframes>
</html>