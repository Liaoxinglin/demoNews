<%--
    Created by IntelliJ IDEA.
    User:1093499975@qq.com
    Date:2019/7/1 0001
    Time:15:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@ page import="cn.gwj.service.impl.NewsServiceImpl" %>
<%@ page import="cn.gwj.entity.News" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>添加主题--管理后台</title>
    <link href="<%=request.getContextPath()%>/static/css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
    <div id="welcome">欢迎使用新闻管理系统！</div>
    <div id="nav">
        <div id="logo"><img src="<%=request.getContextPath()%>/static/images/logo.jpg" alt="新闻中国" /></div>
        <div id="a_b01"><img src="<%=request.getContextPath()%>/static/images/a_b01.gif" alt="" /></div>
    </div>
</div>
<div id="admin_bar">
    <div id="status">管理员： 登录  &#160;&#160;&#160;&#160; <a href="#">login out</a></div>
    <div id="channel"> </div>
</div>
<div id="main">
    <%@ include file="/view/layout/left.jsp" %>
    <div id="opt_area">
        <%
            int nid=Integer.parseInt(request.getParameter("nid"));
            News news= new NewsServiceImpl().getNewsById(nid);
        %>
        <h2><%=news.getNtitle()%></h2>
        <div>
            <%=news.getNcontent()%>
        </div>


    </div>
</div>
<div id="footer">
    <%-- 引入公共部分--%>
    <%@ include file="../../layout/bom.jsp" %>
</div>
</body>
</html>
