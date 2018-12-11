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
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=path %>/js/popup_shuaxin.js"></script>
		
        <script language="javascript">
           function orderDetail(id)
           {
                 var strUrl="<%=path %>/order?type=orderDetail&id="+id;
                 var ret = window.showModalDialog(strUrl,"","dialogWidth:600px; dialogHeight:700px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
				 
           }
           
           function order_fenpai_songhuoyuan(id)
	       {
	            var url="<%=path %>/admin/order/order_fenpai_songhuoyuan.jsp?id="+id;
	        	var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
            	pop.setContent("contentUrl",url);
            	pop.setContent("title","操作窗口");
            	pop.build();
            	pop.show();
	       }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="44" background="<%=path %>/img/tbg.gif">&nbsp;订单信息管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="5%">序号</td>
					<td width="10%">订单号</td>
					<td width="10%">货物类型</td>
					<td width="10%">货物名称</td>
					<td width="10%">货物重量</td>
					<td width="10%">货物体积</td>
					<td width="10%">是否保值</td>
					<td width="10%">送货员</td>
					<td width="10%">回单信息</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.orderList}" var="order" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${order.danhao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${order.huoleixing}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${order.huomingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${order.huozhong}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${order.huotiji}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${order.baozhi}
					</td>
					<td bgcolor="#FFFFFF" align="center" style="color: red">
						 <c:if test="${order.songhuoyuan_id==0}">
						      未分派
						     &nbsp;&nbsp;
						     <a href="#" style="font-size: 10px;" onclick="order_fenpai_songhuoyuan(${order.id})">分配送货员</a>
						 </c:if>
						 <c:if test="${order.songhuoyuan_id!=0}">
						     已分派
						 </c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${order.songhuoyuan_huidan}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a style="color: red" href="#" onclick="orderDetail(${order.id})">订单明细</a>
						<a style="color: red" href="<%=path %>/order?type=orderDel&id=${order.id}">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
