<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/5/14
  Time: 22:14
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
<table class="table">
<c:forEach items="${task_list}" var="tl">
    <tr>
        <td><c:out value="${tl.taskName}"></c:out></td>
        <td><c:out value="${tl.teacherUsername}"></c:out> </td>
        <td><a href="jumpUpload?taskId=${tl.id}">上传作业</a></td>
        <td><a href="download?taskId=${tl.id}">下载作业</a></td>
        <td><a href="deleteTask?taskId=${tl.id}">删除任务</a></td>
    </tr>
    <br/>
</c:forEach>
</table>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>window.jQuery || document.write('<script src="resources/js/jquery-3.3.1.min.js"><\/script>')</script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
