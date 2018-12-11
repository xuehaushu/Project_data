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
      
      <script language="javascript">
		    function check1()
		    {
		        if(document.form1.danhao.value=="")
		        {
		            alert("请输入订单号");
		            return false;
		        }
		        document.form1.submit();
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
			                <h3>订单信息查询</h3>
			            </div>
			            <div class="cp-main" style="height: 444px;">
			                 <form action="<%=path %>/order?type=order_search_kehu" name="form1" method="post">
								<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
									<tr>
										<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
											请输入订单号：
										</td>
										<td width="80%" bgcolor="#FFFFFF">
											&nbsp;
											<input type="text" name="danhao" size="60"/>
										</td>
									</tr>
									<tr>
										<td height="30" align="right" bgcolor="#F9F9F9">
											&nbsp;
										</td>
										<td bgcolor="#FFFFFF">
											&nbsp;
											<input type="button" value="确定" onclick="check1();"/>
										</td>
									</tr>
								</table>
							</form>
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
