<%@page import="com.alibaba.fastjson.JSONObject"%>
<%@page import="com.entity.Course"%>
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
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript"
	src="<%=basePath%>laydate/laydate.js" charset="utf-8"></script>
</head>

<%-- <body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			用户中心
		</div>
	</div>
	<div class="blank"></div>

	<div class="blank"></div>
	<div class="block clearfix">

		<div class="AreaL">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox">
						<jsp:include page="usermenu.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
			<div class="box">
				<div class="box_1">
					<h3>
						<span>课程热度折线图</span>
					</h3>
					<div class="clearfix goodsBox" style="border: none;">
					
					
					
						<c:forEach items="${courseList}" var="course">
							<div class="goodsItem" style="padding: 10px 3px 15px 2px;">
				
								<p class="f1">
									${course.coursename }
								</p>
								<p class="f1">
									${course.hits }
								</p>
							</div>
						</c:forEach>
					
					
					
					</div>
				</div>
			</div>
			
			
			
			
			
</body> --%>
<body>

<jsp:include page="header.jsp"></jsp:include>
	


<%
List<Course> list = (List<Course>)request.getAttribute("courseList");
/* out.write(JSONObject.toJSONString(list)); */
 String s1="[";
 String s = "[";
for(int i = 0; i<list.size();i++){
	s += "'"+list.get(i).getCoursename()+"'";
	s1 +=list.get(i).getHits();
	if(i<list.size()-1){
		s += ",";
		s1 +=",";
	}
}
s += "]"; 
s1 +="]";
/* out.write(s);
out.write(s1); */
%>

 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="haha" style="height:400px"></div>
    <script src="dist/echarts.js"></script>
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'dist'
            }
        });
		  // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('haha')); 
                
        option = {
    title : {
        text: '课程热度折线图',
        subtext: '仅供参考'
    },
    tooltip : {
        trigger: 'axis'
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : <%=s%>
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'浏览量',
            type:'bar',
            data: <%=s1%>,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        },
        
    ]
};
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
    </script>
</body>

</html>