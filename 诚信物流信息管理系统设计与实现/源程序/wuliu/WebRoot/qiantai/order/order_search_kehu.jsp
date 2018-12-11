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
			                <h3>订单信息</h3>
			            </div>
			            <div class="cp-main" style="height: 444px;">
			                 <c:if test="${requestScope.order==null}">
			                        您输入的订单号不存在，请重新输入
			                 </c:if>
			                 <c:if test="${requestScope.order!=null}">
			                        <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         订单号：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="danhao" size="50" value="${requestScope.order.danhao }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         货物类型：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="huoleixing" size="50" value="${requestScope.order.huoleixing }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         货物名称：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="huomingcheng" size="50" value="${requestScope.order.huomingcheng }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         货物重量：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="huozhong" size="50" value="${requestScope.order.huozhong }"/>(KG)
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         货物体积：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="huotiji" size="50" value="${requestScope.order.huotiji }"/>(m3)
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         是否保值：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        ${requestScope.order.baozhi }
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         是否快件：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        ${requestScope.order.kuaijian }
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										        备注信息
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <textarea rows="5" cols="20" name="beizhu">${requestScope.order.beizhu }</textarea>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         寄件人姓名：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="jixingming" size="50" value="${requestScope.order.jixingming }"/> 
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         寄件人电话：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="jidianhua" size="50" value="${requestScope.order.jidianhua }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         寄件人地址：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="jidizhi" size="50" value="${requestScope.order.jidizhi }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         收件人姓名：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="shouxingming" size="50" value="${requestScope.order.shouxingming }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         收件人电话：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="shoudianhua" size="50" value="${requestScope.order.shoudianhua }"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
										    <td width="25%" bgcolor="#FFFFFF" align="right">
										         收件人地址：
										    </td>
										    <td width="75%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="shoudizhi" size="50" value="${requestScope.order.shoudizhi }"/>
										    </td>
										</tr>
								    </table>
			                 </c:if>
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
