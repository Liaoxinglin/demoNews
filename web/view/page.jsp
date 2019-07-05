<%@ page import="cn.gwj.entity.Page" %>
<%@ page import="cn.gwj.service.impl.NewsServiceImpl" %><%--
    Created by IntelliJ IDEA.
    User:1093499975@qq.com
    Date:2019/6/27 0027
    Time:16:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int pageIndex=request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex"));
    if(pageIndex<1)
        pageIndex=1;
    Page pageData=new Page();
    pageData.setCurrPageNo(pageIndex);
    pageData.setPageSize(5);
    new NewsServiceImpl().getPageNews(pageData);
%>

