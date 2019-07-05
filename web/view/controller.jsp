<%@ page import="cn.gwj.entity.User" %>
<%@ page import="cn.gwj.service.impl.UserServiceImpl" %>
<%@ page import="java.util.Objects" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/24
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>控制器</title>
</head>
<body>


<%

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
    UserServiceImpl userServiceo=new UserServiceImpl();

    User loginUser=new User();
    loginUser.setuName(user);
    loginUser.setuPwd(pwd);
   loginUser= userServiceo.getUser(loginUser);
//    System.out.println(loginUser.getuName());
//    System.out.println(loginUser.getuPwd());

   if(loginUser.getuName().equals(user)&&loginUser.getuPwd().equals(pwd)){
       session.setAttribute("user",user);
       if(role==0){

          if(Objects.nonNull(application.getAttribute("size"))){

              int size=(int)application.getAttribute("size");
              System.out.println(size);
              application.setAttribute("size",size+1);
          }else {
              application.setAttribute("size",1);
          }
          // response.sendRedirect("/new/admin.jsp");
           request.getRequestDispatcher("admin/index.jsp").forward(request,response);
       }else {
           response.sendRedirect("/index.jsp");
       }

   }else {
       request.setAttribute("msg","用户名或密码错误");
       request.getRequestDispatcher("/login.jsp").forward(request,response);
   }
%>
</body>
</html>
