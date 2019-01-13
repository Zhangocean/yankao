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
						<td colspan="20" class="optiontitle">学生用户信息列表</td>
					</tr>
					<tr align="center">
						<td align="center" bgcolor="#ebf0f7">用户名</td>
						<td align="center" bgcolor="#ebf0f7">姓名</td>
						<td align="center" bgcolor="#ebf0f7">性别</td>
						<td align="center" bgcolor="#ebf0f7">出生日期</td>
						<td align="center" bgcolor="#ebf0f7">联系方式</td>
						<td align="center" bgcolor="#ebf0f7">注册日期</td>
					</tr>
					<c:forEach items="${usersList}" var="users">
						<tr align="center" bgcolor="#FFFFFF">
							<td align="center">${users.username}</td>
							<td align="center">${users.realname}</td>
							<td align="center">${users.sex}</td>
							<td align="center">${users.birthday}</td>
							<td align="center">${users.contact}</td>
							<td align="center">${users.regdate}</td>
						</tr>
					</c:forEach>
					<tr align="right" bgcolor="#ebf0f7">
						<td colspan="20"><form action="users/queryUsersByCond.action"
								name="myform" method="post">
								查询条件<select name="cond" style="width: 100px"><option
										value="username">按用户名查询</option>
									<option value="realname">按姓名查询</option>
									<option value="sex">按性别查询</option>
									<option value="birthday">按出生日期查询</option>
									<option value="contact">按联系方式查询</option>
									<option value="regdate">按注册日期查询</option></select>关键字<input type="text"
									name="name" style="width: 100px" /><input type="submit"
									value="查询" />
							</form></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>