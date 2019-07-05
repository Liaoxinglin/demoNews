package cn.gwj.controller;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.controller
    User:1093499975@qq.com
    Date:2019/7/1 0001
    Time:16:38
*/

import cn.gwj.entity.User;
import cn.gwj.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends BaseController {
    public void add(HttpServletRequest request, HttpServletResponse response){
        String uName=request.getParameter("user");
        String uPwd=request.getParameter("pwd");
        UserServiceImpl userService=new UserServiceImpl();
        User user=new User();
        user.setuName(uName);
        user.setuPwd(uPwd);
        if(userService.addUser(user)){
            request.setAttribute("msg","注册成功！");
        }else {
            request.setAttribute("msg","注册失败！");
        }
        try {
            request.getRequestDispatcher("/msg.jsp").forward(request,response); //转发请求 forward方法把请求信息和响应信息传过去
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkUser(HttpServletRequest request,HttpServletResponse response){
        String name=request.getParameter("uname");
        User user=new User();
        user.setuName(name);
        try {
            PrintWriter pw=response.getWriter();
            boolean flag=false;
            String msg="恭喜可以注册！";
            StringBuffer sb=new StringBuffer();
            //已有此账号
            if(new UserServiceImpl().getUser(user).getId()>0){
                flag=true;
                msg="该用户已存在！";
            }
//            sb.append("{");
//            sb.append("\"status\":"+flag+",");
//            sb.append("\"msg\":"+"\""+msg+"\"");
//            sb.append("}");
//
//            pw.println(sb);
            //第二种方式转化json字符串
            Map map=new HashMap();
            map.put("status",flag);
            map.put("msg",msg);
            pw.println(JSONArray.toJSONString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show(HttpServletRequest request,HttpServletResponse response){}


}
