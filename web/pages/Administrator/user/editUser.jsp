<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wenmingbin
  Date: 2019/12/11
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>所有图书</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="../../../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../../css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="../../../css/theme.css">
    <link rel="stylesheet" href="../../../css/font-awesome.css">

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height: 300px;
            width: 800px;
            margin: 0px auto;
            margin-top: 1em;
        }

        .brand {
            font-family: georgia, serif;
        }

        .brand .first {
            color: #ccc;
            font-style: italic;
        }

        .brand .second {
            color: #fff;
            font-weight: bold;
        }

        #supplier {
            height: 30px;
            width: 600px;
        }

        #sub {
            height: 30px;
            width: 200px;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
</head>

<!--[if lt IE 7 ]>
<body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]>
<body class="ie ie7"> <![endif]-->
<!--[if IE 8 ]>
<body class="ie ie8"> <![endif]-->
<!--[if IE 9 ]>
<body class="ie ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
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


<div class="container-fluid">

    <div class="row-fluid">
        <div class="span3">
            <div class="sidebar-nav">
                <div class="nav-header" data-toggle="collapse" data-target="#dashboard-menu">用户管理</div>
                <ul id="dashboard-menu" class="nav nav-list collapse in">
                    <li><a href="index.jsp">主页</a></li>
                    <li><a href="BooksListServlet">用户列表</a></li>

                </ul>
                <div class="nav-header" data-toggle="collapse" data-target="#accounts-menu">资源管理</div>
                <ul id="accounts-menu" class="nav nav-list collapse in">
                    <li><a href="SysuserListSerclet">资源列表</a></li>

                </ul>

                <div class="nav-header" data-toggle="collapse" data-target="#settings-menu">帖子管理</div>
                <ul id="settings-menu" class="nav nav-list collapse in">
                    <li><a href="#">帖子列表</a></li>

                </ul>

            </div>
        </div>
        <div class="span9">
            <h1 class="page-title">图书列表</h1>
            <div class="btn-toolbar">
                <a href="add-books.jsp">
                    <button class="btn btn-primary"> 添加图书</button>
                </a>
                <div class="btn-group">
                </div>
            </div>
            <div class="well">
                <form action="${pageContext.request.contextPath}/UserEditServlet" method="post">
                    用户ID: </br>
                    &nbsp<input type="text" disabled name="no" id="supplier" value="${user.userId }"><br>
                    学号/教师编号: </br>
                    &nbsp<input type="text" name="userNo" id="supplier" value="${user.userNo }"><br>
                    姓名: <br>
                    &nbsp<input type="text" name="userName" id="supplier" value="${user.userName }"><br>
                    密码: <br>
                    &nbsp<input type="text" name="password" id="supplier" value="${user.password }"><br>
                    班级: <br>
                    &nbsp<input type="text" name="className" id="supplier" value="${user.className }"><br>
                    学生/老师: <br>
                    &nbsp<input type="text" name="isStu" id="supplier" value="${isStu }">
                    &nbsp<input type="hidden" name="userId" id="supplier" value="${user.userId }"><br>
                    &nbsp<input type="submit" value="提交" id="sub"><br>
                </form>
            </div>

            <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Delete Confirmation</h3>
                </div>
                <div class="modal-body">
                    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete
                        the user?</p>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">修改</button>
                    <button class="btn btn-danger" data-dismiss="modal">删除</button>
                </div>
            </div>

        </div>
    </div>


    <footer>
        <p>&copy; 2015 <a href="#">Portnine</a></p>
    </footer>
</div>


<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->


</body>
</html>

