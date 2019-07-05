package cn.gwj.controller;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.controller
    User:1093499975@qq.com
    Date:2019/7/3 0003
    Time:10:09
*/

import cn.gwj.entity.Topic;
import cn.gwj.service.TopicService;
import cn.gwj.service.impl.TopicServiceImpl;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class TopicServlet extends BaseController{
    private TopicService topicService=new TopicServiceImpl();
    public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/admin/topic/add.jsp").forward(request,response);

    }

    public void save(HttpServletRequest request ,HttpServletResponse response){
//        获取请求的参数
        String tname=request.getParameter("tname");
        Topic topic=new Topic();
        topic.setTname(tname);
        try {
    //        调用服务层 保存的服务
            if(topicService.saveTopic(topic)){
                //添加成功,请求栏目列表的servlet转发到jsp
                //重定向/只能识别域名
                    response.sendRedirect(request.getContextPath()+"/topic?action=list");
                System.out.println("保存成功");
            }else {
                //添加失败，响应当前页面提示添加失败
                request.setAttribute("msg","保存失败！");
                //转发/能识别域名和应用名
                request.getRequestDispatcher("/view/tips.jsp").forward(request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
    } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void list(HttpServletRequest request,HttpServletResponse response){
        System.out.println("list");
        try {
            request.setAttribute("topics",topicService.getTopicList());
            request.getRequestDispatcher("/view/admin/topic/list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ajaxList(HttpServletRequest request,HttpServletResponse response){
        try {
            PrintWriter pw=response.getWriter();
            pw.println(JSONArray.toJSON(topicService.getTopicList()));//把list集合转成json数组
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
