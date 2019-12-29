<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/9
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default nav-bar-width nav-bar-height">
    <div class="navbar-header"></div>
    <div class="access-statistics"></div>
    <ul id="menu">
        <li ><a href="/pages/index.jsp">首页</a></li>
        <li ><a href="${pageContext.request.contextPath}/CheckServlet">上传资源</a></li>
        <li ><a href="${pageContext.request.contextPath}/FirstDownloadResourceServlet">资源库</a></li>
        <li ><a href="${pageContext.request.contextPath}/CheckServlet">留言</a></li>
       <%-- <li ><a href="/pages/login/login.jsp">分享</a></li>
        <li ><a href="/pages/login/login.jsp">联系站长</a></li>--%>
    </ul>
    <div class="navbar-header"></div>
    <div>
        <a href="${pageContext.request.contextPath}/UserLoginServlet" class="login-button">
            <span>登录/注册</span>
        </a>
    </div>
</nav>
