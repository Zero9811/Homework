<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/6/24
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>personalInfo</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/jumbotron.css" rel="stylesheet">
</head>
<body>
    <div class="offset-2">
    <form class="form-group" action="modifyInfo" method="post">
        <div class="row">
            <label>姓名</label>
            <input class="form-control" type="text" name="name" placeholder="${info.name}">
        </div>
        <div class="row">
            <label>性别</label>
            <input class="form-control" type="text" name="gender" maxlength="1" placeholder="${info.gender}">
        </div>
        <div class="row">
            <label>年龄</label>
            <input class="form-control" type="number" name="age" placeholder="${info.age}">
        </div>
        <div>
            <button class="btn btn-primary" type="submit">提交</button>
        </div>
    </form>
    </div>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>window.jQuery || document.write('<script src="resources/js/jquery-3.3.1.min.js"><\/script>')</script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
