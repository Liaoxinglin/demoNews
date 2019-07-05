package cn.gwj.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;
        if(Objects.nonNull(httpServletRequest.getSession().getAttribute("user"))){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/view/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
