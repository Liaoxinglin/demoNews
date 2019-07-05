package cn.gwj.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private  String encoding=null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            this.encoding=filterConfig.getInitParameter("en");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            servletRequest.setCharacterEncoding(this.encoding);
            servletResponse.setCharacterEncoding(this.encoding);
            filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
