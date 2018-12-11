<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		color: #147233;
	}
	-->
	</style>

  </head>
  
  <body>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="23" background="<%=path %>/img/main_25.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="181" height="23" background="<%=path %>/img/main_24.gif">&nbsp;</td>
	        <td>
	           <div align="right" class="STYLE1">
					<SCRIPT>setInterval("clock.innerHTML=new Date().toLocaleString()+'&nbsp;&nbsp;'+''.charAt(new Date().getDay());",1000)</SCRIPT><SPAN id=clock></SPAN>&nbsp;&nbsp;&nbsp;
			   </div>
		   </td>
	        <td width="25"><img src="<%=path %>/img/main_27.gif" width="25" height="23" /></td>
	      </tr>
	    </table></td>
	  </tr>
	</table>
  </body>
</html>
