<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
   String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" /> 
  </head>
  
  <body id="greenxf" class="view">
       <div class="wrapper">
		    <!-- header -->
		    <jsp:include flush="true" page="/qiantai/inc/incTop1.jsp"></jsp:include> 
		    <jsp:include flush="true" page="/qiantai/inc/incTop2.jsp"></jsp:include> 
            <!-- header --> 
            <!-- body -->   
            <div class="content cols2">
		        <div class="col2 software-view">
		            <div class="cp cp-black">
			            <div class="cp-top">
			                <h3>系统公告信息</h3>
			            </div>
			            <div class="cp-main">
			                 <TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" border=0>
								<TR align="left">
									<TD height="5"></TD>
								</TR>
								<TR align="left" height="460">
									<TD align="center" valign="top">
										<c:forEach items="${requestScope.gonggaoList}" var="gonggao">
										<div class="c1-bline" style="padding:7px 0px;">
					                        <div class="f-left">
					                             <img src="<%=path %>/img/head-mark4.gif" align="middle" class="img-vm" border="0"/> 
					                             <a href="<%=path %>/gonggao?type=gonggaoDetailQian&id=${gonggao.id}">${gonggao.title}</a>
					                        </div>
					                        <div class="f-right">${gonggao.shijian}</div>
					                        <div class="clear"></div>
				                        </div>
				                        </c:forEach>
									</TD>
								</TR>
								<TR align="left">
									<TD height="5"></TD>
								</TR>
						     </TABLE>
			            </div>
		            </div>
		        </div>
            </div>
            <!-- body -->
            
            
            <!-- foot -->
			<jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
			<!-- foot -->
       </div>
  </body>
</html>
