<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/6/22
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/jumbotron.css" rel="stylesheet">
</head>
<body>
    <form class="form-group" action="addGrade">
        <div class="row offset-3">
            <input type="hidden" name="taskId" value="${taskId}">
            学生：
            <input type="text" class="form-control" name="studentUsername">
            单选：
            <input type="number" class="form-control" name="multipleChoice">
            完型：
            <input class="form-control" type="number" name="clozeTest">
            阅读:
            <input class="form-control" type="number" name="readingComprehension">
            改错：
            <input class="form-control" type="number" name="errorCorrection">
            作文：
            <input class="form-control" type="number" name="composition">

        </div>
        <button type="submit" class="btn btn-default offset-6">Submit</button>
    </form>

<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>window.jQuery || document.write('<script src="resources/js/jquery-3.3.1.min.js"><\/script>')</script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
