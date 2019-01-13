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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<base href="<%=basePath%>" />
		<title>研考教育管理信息系统</title>
     <link href="css/style1.css" rel="stylesheet">
     
     </STYLE>
		<script type="text/javascript">
	function checkLogin(){
		var username  = document.myform.username.value;
		var password = document.myform.password.value;
		if(username==''){
			alert('请输入用户名');
			document.myform.username.focus();
			return false;
		}
		if(password==''){
			alert('请输入密码');
			document.myform.password.focus();
			return false;
		}
	}
</script>
</head>

<body class="login-body">

<div class="container">

    <form class="form-signin" action="<%=basePath%>admin/login.action" name="myform" method="post" onSubmit="return checkLogin()">
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">研考教育管理信息系统</h1>
            <img src="images/login-logo.png" alt=""/>
        </div>
        <div class="login-wrap">
            <input type="text" id="username" name="username" class="form-control" placeholder="用户名" autofocus>
            <input id="password" type="password" name="password" class="form-control" placeholder="密码">

            <button name="Submit" class="btn btn-lg btn-login btn-block" type="submit">
                <i class="fa fa-check"></i>
            </button>
        </div>

    </form>

</div>

</body>
</html>