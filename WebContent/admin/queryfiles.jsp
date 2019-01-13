<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ taglib
	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/four.css" rel="stylesheet" type="text/css" />
</head>
<%
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
%><body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td bgcolor="#FFFFFF"><table width="96%" border="0"
					align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
					<tr align="left" bgcolor="#F2FDFF">
						<td colspan="20" class="optiontitle">课程资料信息列表</td>
					</tr>
					<tr align="center">
						<td align="center" bgcolor="#ebf0f7">资料名称</td>
						<td align="center" bgcolor="#ebf0f7">课程</td>
						<td align="center" bgcolor="#ebf0f7">上传日期</td>
					</tr>
					<c:forEach items="${filesList}" var="files">
						<tr align="center" bgcolor="#FFFFFF">
							<td align="center">${files.filesname}</td>
							<td align="center">${files.coursename}</td>
							<td align="center">${files.addtime}</td>
						</tr>
					</c:forEach>
					<tr align="right" bgcolor="#ebf0f7">
						<td colspan="20"><form action="files/queryFilesByCond.action"
								name="myform" method="post">
								查询条件<select name="cond" style="width: 100px"><option
										value="filesname">按资料名称查询</option>
									<option value="courseid">按课程查询</option>
									<option value="addtime">按上传日期查询</option></select>关键字<input type="text"
									name="name" style="width: 100px" /><input type="submit"
									value="查询" />
							</form></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>