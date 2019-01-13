<%@page import="com.entity.Xuanke"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
<link href="css/css.css" rel="stylesheet" type="text/css" />
<!-- <link href="css/bootstrap1.min.css" rel="stylesheet" type="text/css" /> -->
<script language="javascript" type="text/javascript"
	src="<%=basePath%>laydate/laydate.js" charset="utf-8"></script>
</head>
<table class="table" cellspacing="1" cellpadding="2" width="80%" align="center" border="0">
  <tbody>
    <tr>
      <th class="bg_tr" align="center" colspan="14" height="25">${mclass.name} 排课安排</th>
    </tr>
  <tr>
   <td class="td_bg" align="left"  colspan="14" height="23">
  	<a href="xuanke/createXuanke.action">&nbsp;&nbsp;&nbsp;&nbsp;<font color='FC5D59'>课程安排设置</font></a>
  	</td>
  </tr>
 
  
  
  
  
  
<% 


	
	String args[][]=new String[8][8];
   for(int i=0;i<args.length;i++){
   	for(int j=0;j<args[0].length;j++){
   		args[i][j]="";
   	}
   }
   args[0][0]=" / ";
   args[0][1]="星期一";
   args[0][2]="星期二";
   args[0][3]="星期三";
   args[0][4]="星期四";
   args[0][5]="星期五";
   args[0][6]="星期六";
   args[0][7]="星期日";
   
   args[1][0]="第一节";
   args[2][0]="第二节";
   args[3][0]="第三节";
   args[4][0]="第四节";
   args[5][0]="第五节";
   args[6][0]="第六节";
   args[7][0]="第七节";
   List<Xuanke> list = (List<Xuanke>)request.getAttribute("xuankeList");

   for(Xuanke xk : list){
	 String s=String.valueOf(xk.getCoursename());
	 String s1=String.valueOf(xk.getTeachername());
	 int a=Integer.parseInt(xk.getXuanke_xz());
	 int a1=Integer.parseInt(xk.getXuanke_yz());
	 String r=String.valueOf(xk.getRoom_name());
	 String r1=String.valueOf(xk.getRoom_adress());
 	 args[a][a1]="("+s1+")"+s+"<br/>"+
 	"地址:"+r+"("+r1+")<br/>" + 
 	"<a class='btn btn-danger' href='xuanke/deleteXuanke.action?id="+xk.getXuanke_id()+"'><font color='FC5D59'>删除</font></a>";	 
 	
	  
   }



%>
  
    <% for(int i=0;i<args.length;i++){%>
    <tr>
       <% for(int j=0 ;j<args[0].length;j++){ %>
    	<% if(i==0){ %>
           <th class="bg_tr" align="center" height="25"><%=args[i][j] %></th>
        <% }else{ %>
            <td class="td_bg" align="center" height="23"><%=args[i][j] %></td>
        <%} %>
        <%} %>
        </tr>
   <%}%>
  </tbody>
</table>

</body>
</html>