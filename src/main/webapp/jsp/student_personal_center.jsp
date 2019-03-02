<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/5/3
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Jumbotron Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/jumbotron.css" rel="stylesheet">
</head>

<body>
<!--导航栏-->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">导航栏</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <form class="form-inline my-2 my-lg-0">
            <a href="jumpPersonalCenter.action"  class="btn btn-outline-success my-2 my-sm-0">欢迎${sessionScope.get("username")}</a>
            &nbsp;
        </form>
        <a href="doLogout" class="btn btn-outline-success my-2 my-sm-0">退出</a>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <br/>
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="jumpPersonalInfo" target="mainbox">
                            <span data-feather="user"></span>
                            个人信息
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="jumpGradeTask" target="mainbox">
                            <span data-feather="file"></span>
                            查看成绩
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="queryClass" target="mainbox">
                            <span data-feather="search"></span>
                            加入一个班级
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="queryTask" target="mainbox">
                            <span data-feather="users"></span>
                            查看任务
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="studentQueryMistakes" target="mainbox">
                            <span data-feather="layers"></span>
                            错题集
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h1 class="h2">Dashboard</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group mr-2">
                        <button class="btn btn-sm btn-outline-secondary">Share</button>
                        <button class="btn btn-sm btn-outline-secondary">Export</button>
                    </div>
                    <button class="btn btn-sm btn-outline-secondary dropdown-toggle">
                        <span data-feather="calendar"></span>
                        This week
                    </button>
                </div>
            </div>

            <h2>Section title</h2>
            <div class="col-md-4" id="mainContent">
                <iframe id="mainboxId" name="mainbox" width="800px" height="800px" frameborder="0"></iframe>
            </div>
        </main>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<script src="resources/js/ajax.js"></script>

<!-- Icons -->
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
    feather.replace()
</script>
</body>
</html>
