<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/26
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>

    <%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8"%>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>新闻发布系统管理后台</title>
    <link href="<%=request.getContextPath()%>/static/css/admin.css" rel="stylesheet" type="text/css" />
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
    </head>
    <body>

