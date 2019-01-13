<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<base href="<%=basePath%>" />

<link rel="stylesheet" type="text/css" href="caidan/lib/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="caidan/lib/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="caidan/css/style.css">
    <link rel="stylesheet" type="text/css" href="caidan/css/themes/flat-blue.css">


</head>
<body class="flat-blue">
    
     <div class="app-container">
         <div class="row content-container"> 

<!-- 一级标题-->
            <div class="side-menu sidebar-inverse">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="side-menu-container">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">
                                <div class="icon fa fa-paper-plane"></div>
                                <div class="title">管理菜单</div>
                            </a>
                            <button type="button" class="navbar-expand-toggle pull-right visible-xs">
                                <i class="fa fa-times icon"></i>
                            </button>
                        </div>

						<!-- 二级标题-->
                        <ul class="nav navbar-nav">
                            <li class="panel panel-default dropdown">
                                <a href="#aaa" data-toggle="collapse">
                                    <span class="icon fa fa-tachometer"></span><span class="title">管理员</span>
                                </a>
                       
                                <div id="aaa" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="admin/createAdmin.action" target="main">增加管理员</a>
                                            </li>
                                            <li><a href="admin/getAllAdmin.action" target="main">管理员列表</a>
                                            </li>
                                            <li><a href="admin/queryAdminByCond.action" target="main" >管理员查询</a>
                                            </li>
                   
                                        </ul>
                                    </div>
                                </div>


                            </li>

							<!-- 二级标题-->
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#student">
                                    <span class="icon fa fa-desktop"></span><span class="title">学生用户</span>
                                </a>
                                <!-- 三级标题-->
                                <div id="student" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="users/getAllUsers.action" target="main" >用户列表</a>
                                            </li>
                                            <li><a href="users/queryUsersByCond.action" target="main">查询用户</a>
                                            </li>
                                           
                                         
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>

                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#news">
                                    <span class="icon fa fa-table"></span><span class="title">最新公告</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="news" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="article/createArticle.action" target="main">新增公告</a>
                                            </li>
                                            <li><a href="article/getAllArticle.action" target="main">公告列表</a>
                                            </li>
                                            <li><a href="article/queryArticleByCond.action" target="main">公告查询</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>

                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#type">
                                    <span class="icon fa fa-file-text-o"></span><span class="title">课程类型</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="type" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="cate/createCate.action" target="main">新增类型</a>
                                            </li>
                                            <li><a href="cate/getAllCate.action" target="main">类型列表</a>
                                            </li>
                                            <li><a href="cate/queryCateByCond.action" target="main">查询类型</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            
                            
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#type1">
                                    <span class="icon fa fa-file-text"></span><span class="title">课表管理</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="type1" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="xuanke/kebiao.action" target="main">课表修改</a>
                                            </li>
                                            <li><a href="room/getAllRoom.action" target="main">教室管理</a>
                                            </li>
                                            <li><a href="room/createRoom.action" target="main">增加教室</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            
                            
                            
                            <!-- Dropdown-->
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#teacher">
                                    <span class="icon fa fa-cubes"></span><span class="title">教师</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="teacher" class="panel-collapse collapse">
                                    <div class="panel-body">
                                      <ul class="nav navbar-nav">
                                            <li><a href="teacher/createTeacher.action" target="main">新增教师</a>
                                            </li>
                                            <li><a href="teacher/getAllTeacher.action" target="main">教师列表</a>
                                            </li>
                                            <li><a href="teacher/queryTeacherByCond.action" target="main">查询列表</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <!-- Dropdown-->
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#class">
                                    <span class="icon fa fa-slack"></span><span class="title">课程</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="class" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="course/createCourse.action" target="main">新增课程</a>
                                            </li>
                                            <li><a href="course/getAllCourse.action" target="main">课程列表</a>
                                            </li>
                                            <li><a href="course/queryCourseByCond.action" target="main">查询课程</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <!-- Dropdown-->
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#ziliao">
                                    <span class="icon fa fa-archive"></span><span class="title">课程资料</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="ziliao" class="panel-collapse collapse">
                                    <div class="panel-body">
                                         <ul class="nav navbar-nav">
                                            <li><a href="files/createFiles.action" target="main">新增课程资料</a>
                                            </li>
                                            <li><a href="files/getAllFiles.action" target="main">课程资料料列表</a>
                                            </li>
                                            <li><a href="files/queryFilesByCond.action" target="main">查询课程</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                                                       <!-- Dropdown-->
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#move">
                                    <span class="icon fa fa-thumbs-o-up"></span><span class="title">课程视频</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="move" class="panel-collapse collapse">
                                    <div class="panel-body">
                                         <ul class="nav navbar-nav">
                                            <li><a href="vedio/createVedio.action" target="main">新增视频</a>
                                            </li>
                                            <li><a href="vedio/getAllVedio.action" target="main">视频列表</a>
                                            </li>
                                            <li><a href="vedio/queryVedioByCond.action" target="main">查询视频</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                                                        <!-- Dropdown-->
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#pingjia">
                                    <span class="icon fa fa-retweet"></span><span class="title">课程评价</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="pingjia" class="panel-collapse collapse">
                                    <div class="panel-body">
                                         <ul class="nav navbar-nav">
                                            <li><a href="topic/getAllTopic.action" target="main">课程评价列表</a>
                                            </li>
                                            <li><a href="topic/queryTopicByCond.action" target="main">查询评价</a>
                                            
                                        </ul>
                                    </div>
                                </div>
                            </li>
                                                        <!-- Dropdown-->
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#liuyan">
                                    <span class="icon fa fa-calendar"></span><span class="title">留言交流</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="liuyan" class="panel-collapse collapse">
                                    <div class="panel-body">
                                         <ul class="nav navbar-nav">
                                            <li><a href="bbs/getAllBbs.action" target="main">留言列表</a>
                                            </li>
                                            <li><a href="bbs/queryBbsByCond.action" target="main">留言查询</a>
                                            </li>
                                            
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </nav>
            </div>
           
        </div>
            <!-- Javascript Libs -->
            <script type="text/javascript" src="caidan/lib/js/jquery.min.js"></script>
            <script type="text/javascript" src="caidan/lib/js/bootstrap.min.js"></script>
           <!--  <script type="text/javascript" src="lib/js/Chart.min.js"></script> -->
            <script type="text/javascript" src="caidan/lib/js/bootstrap-switch.min.js"></script> 
            <script type="text/javascript" src="caidan/lib/js/jquery.matchHeight-min.js"></script>
             <script type="text/javascript" src="caidan/lib/js/jquery.dataTables.min.js"></script>
            <script type="text/javascript" src="caidan/lib/js/select2.full.min.js"></script>
            <!-- Javascript -->
            <script type="text/javascript" src="caidan/js/app.js"></script>
            <script type="text/javascript" src="caidan/js/index.js"></script>
</body>

</html>