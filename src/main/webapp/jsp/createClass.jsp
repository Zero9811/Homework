<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/5/5
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建新班级</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/floating-labels.css" rel="stylesheet">
</head>
<body>
    <form action="createClass" method="post">
        <div class="form-label-group">
            <input type="text" id="class_id" class="form-control" name="id" placeholder="班级ID" required autofocus>
            <label for="class_id">班级ID</label>
        </div>
        <div class="form-label-group">
            <input type="text" id="class_name" class="form-control" name="name" placeholder="班级名" required autofocus>
            <label for="class_name">班级名</label>
        </div>
        <div class="form-label-group">
            <input type="text" id="class_overview" class="form-control" name="overview" placeholder="班级描述" required autofocus>
            <label for="class_overview">班级描述</label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">创建</button>
    </form>

    <script src="resources/js/jquery-3.3.1.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
