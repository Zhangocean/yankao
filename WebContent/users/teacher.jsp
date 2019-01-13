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
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="index.jsp">首页</a>
			<code> &gt; </code>
			教师
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<div id="category_tree">
				<div class="tit">所有课程分类</div>
				<dl class="clearfix" style="overflow: hidden;">
					<c:forEach items="${cateList}" var="cate">
						<div class="box1 cate" id="cate">
							<h1 style="border-top: none">
								<a href="index/cate.action?id=${cate.cateid }" class="  f_l">${cate.catename }</a>
							</h1>
						</div>
						<div style="clear: both"></div>
					</c:forEach>
				</dl>
			</div>
				
			<div class="blank"></div>
			<div class="box" id='history_div'>
				<div class="box_1">
					<h3>
						<span>大数据分析</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						
							<ul class="clearfix">
								
								<li><a href="index/ceshi1.action"
									target="_self" >性别分析</a>
								</li></br>
								</br><li><a href="index/ceshi.action"
									target="_self" >课程热度</a>
								</li></br>
								</br><li><a href="index/ceshi2.action"
									target="_self" >报考地区参考</a>
								</li>
							</ul>

					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>教师列表</span>
					</h3>
					<div class="clearfix goodsBox" style="border: none;">
						<c:forEach items="${teacherList}" var="teacher">
							<div class="goodsItem" style="padding: 10px 3px 15px 2px;">
								<a href="index/teacherdetail.action?id=${teacher.teacherid }"><img
									src="${teacher.image }" alt="${teacher.teachername }"
									class="goodsimg" /> </a> <br />
								<p class="f1">
									<a href="index/teacherdetail.action?id=${teacher.teacherid }"
										title="${teacher.teachername }">${teacher.teachername }</a>
								</p>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
