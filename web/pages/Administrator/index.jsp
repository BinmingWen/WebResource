<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/5
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="../../css/theme.css">
    <link rel="stylesheet" href="../../css/font-awesome.css">

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>


    <script src="javascripts/html5.js"></script>
    <![endif]-->


</head>


<body>
<!--<![endif]-->
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <ul class="nav pull-right">

                <li id="fat-menu" class="dropdown">
                    <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">
                        管理员
                    </a>

                    <ul class="dropdown-menu">
                        <li><a tabindex="-1" href="#">Settings</a></li>
                        <li class="divider"></li>
                        <li><a tabindex="-1" href="sign-in.html">Logout</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>
</div>
<div class="row-fluid" style="text-align: center">
    <h1>欢迎进入邑大论坛后台管理系统</h1>


</div>

<div class="container-fluid">

    <div class="row-fluid">
        <div class="span3">
            <div class="sidebar-nav">
                <div class="nav-header" data-toggle="collapse" data-target="#dashboard-menu">用户管理</div>
                <ul id="dashboard-menu" class="nav nav-list collapse in">
                    <li ><a href="index.jsp">主页</a></li>
                    <li ><a href="${pageContext.request.contextPath}/UsersListServlet">用户列表</a></li>

                </ul>
                <div class="nav-header" data-toggle="collapse" data-target="#accounts-menu">资源管理</div>
                <ul id="accounts-menu" class="nav nav-list collapse in">
                    <li ><a href="SysuserListSerclet">资源列表</a></li>

                </ul>

                <div class="nav-header" data-toggle="collapse" data-target="#settings-menu">帖子管理</div>
                <ul id="settings-menu" class="nav nav-list collapse in">
                    <li ><a href="#">帖子列表</a></li>

                </ul>

            </div>
        </div>
    </div>
</div>
<%--<script type="text/javascript" src="lib/jqplot/jquery.jqplot.min.js"></script>
<script type="text/javascript" charset="utf-8" src="javascripts/graphDemo.js"></script>--%>

<script src="lib/bootstrap/js/bootstrap.js"></script>

</body>
</html>
