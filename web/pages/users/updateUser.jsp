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
        <form>
            <ul>
                <li>姓名<input id="" maxlength="30" name="user-name"/></li>
                <li>性别
                    <select name="">
                        <option value="male">男</option>
                        <option value="female">女</option>
                    </select>
                </li>
                <li>年龄<input id="" maxlength="5" name="user-age"/></li>
                <li>所在地<input id="" maxlength="30" name="user-home"/></li>
            </ul>
            <div class="submit-btn">
                <button>提交</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>

