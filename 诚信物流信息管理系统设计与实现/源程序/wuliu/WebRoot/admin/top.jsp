<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		<!--
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		}
		.STYLE1 {
			font-size: 12px;
			color: #FFFFFF;
		}
		.STYLE2 {
			font-size: 12px;
			color: #333333;
		}
		-->
		a:link {font-size:12px; color:#000000; text-decoration:none;}
		a:visited {font-size:12px; color:#000000; text-decoration:none;}
		a:hover {font-size:12px; color:#00CCFF;text-decoration:none;}
		.STYLE4 {font-size: 12px}
	</style>
    <script type="text/javascript">
       function out()
       {
           if(confirm("确定要退出本系统吗??"))
		   {
			   window.parent.location="<%=path %>/login.jsp";
		   }
       }
    </script>
  </head>
  
  <body>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="11" background="<%=path %>/img/main_03.gif"><img src="<%=path %>/img/main_01.gif" width="104" height="11"></td>
  </tr>
  <tr>
    <td height="36" background="<%=path %>/img/main_07.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="282" height="52">
            <div style="font-size:23px; WIDTH: 100%; COLOR: black;">
               &nbsp;&nbsp;<b>诚信物流管理系统</b>
            </div>
        </td>
        <td>
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td>
	              <img src="<%=path %>/img/uesr.gif" width="14" height="14">
	                  <span class="STYLE2"> 
	                         当前登录用户：
	                      <c:if test="${sessionScope.userType==0}">
	                                系统管理员
	                      </c:if> 
	                      <c:if test="${sessionScope.userType==1}">
	                            ${sessionScope.caozuoyuan.name }
	                      </c:if> 
	                      <c:if test="${sessionScope.userType==2}">
	                            ${sessionScope.songhuoyuan.name }
	                      </c:if>   
                      </span>
	              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	              <span class="STYLE4"><SCRIPT>setInterval("clock.innerHTML=new Date().toLocaleString()+'&nbsp;&nbsp;'+''.charAt(new Date().getDay());",1000)</SCRIPT><SPAN id=clock></SPAN>&nbsp;&nbsp;&nbsp;</span>
	            </td>
	          </tr>
	        </table>
        </td>
        <td width="283" background="<%=path %>/img/main_09.gif" align="right">
	        <span class="STYLE1"> <img src="<%=path %>/img/quit.gif" width="16" height="16"> </span>
	        <span class="STYLE4"><a href="#" onclick="out()">退出系统</a></span>
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
</html>
