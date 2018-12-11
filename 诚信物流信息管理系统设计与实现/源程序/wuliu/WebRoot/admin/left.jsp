<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	}
	-->
	</style>
	</head>

	<body>
	<body bgcolor="D6EBBD">
	    <c:if test="${sessionScope.userType==0}">
		<table width="173" height="100%" border="0" cellpadding="0"
			cellspacing="0" style="table-layout:fixed;">
			<tr>
				<td
					style="width:4px; background-image:url(<%=path%>/img/main_16.gif)">
					&nbsp;
				</td>
				<td width="169" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="20" background="<%=path%>/img/main_11.gif">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/admin/userinfo/userPw.jsp" target="I2" style="text-decoration:none">修改个人密码</a>
									</td>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/admin/gonggao/gonggaoAdd.jsp" target="I2" style="text-decoration:none">系统公告添加</a>
									</td>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/gonggao?type=gonggaoMana" target="I2" style="text-decoration:none">系统公告管理</a>
									</td>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/caozuoyuan?type=caozuoyuanMana" target="I2" style="text-decoration:none">操作员---管理</a>
									</td>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/songhuoyuan?type=songhuoyuanMana" target="I2" style="text-decoration:none">送货员---管理</a>
									</td>
								</table>
							</td>
						</tr>
						
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/order?type=orderMana_admin" target="I2" style="text-decoration:none">订单信息管理</a>
									</td>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</c:if>
		
		
		
		
		
		
		
		<c:if test="${sessionScope.userType==1}">
		<table width="173" height="100%" border="0" cellpadding="0"
			cellspacing="0" style="table-layout:fixed;">
			<tr>
				<td
					style="width:4px; background-image:url(<%=path%>/img/main_16.gif)">
					&nbsp;
				</td>
				<td width="169" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="20" background="<%=path%>/img/main_11.gif">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/admin/order/orderAdd.jsp" target="I2" style="text-decoration:none">客户订单录入</a>
									</td>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/order?type=orderMana_caozuoyuan" target="I2" style="text-decoration:none">客户订单管理</a>
									</td>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</c:if>
		
		
		
		
		
		
		
		
		
		
		
		<c:if test="${sessionScope.userType==2}">
		<table width="173" height="100%" border="0" cellpadding="0"
			cellspacing="0" style="table-layout:fixed;">
			<tr>
				<td
					style="width:4px; background-image:url(<%=path%>/img/main_16.gif)">
					&nbsp;
				</td>
				<td width="169" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="20" background="<%=path%>/img/main_11.gif">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
						</tr>
						<tr>
							<td height="10">
								<table>
									<td>
										&nbsp;&nbsp;&nbsp;
										<img src="<%=path%>/img/left_1.gif" width="31" height="31">
									</td>

									<td style="font-size:12px">
										<a href="<%=path %>/order?type=orderMana_songhuoyuan" target="I2" style="text-decoration:none">浏览我的任务</a>
									</td>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</c:if>
		
	</body>
</html>
