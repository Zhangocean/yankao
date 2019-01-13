<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<div class="footer">
	<div class="foot_con">
		<div class="blank"></div>

		<div class="blank"></div>
		<div id="bottomNav" class="rolling"></div>

		<div class="text" style="height: 1px; width: 1px; overflow: hidden;">
			<br />
		</div>

		<div class="record">
			&copy; 2018 研考教育管理信息系统    版权所有，并保留所有权利。
			<p style="color: #999;">
				内蒙古呼和浩特 Tel: 134 7471 8588
			</p>
			<a href="admin/index.jsp" target="_blank">管理员入口</a>
		</div>
	</div>
	<div class="blank"></div>
</div>