<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/9
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default nav-bar-width nav-bar-height">
    <div class="navbar-header"></div>
    <div class="access-statistics"></div>
    <ul id="menu">
        <li ><a href="/pages/login/success.jsp">首页</a></li>
        <li ><a href="${pageContext.request.contextPath}/JumpUploadServlet">上传资源</a></li>
        <li ><a href="${pageContext.request.contextPath}/DownloadResourceServlet">资源库</a></li>
        <li ><a href="${pageContext.request.contextPath}/PostListServlet">留言</a></li>
        <li ><a href="${pageContext.request.contextPath}/ShareServlet">分享</a></li>
        <li ><a href="">联系站长</a></li>
    </ul>
    <div class="navbar-header"></div>
    <div class="welcome">欢迎</div>
    <div class="navbar-header"></div>
    <div>
        <a href="${pageContext.request.contextPath}/JumpUsersServlet" class="user-button2">
            <span>个人界面</span>
        </a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/ExitUserServlet" class="user-button1">
            <span>退出</span>
        </a>
    </div>
</nav>