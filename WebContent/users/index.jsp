<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>研考教育管理信息系统</title>
</head>

<body style="min-width: 1200px;">
	<jsp:include page="header.jsp"></jsp:include>
	<div class="blank" style="height: 30px;"></div>
	<div class="block clearfix Main">
		<div class="AreaL">
			<div id="mallNews" class="  box_1">
				<h3>
					<span class="label label-info">新闻公告</span>
				</h3>
				<div class="NewsList tc  " style="border-top: none">
					<c:forEach items="${articleList}" var="article">
						<li><a href="index/read.action?id=${article.articleid }">${article.title }</a>
						</li>
					</c:forEach>
				</div>
				
				<h3>
					<span class="label label-info">大数据分析</span>
				</h3>
				<div class="NewsList tc  " style="border-top: none">
					<li><a href="index/ceshi1.action"
									target="_self" >性别分析</a>
								</li>
								</br><li><a href="index/ceshi.action"
									target="_self" >课程热度</a>
								</li>
								</br><li><a href="index/ceshi2.action"
									target="_self" >报考地区参考</a>
								</li>
				</div>
				
			</div>
		</div>
		
		
		
		
		
		<div class="Arear"></div>
		<div class="goodsBox_1">

			<div class="xm-box">
				<h4 class="title">
					<span>&nbsp;&nbsp;&nbsp;教师信息</span> <a class="more"
						href="index/teacher.action">更多</a>
				</h4>
				<div id="show_new_area" class="clearfix">
					<c:forEach items="${newsList}" var="teacher">
						<div class="goodsItem">
							<a href="index/teacherdetail.action?id=${teacher.teacherid }"><img
								src="${teacher.image }" alt="${teacher.teachername }" class="goodsimg" />
							</a> <br />
							<p class="f1">
								<a href="index/detail.action?id=${teacher.teacherid }"
									title="${teacher.teachername }">${teacher.teachername }</a>
							</p>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="blank"></div>
			<c:forEach items="${frontList}" var="cate">
				<!-- 循环开始 -->
				<div class="xm-box">
					<h4 class="title">
						<span>${cate.catename }</span> <a class="more"
							href="index/cate.action?id=${cate.cateid }">更多</a>
					</h4>
					<div id="show_hot_area" class="clearfix">
						<!-- 循环开始 -->
						<c:forEach items="${cate.courseList}" var="course">
							<div class="goodsItem">
								<a href="index/coursedetail1.action?id=${course.courseid }"><img
									src="${course.image }" alt="${course.coursename }"
									class="goodsimg" /> </a> <br />
								<p class="f1">
									<a href="index/coursedetail1.action?id=${course.courseid }"
										title="${course.coursename }">${course.coursename }</a>
								</p>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="blank"></div>
				<!-- 循环结束 -->
			</c:forEach>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>


</body>


</html>
