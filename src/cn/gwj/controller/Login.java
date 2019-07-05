package cn.gwj.controller;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.controller
    User:1093499975@qq.com
    Date:2019/6/29 0029
    Time:14:35
*/

import cn.gwj.entity.User;
import cn.gwj.service.impl.UserServiceImpl;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Login extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        pw.println("执行了doGet");//浏览器方式提交为get方式提交

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter pw=response.getWriter();
//        pw.println("执行了doPost");
        request.setCharacterEncoding("utf-8");
        String user= request.getParameter("user");
        String pwd= request.getParameter("pwd");
        String auto=request.getParameter("autoLogin");
        if(auto!=null){

            System.out.print("点了自动登录");
            Cookie cookieUser=new Cookie("user",user);
            Cookie cookiePwd=new Cookie("pwd",pwd);
            cookiePwd.setMaxAge(300);
            response.addCookie(cookieUser);
            response.addCookie(cookiePwd);

            Cookie[] cookies=request.getCookies();
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("user")){
                    user=cookie.getValue();
                }
                if (cookie.getName().equals("pwd")){
                    pwd=cookie.getValue();
                }
            }
        }
        int role=0;
        UserServiceImpl userService=new UserServiceImpl();
        User loginUser=new User();
        loginUser.setuName(user);
        loginUser.setuPwd(pwd);
        loginUser= userService.getUser(loginUser);
        System.out.println(loginUser.getuName());
        System.out.println(loginUser.getuPwd());
        if(loginUser.getuName().equals(user)&&loginUser.getuPwd().equals(pwd)){
//            session.setAttribute("user",user);
            request.getSession().setAttribute("user",user);

            if(role==0){
//                if(Objects.nonNull(getServletContext().getAttribute("size"))){
//                    int size=(int)getServletContext().getAttribute("size");
//                    System.out.println(size);
//                    getServletContext().setAttribute("size",size+1);
//                }else {
//                    getServletContext().setAttribute("size",1);
//                }
                // response.sendRedirect("/new/admin.jsp");
                request.getRequestDispatcher("view/admin/index.jsp").forward(request,response);
            }else {
                response.sendRedirect("/news/index.jsp");
            }

        }else {
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("获取了初始化参数名字："+servletConfig.getInitParameter("zs"));
        System.out.println("执行了init");

    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("ls:"+super.getServletConfig().getInitParameter("ls"));
        return super.getServletConfig();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        super.service(request,response);
    }
}
