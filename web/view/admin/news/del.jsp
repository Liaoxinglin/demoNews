<%@ page import="cn.gwj.service.impl.NewsServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/26
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    int nid=Integer.parseInt(request.getParameter("nid"));
    if (new NewsServiceImpl().delNewsById(nid)){
        response.sendRedirect(request.getContextPath()+"/view/admin/index.jsp");
    }else {
        request.setAttribute("msg","删除失败");
        request.getRequestDispatcher(request.getContextPath()+"/view/msg.jsp");
    }

%>

