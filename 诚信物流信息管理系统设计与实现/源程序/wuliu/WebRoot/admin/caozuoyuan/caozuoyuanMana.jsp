<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function caozuoyuanDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/caozuoyuan?type=caozuoyuanDel&id="+id;
               }
           }
           
           function caozuoyuanAdd()
           {
                 var url="<%=path %>/admin/caozuoyuan/caozuoyuanAdd.jsp";
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="9" background="<%=path %>/images/tbg.gif">&nbsp;操作员信息管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">姓名</td>
					<td width="10%">性别</td>
					<td width="10%">年龄</td>
					<td width="15%">电话</td>
					<td width="10%">住址</td>
					<td width="10%">账号</td>
					<td width="10%">密码</td>
					<td width="15%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.caozuoyuanList}" var="caozuoyuan">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${caozuoyuan.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${caozuoyuan.sex}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${caozuoyuan.age}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${caozuoyuan.tel}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${caozuoyuan.address}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${caozuoyuan.loginname}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${caozuoyuan.loginpw}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="caozuoyuanDel(${caozuoyuan.id})" class="pn-loperator">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="caozuoyuanAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
