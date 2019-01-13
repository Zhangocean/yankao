<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>文件上传</title>
		<base href="<%=basePath%>" />
		<style type="text/css">
<!--
a:link {
	color: #4B7013
}

a:visited {
	color: #4B7013
}

body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE6 {
	color: #000000;
	font-size: 12;
}

.STYLE10 {
	color: #000000;
	font-size: 12px;
}

.STYLE19 {
	color: #344b50;
	font-size: 12px;
}

.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}

.STYLE22 {
	font-size: 12px;
	color: #295568;
}

.right_body {
	padding-left: 5px;
	padding-right: 5px;
}

.right_font {
	font-size: 13px;
	cursor: hand;
}
-->
</style>
		<script type="text/javascript">
			function selok(){
				opener.document.getElementById("url").value=myform.p.value;
				window.close();
			}
		</script>
	</head>

	<body class="right_body">
		<form action="upload/files.action" name="myform" method="post"
			enctype="multipart/form-data">
			<div align="center">
				<table width="100%" border="0" cellpadding="0" cellspacing="2"
					bgcolor="#E8F5FD" style="border: 1px solid #0C89A9">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="#a8c7ce">
								<tr>
									<td height="20" bgcolor="#FFFFFF">
										<div align="center">
											<span class="STYLE1">请选择文件</span>
										</div>
									</td>
									<td height="20" bgcolor="#FFFFFF">
										<div align="center">
											<span class="STYLE1"><input type="file" name="image"
													width="220px" /> </span>
										</div>
									</td>
								</tr>

								<tr>
									<td width="0" height="20" bgcolor="#FFFFFF" align="center"
										colspan="2">
										${imageFileName }
										<input type="hidden" name="p"
											value="upfiles/${imageFileName }" id="p">
										<input type="button" value=" 确定 " onclick="selok();" />
									</td>
								</tr>

								<tr>
									<td width="0" height="20" bgcolor="#FFFFFF" align="center"
										colspan="2">
										<input type="submit" value=" 上传 " />
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>
