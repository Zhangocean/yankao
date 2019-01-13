<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.apache.catalina.User"%>
<%@page import="com.entity.Fav"%>
<%@page import="com.entity.Users"%>
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
List<Users> list = (List<Users>)request.getAttribute("usersList");
 
List<String> list1=new ArrayList<String>();
/*   ForEach(Users u:list){
	list1.add(String.valueOf(u.getB_adress()));
}  */ 
  for(int i=0;i<list.size();i++){
	list1.add(String.valueOf(list.get(i).getB_adress()));
}  
Map<String,Integer>map=new HashMap<String,Integer>();
/*  ForEach(String u1:list1){
	if(map.containsKey(u1)){
		map.put(u1, map.get(u1).intValue() + 1);
	}else{
		map.put(u1, new Integer(1));
	}
	
}  */
for(int j=0;j<list1.size();j++){
	if(map.containsKey(list1.get(j))){
		map.put(list1.get(j), map.get(list1.get(j)).intValue()+1);
	}else{
		map.put(list1.get(j),new Integer(1));
	}
}
String s="[{name:'内蒙古'},";
String ss="{name:";
String zhi="";
String quan="";
String di=null;
String va=null;
Iterator it=map.keySet().iterator();
while(it.hasNext()){
	String key=String.valueOf(it.next());
	String value=String.valueOf(map.get(key).intValue());
	di=s+ss+"'"+key+"',";   //地址有了
	va="value:"+value+"}],";
    zhi +=di+va;
	quan+=ss+"'"+key+"',"+"value:"+value+"},";
	
	/* out.write(key+":");
	out.write(value+",");
	[{name:'内蒙古'}, {name:'上海',value:95}],
    [{name:'内蒙古'}, {name:'广东',value:90}]
    		{name:'上海',value:95},
            {name:'广东',value:90},
	*/
	
}
/* out.write(zhi); 
out.write(quan); */
/* out.write(JSONObject.toJSONString(list)); */
/* 



String s1="{name:"
int num=0;
for(int i = 0; i<list.size();i++){
	
	String sss=list.get(i).getB_adress();
	if((list.get(i+1).getB_adress()).equals(sss)){
		num +=1;
	}
	s1 += "'"+sss+"'"+","
	   
			
			
	/* if(i<list.size()-1){
		s += ",";
		s1 +=",";
	} 
}
s += "]"; */

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
                'echarts/chart/map' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('haha')); 
                
                option = {
                	    backgroundColor: '#1b1b1b',
                	    color: ['gold','aqua','lime'],
                	    title : {
                	        text: '报考地区分布图',
                	        subtext:'数据仅供参考',
                	        x:'center',
                	        textStyle : {
                	            color: '#fff'
                	        }
                	    },
                	    tooltip : {
                	        trigger: 'item',
                	        formatter: '{b}'
                	    },
                	    /* legend: {
                	        orient: 'vertical',
                	        x:'left',
                	        data:['北京 Top10'],
                	        selectedMode: 'single',
                	        textStyle : {
                	            color: '#fff'
                	        }
                	    }, */
                	    toolbox: {
                	        show : true,
                	        orient : 'vertical',
                	        x: 'right',
                	        y: 'center',
                	        feature : {
                	            mark : {show: true},
                	            dataView : {show: true, readOnly: false},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    dataRange: {
                	        min : 0,
                	        max : 100,
                	        calculable : true,
                	        color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
                	        textStyle:{
                	            color:'#fff'
                	        }
                	    },
                	    series : [
                	        {
                	            name: '全国',
                	            type: 'map',
                	            roam: true,
                	            hoverable: false,
                	            mapType: 'china',
                	            itemStyle:{
                	                normal:{
                	                    borderColor:'rgba(100,149,237,1)',
                	                    borderWidth:0.5,
                	                    areaStyle:{
                	                        color: '#1b1b1b'
                	                    }
                	                }
                	            },
                	            data:[],
                	            markLine : {
                	                smooth:true,
                	                symbol: ['none', 'circle'],  
                	                symbolSize : 1,
                	                itemStyle : {
                	                    normal: {
                	                        color:'#fff',
                	                        borderWidth:1,
                	                        borderColor:'rgba(30,144,255,0.5)'
                	                    }
                	                },
                	                data : [
                	                    
                	                  
                	                ],
                	            },
                	            geoCoord: {
                	                '上海': [121.4648,31.2891],
                	                '广东': [113.8953,22.901],
                	            	 '新疆': [87.9236,43.5883],             
                	                '甘肃': [103.5901,36.3043],              
                	                '南京': [118.8062,31.9208],        
                	                '安徽': [117.29,32.0581],
                	                '内蒙古': [111.4124,40.4901],
                	                '黑龙江': [127.9688,45.368],         
                	                '天津': [117.4219,39.4189],
                	                '山西': [112.3352,37.9413],
                	                '四川': [103.9526,30.7617],               
                	                '西藏': [91.1865,30.1465],              
                	                '云南': [102.9199,25.4663],
                	                '浙江': [119.5313,29.8773],              
                	                '湖北': [114.3896,30.6628],
                	                '江西': [112.6318,22.1484],
                	                '辽宁': [123.1238,42.1216],                  
                	                '海南': [110.3893,19.8516],
                	                '湖南': [112.5439,27.7075],            
                	                '河北': [114.4995,38.1006],
                	                '福建': [119.4543,25.9222],          
                	                '青海': [101.4038,36.8207],
                	                '陕西': [109.1162,34.2004],
                	                '贵州': [106.6992,26.7682],
                	                '河南': [113.4668,34.6234],
                	                '重庆': [107.7539,30.1904],                
                	                '宁夏': [106.3586,38.1775],
                	                '吉林': [125.8154,44.2584],
                	                '山东': [120.4651,36.3373],
                	                '江苏': [119.4543,31.5582],
                	                '北京': [116.4551,40.2539]
                	            }
                	        },
                	        {
                	            name: '北京 Top10',
                	            type: 'map',
                	            mapType: 'china',
                	            data:[],
                	            markLine : {
                	                smooth:true,
                	                effect : {
                	                    show: true,
                	                    scaleSize: 1,
                	                    period: 30,
                	                    color: '#fff',
                	                    shadowBlur: 10
                	                },
                	                itemStyle : {
                	                    normal: {
                	                        borderWidth:1,
                	                        lineStyle: {
                	                            type: 'solid',
                	                            shadowBlur: 10
                	                        }
                	                    }
                	                },
                	                data : [
                	                    /* [{name:'内蒙古'}, {name:'上海',value:95}],
                	                    [{name:'内蒙古'}, {name:'广东',value:90}],
                	                    [{name:'内蒙古'}, {name:'新疆',value:90}], */
                	                    
                	                    <%=zhi%>
                	                ]
                	            },
                	            markPoint : {
                	                symbol:'emptyCircle',
                	                symbolSize : function (v){
                	                    return 10 + v/10
                	                },
                	                effect : {
                	                    show: true,
                	                    shadowBlur : 0
                	                },
                	                itemStyle:{
                	                    normal:{
                	                        label:{show:false}
                	                    },
                	                    emphasis: {
                	                        label:{position:'top'}
                	                    }
                	                },
                	                data : [
                	                    /* {name:'上海',value:95},
                	                    {name:'广东',value:90}, */
                	                    <%=quan%>
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