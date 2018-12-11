<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <script type="text/javascript">
         function admin()
         {
            var url="<%=path %>/login.jsp";
            window.open(url,"_blank");
         } 
         
         function order_search_pre()
         {
                var url="<%=path %>/qiantai/order/order_search_pre.jsp";
                window.location.href=url;
         } 
      </script>
  </head>
  
  <body>
     <div class="header">
        <ul class="nav">
            <li><a href="<%=path %>/qiantai/default.jsp">网站首页</a></li>
            <li><a href="#" onclick="order_search_pre()">订单查询</A></li>
            <li><a href="<%=path %>/gonggao?type=gonggaoAll">系统公告信息</A></li>
			<li><a href="#" onclick="admin()">系统后台</a></li>
        </ul>
     </div> 
  </body>
</html>
