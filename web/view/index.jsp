<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/22
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"


%>
<%@ include file="cheackLogin.jsp"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <!-- html注释 -->
<%=session.getId()%>


  登陆成功，欢迎<%=session.getAttribute("user")%>来到网易新闻

  </body>
</html>
