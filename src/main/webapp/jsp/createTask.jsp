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
    <title>创建任务</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/floating-labels.css" rel="stylesheet">
</head>
<body>
<form action="createTask" method="post">
    <div class="form-label-group">
        <input type="text" id="task_name" class="form-control" name="taskName" placeholder="请输入任务名" required autofocus>
        <label for="task_name">请输入任务名</label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">创建</button>
</form>

<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>

