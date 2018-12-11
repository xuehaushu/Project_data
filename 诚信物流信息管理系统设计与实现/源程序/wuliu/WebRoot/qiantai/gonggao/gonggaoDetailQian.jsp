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
      <script type="text/javascript" src="<%=path %>/js/popup_shuaxin_no.js"></script>
      <script type="text/javascript">
          function back()
          {
              window.history.go(-1);
          }
          
          function xiazai(fujianPath,fujianYuashiMing)
          {
              <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
              </c:if>
            
              <c:if test="${sessionScope.user!=null}">
	               down1(fujianPath,fujianYuashiMing);
              </c:if>
          }
          
          
           function down1(fujianPath,fujianYuashiMing)
           {
               var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
		       url=encodeURI(url); 
               url=encodeURI(url); 
               window.open(url,"_self");
           }
      </script>
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
			                <h3>系统公告详细信息</h3>
			            </div>
			            <div class="cp-main">
			                 <TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" border=0>
								<TR align="left">
									<TD height="5"></TD>
								</TR>
								<TR align="left" height="460">
									<TD align="center" valign="top">
									    <table width="100%" border="0" cellpadding="9" cellspacing="9">
										    <tr>
										       <td align="left">公告标题：<c:out value="${requestScope.gonggao.title}" escapeXml="false"></c:out></td>
										    </tr>
										    <tr>
										       <td align="left">发布时间：${gonggao.shijian}</td>
										    </tr>
										    <tr>
										       <td align="left">公告内容：<c:out value="${requestScope.gonggao.content}" escapeXml="false"></c:out></td>
										    </tr>
										</table>
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
