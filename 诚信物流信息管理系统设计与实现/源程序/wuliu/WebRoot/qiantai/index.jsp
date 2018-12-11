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
			                <h3>公司简介</h3>
			            </div>
			            <div class="cp-main">
			诚信物流公司（物流）有限公司成立于2000年5月28日，是国内大型民营快递品牌企业，致力于
成为“引领行业发展的公司”，以“创民族品牌”为己任，以实现“圆通速递——中国人的快递”为奋斗目标。始终秉承“客户要求，圆通使命”的服务宗旨和“诚信服务，开拓创新”的经营理念。公司拥有10个管理区、58个转运中心、
5100余个配送网点、5万余名员工，服务范围覆盖国内1200余个城市。公司开通了港澳台、中东和东南亚专线服务。并在香港注册了Cats Alliance Express（CAE)公司，开展国际快递业务。 公司立足国内，面向国际，
致力于开拓和发展国际、国内快递、物流市场。公司主营包裹快递业务，形成了包括同城当天件、区域当天件、跨省时效件和航空次晨达、航空次日下午达和到付、代收货款、签单返还等多种增值服务产品。
公司的服务涵盖仓储、配送及特种运输等一系列的专业速递服务，并为客户量身制定速递方案，提供个性化、一站式的服务。圆通还将使用自主研发的“圆通物流全程信息监控管理系统”，确保每一票快件的时效和安全。
			                  			                 
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
