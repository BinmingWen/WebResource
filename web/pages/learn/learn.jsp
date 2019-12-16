<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/5
  Time: 17:39
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
        <div id="resource-category" class="category">
            <ul class="menu">
                <li><a href="">学习资源1</a></li>
                <li><a href="">学习资源2</a></li>
                <li><a href="">学习资源3</a></li>
                <li><a href="">学习资源4</a></li>
                <li><a href="">学习资源5</a></li>
                <li><a href="">学习资源6</a></li>
                <li><a href="">学习资源7</a></li>
            </ul>
        </div>
    </div>
    <div class="page-main">
        <div id="list-resource" class="post-body">
            <div class="entry-padding">
                <h2 class="post-title">
                    <a href="">这是一个标题</a>
                </h2>
                <span class="post-info">简介：JavaWeb概述</span>
                <span class="post-resource">资源分类：JavaWeb</span><br>
                <span class="post-writer">作者：梳碧湖砍材人</span>
                <hr>
            </div>
            <div class="entry-padding">
                <h2 class="post-title">
                    <a href="">这是一个标题</a>
                </h2>
                <span class="post-info">简介：JavaWeb概述</span>
                <span class="post-resource">资源分类：JavaWeb</span><br>
                <span class="post-writer">作者：梳碧湖砍材人</span>
                <hr>
            </div>
            <div class="entry-padding">
                <h2 class="post-title">
                    <a href="">这是一个标题</a>
                </h2>
                <span class="post-info">简介：JavaWeb概述</span>
                <span class="post-resource">资源分类：JavaWeb</span><br>
                <span class="post-writer">作者：梳碧湖砍材人</span>
                <hr>
            </div>
            <div class="entry-padding">
                <h2 class="post-title">
                    <a href="">这是一个标题</a>
                </h2>
                <span class="post-info">简介：JavaWeb概述</span>
                <span class="post-resource">资源分类：JavaWeb</span><br>
                <span class="post-writer">作者：梳碧湖砍材人</span>
                <hr>
            </div>
            <div class="entry-padding">
                <h2 class="post-title">
                    <a href="">这是一个标题</a>
                </h2>
                <span class="post-info">简介：JavaWeb概述</span>
                <span class="post-resource">资源分类：JavaWeb</span><br>
                <span class="post-writer">作者：梳碧湖砍材人</span>
                <hr>
            </div>
            <div class="entry-padding">
                <h2 class="post-title">
                    <a href="">这是一个标题</a>
                </h2>
                <span class="post-info">简介：JavaWeb概述</span>
                <span class="post-resource">资源分类：JavaWeb</span><br>
                <span class="post-writer">作者：梳碧湖砍材人</span>
                <hr>
            </div>
            <div class="entry-padding">
                <h2 class="post-title">
                    <a href="">这是一个标题</a>
                </h2>
                <span class="post-info">简介：JavaWeb概述</span>
                <span class="post-resource">资源分类：JavaWeb</span><br>
                <span class="post-writer">作者：梳碧湖砍材人</span>
                <hr>
            </div>
            <div class="pagination">
                <ul class="pagination-num">
                    <li value="0"><a href="">＜</a></li>
                    <li value="1"><a href="">1</a></li>
                    <li value="2"><a href="">2</a></li>
                    <li value="3"><a href="">3</a></li>
                    <li value="4"><a href="">4</a></li>
                    <li value="5"><a href="">5</a></li>
                    <li value="6"><a href="">6</a></li>
                    <li value="-1"><a href="">＞</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
