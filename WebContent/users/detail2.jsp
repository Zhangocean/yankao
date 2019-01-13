<%@page import="com.entity.Xuanke"%>
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
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			<a href="index/all.action">全部课程</a>
			<code> &gt; </code>
			<a href="index/cate.action?id=${course.cateid }">${course.catename }</a>
			<code> &gt; </code>
			${course.coursename }
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
					<%-- <h3>
						<span>热门课程</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						<c:forEach items="${hotList}" var="course">
							<ul class="clearfix">
								<li class="goodsimg"><a
									href="index/coursedetail.action?id=${course.courseid }"
									target="_blank"><img src="${course.image }"
										alt="${course.coursename }" class="B_blue" /> </a></li>
								<li><a
									href="index/coursedetail.action?id=${course.courseid }"
									target="_blank" title="${course.coursename }">${course.coursename }</a>
								</li>
							</ul>
						</c:forEach>
					</div> --%>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
		<div class="AreaR">

			<div id="goodsInfo" class="clearfix">
				<div class="imgInfo">
					<img src="${course.image}" alt="${course.coursename }"
						width="360px;" height="360px" />
					<div class="blank5"></div>
					<div class="blank"></div>
				</div>
				<div class="textInfo">
					<h1 class="clearfix">${course.coursename }</h1>
					<ul class="ul2 clearfix">
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>课程类型：</strong><a
									href="index/cate.action?id=${course.cateid }">${course.catename }</a>
							</dd>
						</li>
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>主讲教师：</strong><a
									href="index/teacherdetail.action?id=${course.teacherid }">${course.teachername }</a>
							</dd>
						</li>
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>上架日期：</strong>${course.addtime}
							</dd>
						</li>
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>点击数：</strong>${course.hits}
							</dd>
						</li>
					</ul>
						
					<%--  <ul>
						<li class="clearfix">
							<dd>
								加入购物车： <a href="index/addfav.action?id=${course.courseid}"><font
									color="red">购买</font></a>
							</dd>
						</li>
					</ul> --%>
				
				</div>
			</div>
			<div class="blank"></div>


			<div class="box">
				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>课程描述</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_h">
						<blockquote>${course.contents}</blockquote>
					</div>
				</div>
			</div>
			 <div class="blank"></div>
		
					<div class="box">
				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>课程表</h2>
					</div>
					<div id="com_b" class="history clearfix">
						<h5>请所有同学根据自己时间安排，也可以在线学习（若无法调配，请留言）</h5>
					</div>
				</div>
				<div class="box_1">
					<table class="table" cellspacing="1" cellpadding="2" width="80%" align="center" border="0">
  <tbody>
    <tr>
      <th class="bg_tr" align="center" colspan="14" height="25">${mclass.name} 排课安排</th>
    </tr>
  <tr>
   <td class="td_bg" align="left"  colspan="14" height="23">
  	2018年度
  	</td>
  </tr>
  
 <%--  <c:forEach items="${xuankeList}" var="xuanke">
		<tr align="center" bgcolor="#FFFFFF">
			<td align="center">${xuanke.coursename}
			</td>
			<td align="center">${xuanke.teachername}</td>
			<td align="center">${xuanke.xuanke_xz}</td>
			<td align="center">${xuanke.xuanke_yz}</td>
		</tr>
	</c:forEach> --%>
  
  
  
  
  
<% 


	
	String args[][]=new String[8][8];
   for(int i=0;i<args.length;i++){
   	for(int j=0;j<args[0].length;j++){
   		args[i][j]="";
   	}
   }
   args[0][0]=" / ";
   args[0][1]="星期一";
   args[0][2]="星期二";
   args[0][3]="星期三";
   args[0][4]="星期四";
   args[0][5]="星期五";
   args[0][6]="星期六";
   args[0][7]="星期日";
   
   args[1][0]="第一节";
   args[2][0]="第二节";
   args[3][0]="第三节";
   args[4][0]="第四节";
   args[5][0]="第五节";
   args[6][0]="第六节";
   args[7][0]="第七节";
   List<Xuanke> list = (List<Xuanke>)request.getAttribute("xuankeList");

   for(Xuanke xk : list){
	 String s=String.valueOf(xk.getCoursename());
	 String s1=String.valueOf(xk.getTeachername());
	 int a=Integer.parseInt(xk.getXuanke_xz());
	 int a1=Integer.parseInt(xk.getXuanke_yz());
	 String r=String.valueOf(xk.getRoom_name());
	 String r1=String.valueOf(xk.getRoom_adress());
 	 args[a][a1]="("+s1+")"+s+
 			 "地址:"+r+"("+r1+")";
	  
   }



