<%@ page import="cn.gwj.entity.User" %>
<%@ page import="cn.gwj.service.impl.UserServiceImpl" %>
<%@ page import="java.util.Objects" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/24
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--设定页面使用的字符集,用以说明主页制作所使用的语言和文字,浏览器会根据此来调用相应的字符集显示网页内容--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
    <script src="../static/js/jquery-3.4.1.js" type="text/javascript"></script>
</head>
<body>

<form action="reg.jsp" method="post" >
    用户名：<input name="user"><span id="userError"></span><br/>
    密码：<input type="password" name="pwd">
    <input type="submit" value="注册">
</form>
<div id="box1"></div>
<table id="tb" border="1">

</table>
<script>

    /*
    传统方式实现Ajax
    var user=$("input[name=\"user\"]").val();
    创建异步请求对象
    xmlHttpRequest=new XMLHttpRequest();
    设置回调函数
    xmlHttpRequest.onreadystatechange=res;
    初始化xmlHttpRequest组件、服务器端URL地址,name为用户名文本框获取的值
    var url="http://localhost:8080/demoNews/user?action=checkUser&uname="+user;
    xmlHttpRequest.open("get",url,true);
    发送请求
    xmlHttpRequest.send();

    function res() {
        if(xmlHttpRequest.readyState==4&&xmlHttpRequest.status==200){
            //XMLHttpRequest对象读取响应结束并且服务器正确返回响应
            var data=xmlHttpRequest.responseText;//以文本形式获得响应的内容
            if(data){}
        }
    }
    */


/*
    jquery的ajax()方法
 */
    $("input[name='user']").blur(function () {
        var user=$("input[name=\"user\"]").val();
        $.ajax({
            url:"http://localhost:8080/demoNews/user?action=checkUser",//请求的地址
            type:"post",//请求的方式
            data:{uname:user},//请求的数据
            dataType:"json",//响应的数据类型
            success:function (rst){//请求成功后执行
                if(rst.status){
                    $("#userError").text("该用户已注册！");
                }else{
                    $("#userError").text("恭喜你可以注册！");
                }
                console.log(rst);//请求成功
            },
            error:function (er) {//请求失败
                console.log(er);
            }
        })
    })

    /*
        json

    var zs={name:"张三",age:18,gender:"男"};
    var ls={name:"李四",age:19,gender:"男"};
    var wu={name:"王五",age:20,gender:"女"};
    $("#box1").append("姓名:"+zs.name);
    $("#box1").append("年龄:"+zs.age);
    $("#box1").append("性别:"+zs.gender);

    var zss=[
        {name:"张三",age:18,gender:"男"},
        {name:"李四",age:19,gender:"男"},
        {name:"王五",age:20,gender:"女"}
    ];
    var trs="";
    for(var p of zss){//foreach
        // console.log(p);
        trs+="<tr>"+"<td>"+p.name+"</td>"+
            "<td>"+p.age+"</td>"+"<td>"+p.gender+"</td>"
            +"</tr>";
        $("#tb").html(trs);
    }
*/

</script>

</body>
</html>
