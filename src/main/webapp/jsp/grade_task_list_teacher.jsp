<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/6/16
  Time: 14:49
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
            <td><a href="jumpGradesAdd?taskId=${tl.id}" target="mainbox">登记成绩</a></td>
            <td><a href="showGrades?taskId=${tl.id}" target="mainbox">查看成绩</a></td>
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
