<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/11
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户界面</title>
    <link rel="stylesheet" href="../../css/a_tap.css" />
    <link rel="stylesheet" href="../../css/index.css" />
    <link rel="stylesheet" href="../../css/index-middle.css" />
    <script>
        function hover(n,count){
            var $ = function(o) {
                return document.getElementById(o);
            }
            for(var i = 1;i<=count;i++) {
                $('tap_'+i).className = 'normal';
                $('content_'+i).className = 'none';
            }
            $('content_'+n).className = 'show';
            $('tap_'+n).className = 'hover';
        }
    </script>
    <style>

    </style>
</head>
<body>
<jsp:include page="../../assert/headTwo.jsp"/>
<div class="tap_wrap">
    <ul class="tap">
        <li id="tap_1" class="hover" onclick="hover(1,2)">账户</li>
        <li id="tap_2" class="normal" onclick="hover(2,2)">资料</li>
    </ul>
    <div class="content">
        <div id="content_1" class="show">
            <div>
                <form>
                    <ul>
                        <li class="user-list">用户名: ${user.userName}</li>
                        <li class="user-list">密码:${user.password}</li>
                        <li class="user-list-rewrite"><button><a href="${pageContext.request.contextPath}/JumpSetPasswordServlet">修改密码</a></button>
                    </ul>
                </form>
            </div>
        </div>
        <div id="content_2" class="none">
            <form >
                <ul>
                    <li class="user-list">姓名：${user.userName}</li>
                    <li class="user-list">学号/教师编号：${user.userNo}</li>
                    <li class="user-list">班级：${user.className}</li>
                </ul>
                <div class="rewrite-btn"><a href="${pageContext.request.contextPath}/JumpUpdateServlet">修改个人资料</a></div>
            </form>
        </div>
    </div>
</div>
<script>
    function myFunction() {
        var person = prompt("请输入密码：");
        if (person == null || person == "") {
            alert("密码为空")
        } else {
            alert("密码已修改")
        }
    }
</script>
</body>
</html>