%>
  
    <% for(int i=0;i<args.length;i++){%>
    <tr>
       <% for(int j=0 ;j<args[0].length;j++){ %>
    	<% if(i==0){ %>
           <th class="bg_tr" align="center" height="25"><%=args[i][j] %></th>
        <% }else{ %>
            <td class="td_bg" align="center" height="23"><%=args[i][j] %></td>
        <%} %>
        <%} %>
        </tr>
   <%}%>
  </tbody>
</table>
				</div>
			</div>
			 <div class="blank"></div>
		
		
		
		
		
	<%-- <c:if test="${sessionScope.userid != null }">	 --%> 
			<div class="box">
			
				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>课程资料</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_h">
						<blockquote>
							<table cellspacing="0" cellpadding="0" width="100%"
								id="ajaxtable">
								<tbody style="table-layout: fixed;">
									<c:forEach items="${filesList}" var="files"
										varStatus="status">
										<c:if test="${status.count eq 1 || (status.count-1) % 4 eq 0}">
											<tr align="center" class="tr3 t_one">
										</c:if>
										<td class="tal f10 y-style"><a
											href="${files.url }"
											target="blank">${files.filesname }</a></td>
										<c:if test="${status.count % 4 eq 0 || status.count eq 4}">
											</tr>
										</c:if>
									</c:forEach>
									<tr>
										<td style="height: 8px"></td>
									</tr>
								</tbody>
							</table>
						</blockquote>
					</div>
				</div>
				
			</div>
			<div class="blank"></div>
			<div class="box">
				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>课程视频</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_v" class="  " style="padding: 6px;"></div>
					<div id="com_h">
						<blockquote>
							<table cellspacing="0" cellpadding="0" width="100%"
								id="ajaxtable">
								<tbody style="table-layout: fixed;">
									<c:forEach items="${vedioList}" var="vedio"
										varStatus="status">
										<c:if test="${status.count eq 1 || (status.count-1) % 4 eq 0}">
											<tr align="center" class="tr3 t_one">
										</c:if>
										<td class="tal f10 y-style"><a
											href="index/play.action?id=${vedio.vedioid }"
											target="_blank">${vedio.title }</a></td>
										<c:if test="${status.count % 4 eq 0 || status.count eq 4}">
											</tr>
										</c:if>
									</c:forEach>
									<tr>
										<td style="height: 8px"></td>
									</tr>
								</tbody>
							</table>
						</blockquote>
					</div>
				</div>
			</div>
			<%-- </c:if> --%>
			
			
			<div class="blank"></div>
			<div id="ECS_COMMENT">
				<div class="box">
					<div class="box_1">
						<h3>
							<span class="text">用户评论</span>
						</h3>
						<div class="boxCenterList clearfix" style="height: 1%;">
							<ul class="comments">
								<c:forEach items="${topicList }" var="topic">
									<li class="word"><font class="f2">${topic.username }</font>
										<font class="f3">(${topic.addtime }) </font> <br /> <img
										src="themes/xecmoban_shunfeng/images/stars${topic.num }.gif" />
										<p>${topic.contents }</p></li>
								</c:forEach>
							</ul>
							<div class="blank5"></div>
							<div class="commentsList">
								<c:if test="${sessionScope.userid != null }">
									<c:if test="${sessionScope.writerid == null }">
										<form action="index/addTopic.action" method="post"
											name="commentForm" id="commentForm">
											<table width="710" border="0" cellspacing="5" cellpadding="0">
												<tr>
													<td align="right">评价等级：</td>
													<td><input name="num" type="radio" value="1"
														id="comment_rank1" /> <img
														src="themes/xecmoban_shunfeng/images/stars1.gif" /> <input
														name="num" type="radio" value="2" id="comment_rank2" /> <img
														src="themes/xecmoban_shunfeng/images/stars2.gif" /> <input
														name="num" type="radio" value="3" id="comment_rank3" /> <img
														src="themes/xecmoban_shunfeng/images/stars3.gif" /> <input
														name="num" type="radio" value="4" id="comment_rank4" /> <img
														src="themes/xecmoban_shunfeng/images/stars4.gif" /> <input
														name="num" type="radio" value="5" checked="checked"
														id="comment_rank5" /> <img
														src="themes/xecmoban_shunfeng/images/stars5.gif" /></td>
												</tr>
												<tr>
													<td align="right" valign="top">评论内容：</td>
													<td><textarea name="contents" class="inputBorder"
															style="height: 50px; width: 620px;"></textarea> <input
														type="hidden" name="courseid" value="${course.courseid }" /></td>
												</tr>
												<tr>
													<td colspan="2"><input type="submit" value="评论"
														class="f_r bnt_blue_1" style="margin-right: 8px;" /></td>
												</tr>
											</table>
										</form>
									</c:if>
								</c:if>
							</div>

						</div>
					</div>
				</div>
				<div class="blank5"></div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
