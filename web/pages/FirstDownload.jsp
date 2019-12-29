<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/8
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>下载界面</title>
    <link rel="stylesheet" href="../css/index.css" />
    <link rel="stylesheet" href="../css/index-middle.css" />
    <style>
        .DL {
            position: absolute;
            width: 700px;
            left: 20%;
            background-color: #E6F2FF;
        }
        .DL ul {
            list-style: none;
        }
        .must-know {
            border: red;
            width: 500px;
        }
    </style>
</head>
<body>
<jsp:include page="../assert/head.jsp"/>
<div class="DL">
    <h2>资源下载</h2>
    <ul>
        <li>资源名称: ${name}</li>
        <li>分类: ${type}</li>
        <li>文件名称: ${fileName}</li>
        <li>下载链接: <button class="download-btn"><a href="${pageContext.request.contextPath}/DownLoadServlet?filename=${filename}">点击下载</a></button></li>
    </ul>
    <div class="must-know">
        <h4>下载须知</h4>
        <ul>
            <li>1.下载资源基本为压缩文档，下载后需注意根据需求解压到自己需要的目录内</li>
            <li>2.若资源说明内有上传者的资源配置要求，请根据要求按步骤解压和运行文件，以免出现错误</li>
            <li>3.如遇下载资源失效，可到<a href="">联系站长</a>进行反馈</li>
        </ul>
    </div>
</div>
</body>
</html>

