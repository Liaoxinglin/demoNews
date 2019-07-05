<%@ page language="java" import="cn.gwj.entity.News,cn.gwj.service.impl.NewsServiceImpl" pageEncoding="utf-8"%>
<%@ page import="cn.gwj.util.Page" %>
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
    <div id="status">管理员： ${sessionScope.user.uName}  &#160;&#160;&#160;&#160; <a href="${pageContext.request.contextPath}/login.html?action=loginout">注销</a></div>
    <div id="channel"> </div>
</div>
<div id="main">
    <%@ include file="../layout/left.jsp" %>
    <div id="opt_area">
        <script type="text/javascript" >
            function clickdel(nid){
                if (confirm("此新闻的相关评论也将删除，确定删除吗？"))
                    window.location="../util/news?opr=delete&nid="+nid;
            }

        </script>
        <ul class="classlist">
            <%
                int pageIndex=request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex"));
                if(pageIndex<1)
                    pageIndex=1;
                Page pageData=new Page();
                pageData.setCurrPageNo(pageIndex);
                pageData.setPageSize(10);
                pageData.setTotalCount(new NewsServiceImpl().countNews());
//                for (News news:new NewsServiceImpl().getNewsList()){
                for (News news:new NewsServiceImpl().getPageNews(pageData)){
            %>
            <li>
                <a href="<%=request.getContextPath()%>/view/admin/news/show.jsp?nid=<%=news.getNid()%>"><%=news.getNtitle()%></a>
                <span>作者：<%=news.getNauthor()%> &#160;&#160;&#160;&#160;
                <a href='<%=request.getContextPath()%>/view/admin/news/edit.jsp?nid=<%=news.getNid()%>'>修改</a>
                &#160;&#160;&#160;&#160;
                <a href='javascript:;' onclick='return clickdel(10)'>删除</a></span>
            </li>
            <li class='space'>
            </li>
            <%}%>
        </ul>
        <div>
            <%
                if(pageData.getCurrPageNo()>1){
            %>
                <a href="index.jsp?pageIndex=1">首页</a>
                <a href="index.jsp?pageIndex="<%=pageData.getCurrPageNo()-1%>">上一页</a>
            <%}%>

            <%
                for(int i=0;i<pageData.getTotalPageCount();i++){
            %>
                <a href="index.jsp?pageIndex=<%=i+1%>"><%=i+1%></a>
            <%}%>
            <%if(pageData.getCurrPageNo()<pageData.getTotalPageCount()){%>
                <a href="index.jsp?pageIndex=<%=pageData.getCurrPageNo()+1%>">下一页</a>
                <a href="index.jsp?pageIndex=<%=pageData.getTotalPageCount()%>">末页</a>
            <%}%>
        </div>
    </div>
</div>
<div id="footer">
    <%-- 引入公共部分--%>
    <%@ include file="../layout/bom.jsp" %>
</div>
</body>
</html>
