<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/8
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资源上传</title>
    <link rel="stylesheet" href="../../css/index.css" />
    <link rel="stylesheet" href="../../css/index-middle.css" />
</head>
<jsp:include page="../../assert/headTwo.jsp"/>
<body>
<div align="center">
    <form action="" enctype="multipart/form-data" method="post">
        资源名称<input type="text" name="reName"/><br>
        <input type="submit" value="提交">&nbsp;&nbsp;
        <input type="reset" value="重置">
    </form>
</div>

</body>
</html>
