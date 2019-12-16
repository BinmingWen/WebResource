<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/7
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载文件显示页</title>
</head>
<body>
<%--遍历Map集合--%>
<c:forEach var="me" items="${fileNameMap}">
    <c:url value="${pageContext.request.contextPath}/DownLoadServlet" var="downurl">
        <c:param name="filename" value="${me.key}"></c:param>
    </c:url>
    ${me.value}<a href="${downurl}">下载</a>
</c:forEach>

</body>
</html>
