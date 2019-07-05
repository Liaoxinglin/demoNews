<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/24
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<%     request.setCharacterEncoding("utf-8");

%>

<html>
<head>
    <title>提示信息</title>
</head>
<body>
<div>
    <%--设置值--%>
    <c:set property="" target="" value="123" var="zs"></c:set>
    <%--获取值--%>
    <c:out value="zs"></c:out>
    <c:out value="123"></c:out>
    <c:out value="${zs}"></c:out>
</div>
</body>
</html>
