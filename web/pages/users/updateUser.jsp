<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/11
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改个人资料</title>
    <link rel="stylesheet" href="../../css/index.css" />
    <link rel="stylesheet" href="../../css/index-middle.css" />
    <style>
        .message {
            width: 100%;
            height: 800px;
            background-image: url(../../img/bg-2.jpg);
        }

        .message-center {
            position: absolute;
            left: 40%;
        }
        li {
            list-style: none;
            margin-top: 30px;
        }

        .submit-btn {
            position: absolute;
            left: 100px;
        }
    </style>
</head>
<body>
<div class="message">
    <div class="message-center">
        <h2>请输入下列信息</h2>
        <form action="${pageContext.request.contextPath}/UpdateServlet" method="post">
            学号：<input type="text" name="userNo"><br>
            姓名：<input type="text" name="userName"><br>
            班级：<input type="text" name="className"><br>
            <input type="hidden" name="userId" value="${user.userId}">
            <input type="submit" value="提交">
        </form>
    </div>
</div>
</body>
</html>

