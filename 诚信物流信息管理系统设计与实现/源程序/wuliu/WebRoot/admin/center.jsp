<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
			overflow:hidden;
			}
			-->
		</style>
		<style> 
			.navPoint { 
			COLOR: white; CURSOR: hand; FONT-FAMILY: Webdings; FONT-SIZE: 9pt 
			} 
		</style>
		<script>
			function switchSysBar()
			{ 
				var locate=location.href.replace('<%=path%>/admin/center.jsp','');
				var ssrc=document.all("img1").src.replace(locate,'');
				if (ssrc=="<%=path%>/img/main_18.gif")
				{ 
					document.all("img1").src="<%=path%>/img/main_18_1.gif";
					document.all("frmTitle").style.display="none" 
				} 
				else
				{ 
					document.all("img1").src="<%=path%>/img/main_18.gif";
					document.all("frmTitle").style.display="" 
				} 
			} 
       </script>

	</head>

	<body>
		<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;">
		  <tr>
		    <td width="173" id=frmTitle noWrap name="fmTitle" align="center" valign="top">
				<iframe name="I1" height="100%" width="180" src="<%=path%>/admin/left.jsp" border="0" frameborder="0" scrolling="no">
				</iframe>	
			</td>
		    <td width="8" valign="middle" background="<%=path%>/img/main_12.gif" onclick=switchSysBar()>
		        <span class="navPoint"><img src="<%=path%>/img/main_18.gif" name="img1" width=8 height=52 id=img1></span>
		    </td>
		    <td align="center" valign="top">
			    <iframe name="I2" height="100%" width="100%" border="0" frameborder="0" src="<%=path %>/admin/index/sysPro.jsp"> 
			    </iframe>
		    </td>
		    <td width="4" align="center" valign="top" background="<%=path%>/img/main_20.gif">　
		    </td>
		  </tr>
</table>
		
	</body>
</html>
