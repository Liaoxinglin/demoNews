<%@ page import="cn.gwj.dao.impl.NewsDaoImpl" %>
<%@ page import="cn.gwj.entity.News" %>
<%@ page import="java.util.Date" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.FileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="cn.gwj.service.impl.NewsServiceImpl" %>
<%@ page import="org.apache.commons.fileupload.FileUploadBase" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/26
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");
//    int tid=request.getParameter("tid")!=null?Integer.parseInt(request.getParameter("tid")):0;
//    int ntid=Integer.parseInt(request.getParameter("ntid"));
//    String ntitle=request.getParameter("ntitle");
//    String nauthor=request.getParameter("nauthor");
//    String nsummary=request.getParameter("nsummary");
//    String ncontent=request.getParameter("ncontent");
    News news =new News();
//    news.setNtid(ntid);
//    news.setNtitle(ntitle);
//    news.setNauthor(nauthor);
//    news.setNsummary(nsummary);
//    news.setNcontent(ncontent);

    //判断请求信息中的内容 是否是文件流
    boolean isMultipart= ServletFileUpload.isMultipartContent(request);
    //上传文件的存储路径（服务器文件系统上的绝对文件路径）
    String savePath=getServletConfig().getServletContext().getRealPath("upload");
    String filedName=null;//表单字段元素的name属性值
    if(isMultipart){
        try{
            //通过实现类创建fileItem工厂对象
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            servletFileUpload.setFileSizeMax(1024*1024*5);//设置文件上传大小5m
            List<FileItem> fileItemList=servletFileUpload.parseRequest(request);
            Iterator<FileItem> iterator=fileItemList.iterator();
            FileItem fileItem=null;
            File saveFile=null;
            boolean isUploadType=false;//是否允许文件上传的类型
            while (iterator.hasNext()) {
                fileItem = iterator.next();
                if (fileItem.isFormField()) {//普通表单
                    //获取表单Name的值
                    System.out.println("putong");
                    filedName = fileItem.getFieldName();//获取表单name的值
                    switch (filedName) {
                        case "nid":
                            news.setNid(Integer.parseInt(fileItem.getString("UTF-8")));
                            break;
                        case "ntid":
                            news.setNtid(Integer.parseInt(fileItem.getString("UTF-8")));
                            break;
                        case "ntitle":
                            news.setNtitle(fileItem.getString("UTF-8"));
                            break;
                        case "nauthor":
                            news.setNauthor(fileItem.getString("UTF-8"));
                            break;
                        case "nsummary":
                            news.setNsummary(fileItem.getString("UTF-8"));
                            break;
                        case "ncontent":
                            news.setNcontent(fileItem.getString("UTF-8"));
                            break;
                    }
                } else {//文件类
                    System.out.println("tupian");
                    String fileName = fileItem.getName();
                    if (fileName.length() > 0) {//文件名存在
                        List<String> fileType = Arrays.asList("jpg", "png", "gif");//设置文件上传的类型
                        int index = fileName.lastIndexOf(".");//查找文件名中最后一个.的位置
                        String ext = index == -1 ? "" : fileName.substring(index + 1).toLowerCase();
                        if (fileType.contains(ext)) {
                            //判断文件类型是否在允许范围内
                            saveFile = new File(savePath, String.valueOf(new Date().getTime()) + (int) Math.random() * 5 + fileItem.getName());
                            fileItem.write(saveFile);
                            news.setNpicpath(fileItem.getName());
                        }
                    }
                }
            }
        } catch (FileUploadBase.SizeLimitExceededException e) {
            out.print("<script type=\"text/javascript\">");
            out.print("alert(\"图片上传失败，文件的最大限制是：5MB\");");
            out.print("location.href=\"../util/news_control.jsp?opr=toAddNews\";");
            out.print("</script>");
        }
    }

    if(news.getNid()>0){
        news.setNmodifydate(new Date());
        if(!new NewsServiceImpl().updateNews(news)){
            request.setAttribute("msg","更新失败");
            request.getRequestDispatcher("/view/msg.jsp").forward(request,response);
        }
        //更新
    }else {
        news.setNcreatedate(new Date());
        if(!new NewsServiceImpl().saveNews(news)){
            request.setAttribute("msg","保存失败");
            request.getRequestDispatcher("/view/msg.jsp").forward(request,response);
        }
        //保存
    }

//    if(tid>0){
//        news.setNid(tid);
//        news.setNmodifydate(new Date());
//        newsDao.updateNews(news);
//
//        //更新
//    }else {
//        newsDao.insertNews(news);
//        //保存
//    }

    response.sendRedirect(request.getContextPath()+"/view/admin/index.jsp");

%>

</body>
</html>
