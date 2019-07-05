<%--
    Created by IntelliJ IDEA.
    User:1093499975@qq.com
    Date:2019/7/1 0001
    Time:15:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%     request.setCharacterEncoding("utf-8");

%>

<html>
<head>
    <title>提示信息</title>
</head>
<body>
<div>

    <%=request.getAttribute("msg")%>
</div>
</body>
</html>
