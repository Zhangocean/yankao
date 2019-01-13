<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<style type="text/css">
body {margin: 0px;}
td   {font-size:12px;color:#000;font-family: Helvetica, sans-serif, "宋体";}
</style>
	</head>
	<body>
		<table width="100%" height="30" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" background="images/bottom_bg.gif">Copyright
				&copy; 研考教育信息管理系统All Rights Reserved.</td>
			</tr>
		</table>
	</body>
</html>
