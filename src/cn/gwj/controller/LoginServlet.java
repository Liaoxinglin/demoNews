package cn.gwj.controller;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.controller
    User:1093499975@qq.com
    Date:2019/7/4 0004
    Time:09:18
*/

import cn.gwj.entity.User;
import cn.gwj.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LoginServlet extends BaseController {
    public void login(HttpServletRequest request, HttpServletResponse response){
        String uName=request.getParameter("uName");
        String uPwd=request.getParameter("uPwd");
        getServletContext().setAttribute("u",uName);
        User user=new User();
        user.setuName(uName);
        user.setuPwd(uPwd);
        user=new UserServiceImpl().getUser(user);
        Map msgMap=new HashMap();
        if(user.getId()>0 && user.getuPwd().equals(uPwd)){//用户存在且密码正确
            request.getSession().setAttribute("user",user);//登陆成功设置登录session
            msgMap.put("msg","登录成功");
            msgMap.put("status","true");
            msgMap.put("user",user.getuName());
            if(Objects.isNull(getServletContext().getAttribute("loginCount"))){
                getServletContext().setAttribute("loginCount",1);
            }else{
                Integer count=(Integer)getServletContext().getAttribute("loginCount");
                getServletContext().setAttribute("loginCount",count+1);
            }
        }else {
            msgMap.put("msg","登录失败，用户名或密码错误！");
            msgMap.put("status",false);
        }
        PrintWriter pw= null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.println(JSONArray.toJSON(msgMap));

    }
//注销
    public void loginout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath()+"/view/login.jsp");
        Integer count=(Integer)getServletContext().getAttribute("loginCount");
        getServletContext().setAttribute("loginCount",count-1);
    }

}
