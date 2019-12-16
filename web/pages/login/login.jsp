<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/3
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<!-- Head -->
<head>

    <title>登陆页面</title>

    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //Meta-Tags -->

    <!-- Style --> <link rel="stylesheet" href="../../css/style.css" type="text/css" media="all">



</head>
<!-- //Head -->

<!-- Body -->
<body>

<h1>登录</h1>

<div class="container w3layouts agileits">

    <div class="login w3layouts agileits">
        <h2>登 录</h2>
        <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <input type="text" Name="userName" placeholder="学号" required="">
            <input type="password" Name="userpwd" placeholder="密码" required="">
            <div class="send-button w3layouts agileits">
                <form>
                    <input type="submit" value="登 录">
                </form>
            </div>
        </form>

        <div class="clear"></div>
    </div>
    <div class="register w3layouts agileits">
        <h2>注 册</h2>
        <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
            <input type="text" Name="name" placeholder="姓名" required="">
            <input type="text" Name="no" placeholder="学号/教师编号" required="">
            <input type="text" Name="className" placeholder="班级" >
            <input type="password" Name="password" placeholder="密码" required="">
            <ul class="tick w3layouts agileits">
                <li>
                    <input type="radio" name="isStu" value="0">
                    <label for="brand1" style="color: azure;"><span></span>学生</label>
                    <input type="radio" name="isStu" value="1">
                    <label for="brand1" style="color: azure;"><span></span>教师</label>
                </li>
            </ul>
            <div class="send-button w3layouts agileits">
                <form>
                    <input type="submit" value="注册">
                </form>
            </div>
        </form>

        <div class="clear"></div>
    </div>

    <div class="clear"></div>

</div>

</body>
<!-- //Body -->

</html>
