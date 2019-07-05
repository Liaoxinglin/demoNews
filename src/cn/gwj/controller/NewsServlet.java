package cn.gwj.controller;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.controller
    User:1093499975@qq.com
    Date:2019/7/1 0001
    Time:11:41
*/

import cn.gwj.service.impl.NewsServiceImpl;
import cn.gwj.util.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class NewsServlet extends BaseController{
    public void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int pageIndex=request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex"));
        if (pageIndex<1)
            pageIndex=1;
        Page pageData=new Page();
        pageData.setCurrPageNo(pageIndex);
        pageData.setPageSize(5);
        pageData.setTotalCount(new NewsServiceImpl().countNews());
        request.setAttribute("list",new NewsServiceImpl().getPageNews(pageData));
        request.setAttribute("pageData",pageData);
        request.getRequestDispatcher("/view/admin/index.jsp").forward(request,response);
    }
}
