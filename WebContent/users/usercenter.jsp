<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript"
	src="<%=basePath%>laydate/laydate.js" charset="utf-8"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			用户中心
		</div>
	</div>
	<div class="blank"></div>

	<div class="blank"></div>
	<div class="block clearfix">

		<div class="AreaL">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox">
						<jsp:include page="usermenu.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>


		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox boxCenterList clearfix"
						style="_height: 1%;">
						<h5>
							<span>个人中心</span>
						</h5>
                       
                       
                <div id="goodsInfo" class="clearfix">
				<div class="imgInfo">
					<a href="index/userinfo.action?id=${users.usersid }"><img
									src="${users.image}" alt="${users.realname }"
									height="250px"/> </a>
					<div class="blank5"></div>
					<div class="blank"></div>
				</div>
				
						<h1 <a href="index/userinfo.action?id=${users.usersid }"
										title="${users.realname }">${users.realname }</a></h1>
				
						<strong>所在院校：</strong><a href="index/userinfo.action?id=${users.usersid }"
						title="${users.s_school }">${users.s_school }</a><br />
                        <strong>报考院校：</strong><a href="index/userinfo.action?id=${users.usersid }"
						title="${users.b_school }">${users.b_school }</a>
                       
                       
                       
                       
			 
				    </div>
				</div>
			</div>
		</div>

	</div>
	<div class="blank"></div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
