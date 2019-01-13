<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link href="css/main.css" rel="stylesheet" type="text/css" />
		<title>研考教育管理信息系统</title>
	</head>
	<frameset rows="108,*,30" cols="*" frameborder="no" border="0" framespacing="0">
		<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
		<frameset rows="*" cols="200,*" framespacing="0" frameborder="no" border="0">
			<frame src="menu.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
			<frame src="" name="main" scrolling="yes" noresize="noresize" id="mainFrame" title="mainFrame" />
		</frameset>
		<frame src="bottom.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame"
			title="bottomFrame" />
	</frameset>
	<noframes>
		<body>
		</body>
	</noframes>
</html>
