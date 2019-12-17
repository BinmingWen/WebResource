<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/10
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>学习资源</title>
    <link rel="stylesheet" href="../../css/index.css" />
    <link rel="stylesheet" href="../../css/index-middle.css" />
    <style>
        *{
            list-style: none;
            padding: 0;
            margin: 0;
            text-decoration: none;
        }
        .learning-resource-page .category ul{
            position: fixed;
            top: 120px;
            left: 30px;
            width: 130px;
            height: 285px;
            border: 1px solid #cccccc;
            text-align: center;
            background-color:#f5f5f5;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 09);
        }
        .learning-resource-page .category ul li{
            width: 130px;
            height: 40px;
            border-bottom: 1px solid #cccccc;
            line-height: 35px;
        }
        .learning-resource-page .category ul li:last-child{
            border-bottom: 0;
        }
        .learning-resource-page .category ul li a{
            color: #337ab7;
        }
        .learning-resource-page .category ul li a:hover{
            color: darkblue;
            font-size: 18px;
            text-decoration: underline;
        }
        .learning-resource-page .page-main .post-body{
            margin: 50px 0;
            position: relative;
            left: 300px;
            width: 60%;
            min-height: 250px;
            background-color:#f5f5f5;
        }
        .learning-resource-page .page-main .entry-padding{
            height: 110px;
            padding-top: 10px;
            padding-left: 20px;
            padding-right: 8px;
        }
        .learning-resource-page .page-main .entry-padding span{
            color: #833a3a;
            margin-bottom: 20px;
            font-weight: 100;
            margin-right: 8px;
            letter-spacing: .05em;
        }
        .learning-resource-page .page-main .entry-padding .post-title{
            word-wrap: break-word;
            margin-top: 5px;
            margin-bottom: 10px;
        }
        .learning-resource-page .page-main .entry-padding .post-title a{
            color: #337ab7;
            font-size: 30px;
            font-weight: 400;
        }
        .learning-resource-page .page-main .entry-padding .post-title a:hover{
            color: darkblue;
            text-decoration: underline;
        }
        .learning-resource-page .page-main .entry-padding .post-writer{
            margin-bottom: 10px;
        }
        .learning-resource-page .page-main .pagination ul{
            display:inline-block;
            padding-left: 0;
            border-radius: 4px;
            text-align: center;
            margin: 30px 0;
            margin-left: 50%;
            transform: translateX(-50%);
        }
        .learning-resource-page .page-main .pagination ul li{
            display: block;
            float: left;
            border: 1px solid #cccccc;
            border-right: none;
        }
        .learning-resource-page .page-main .pagination ul a{
            height: 30px;
            width: 30px;
            line-height: 30px;
            font-size: 15px;
            padding: 5px 10px;
            color: #337ab7;
        }
        .learning-resource-page .page-main .pagination ul li:last-child{
            border-right: 1px solid #cccccc;
        }
        .learning-resource-page .page-main .pagination ul li:hover{
            background: #d3d3d3;
            border-right: none;
        }

    </style>
</head>
<body>
<jsp:include page="../../assert/headTwo.jsp"/>
<div class="learning-resource-page">
    <div class="page-left">
        <%--<div id="resource-category" class="category">
            <ul class="menu">
                <li><a href="">学习资源1</a></li>
                <li><a href="">学习资源2</a></li>
                <li><a href="">学习资源3</a></li>
                <li><a href="">学习资源4</a></li>
                <li><a href="">学习资源5</a></li>
                <li><a href="">学习资源6</a></li>
                <li><a href="">学习资源7</a></li>
            </ul>
        </div>--%>
    </div>
    <div class="page-main">

        <div id="list-resource" class="post-body">
            <c:forEach var="resource" items="${pageInfo.list}">
            <div class="entry-padding">
                <h2 class="post-title">
                    <a href="${pagetext.request.contextPath}/JumpDownLoadServlet?name=${resource.name}&type=${resource.type}&filename=${resource.saveFileName}&fileName=${resource.fileName}">${resource.name}</a>
                </h2>
                <span class="post-info">简介：${resource.descn}</span>
                <span class="post-resource">资源分类：${resource.type}</span><br>
                <span class="post-writer">作者：${resource.uploaderName}</span>
                <hr>
            </div>
            </c:forEach>

            <div class="pagination">
                <ul class="pagination-num">
                   <c:if test="${pageInfo.currentPage-1 gt 0}">
                       <a href="${pageContext.request.contextPath}/DownloadResourceServlet?currentPage=${pageInfo.currentPage-1}">上一页</a>
                   </c:if>
                    <c:if test="${pageInfo.currentPage-1 le 0}">
                        <span>上一页</span>
                    </c:if>
                    <c:forEach begin="${pageInfo.beginPage}" end="${pageInfo.endPage}" varStatus="status">
                        <c:if test="${pageInfo.currentPage eq status.index}">
                            <span>${status.index}</span>
                        </c:if>
                        <c:if test="${pageInfo.currentPage ne status.index}">
                            <a href="${pageContext.request.contextPath}/DownloadResourceServlet?currentPage=${status.index}">${status.index}</a>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.currentPage lt pageInfo.totalPages}">
                        <a href="${pageContext.request.contextPath}/DownloadResourceServlet?currentPage=${pageInfo.currentPage+1}">下一页</a>
                    </c:if>
                    <c:if test="${pageInfo.currentPage ge pageInfo.totalPages}">
                        <span>下一页</span>
                    </c:if>
                    <span>当前页：${pageInfo.currentPage}</span>
                    <span>总页数：${pageInfo.totalPages}</span>
                    <span>总记录数：${pageInfo.totalRecords}</span>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
