<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/16
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
    <link rel="stylesheet" href="css/index.css" />
    <link rel="stylesheet" href="css/index-middle.css" />
    <style>
        .message {
            width: 100%;
            height: 800px;
            background-image: url(img/bg-2.jpg);
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
        <h2>请输入新密码</h2>
        <form method="post" action="${pageContext.request.contextPath}/UpdatePwsServlet">
            <ul>
                <li>新密码:<input id="" maxlength="30" name="newkey"/></li>
                <input type="hidden" name="userId" value="${user.userId}">
            </ul>
            <div class="submit-btn">
                <input type="submit" value="提交" style="height: 30px;width: 70px;"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>

