<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/5/30
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Class list</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/jumbotron.css" rel="stylesheet">
</head>
<body>
    <c:forEach items="${class_list}" var="cl">
        <div class="col-md-4">
            <h2>Class : <c:out value="${cl.name}"></c:out>&nbsp;&nbsp;Teacher: <c:out value="${cl.teacherUsername}"></c:out></h2>
            <p>Description : <c:out value="${cl.overview}"></c:out> </p>
            <p><a class="btn btn-primary" href="joinClass?classId=${cl.id}" role="button">加入该班级 &raquo;</a></p>
        </div>
        <br/>
    </c:forEach>

    <script src="resources/js/jquery-3.3.1.min.js"></script>
    <script>window.jQuery || document.write('<script src="resources/js/jquery-3.3.1.min.js"><\/script>')</script>
    <script src="resources/js/popper.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
