<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}
	if (!message.trim().equals("")) {
		out.println("<script language='javascript'>");
		out.println("alert('" + message + "');");
		out.println("</script>");
	}
	request.removeAttribute("message");
%>
<link href="themes/xecmoban_shunfeng/style.css" rel="stylesheet"
	type="text/css" />
	
<!-- <link href="css/bootstrap1.min.css" rel="stylesheet"
	type="text/css" /> -->
<div id="Top">
	<div class=" block header_bg">

		<div class="top_nav">
			<div class="block">
				<div class="header_r">
					<c:if test="${sessionScope.userid == null }">
						<font id="ECS_MEMBERZONE"> 欢迎光临本站 <a
							href="index/preLogin.action">[用户登录]</a>&nbsp;<a
							href="index/preReg.action">[用户注册]</a>
						</font>
					</c:if>

					<c:if test="${sessionScope.userid != null }">
						<font id="ECS_MEMBERZONE"> 欢迎光临本站${sessionScope.username }，
							<a
							href="index/usercenter.action">[用户中心]</a>&nbsp; <a
							href="index/exit.action">[退出系统]</a>
						</font>
					</c:if>
				</div>
			</div>
		</div>

		<div class="clearfix"></div>
		<div class="header_top logo_wrap clearfix">
			<a class="logo_new" href="index.jsp"><img
				src="themes/xecmoban_shunfeng/images/logo.gif" /> </a>
			 <div class="ser_n">
				<form id="searchForm" class="searchBox" name="searchForm"
					method="post" action="index/query.action">
					<input name="name" type="text" id="keyword" value=""
						class="searchKey" /> <input type="submit"
						class="fm_hd_btm_shbx_bttn" value=" ">
				</form>
				<div class="search_hot"></div>
				<div class="clearfix"></div>
			</div> 
		</div>
	</div>
</div>
<div style="clear: both"></div>

<div class="menu_box clearfix">
	<div class="block">
		<div class="menu">
			<a href="index.jsp" class="cur">首页</a> <a href="index/article.action"
				class="cur">新闻公告</a>
			<%-- <c:forEach items="${cateList}" var="cate">
				<a href="index/cate.action?id=${cate.cateid }" class="cur">${cate.catename }</a>
			</c:forEach> --%>
			<a href="index/all.action" class="cur">全部课程</a>
			<a href="index/teacher.action" class="cur">全部教师</a> 
			<a href="index/bbs.action" class="cur">留言板</a>
		</div>
	</div>
</div>