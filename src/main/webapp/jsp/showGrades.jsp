<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/6/22
  Time: 21:20
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
        <tr>
            <td>学生</td>
            <td>总成绩</td>
            <td>单选</td>
            <td>完型</td>
            <td>阅读</td>
            <td>改错</td>
            <td>作文</td>
        </tr>
        <c:forEach items="${grades_list}" var="gl">
            <tr>
                <td><c:out value="${gl.studentUsername}"/></td>
                <td><c:out value="${gl.grade}"/></td>
                <td><c:out value="${gl.multipleChoice}"/></td>
                <td><c:out value="${gl.clozeTest}"/></td>
                <td><c:out value="${gl.readingComprehension}"/></td>
                <td><c:out value="${gl.errorCorrection}"/></td>
                <td><c:out value="${gl.composition}"/></td>
            </tr>
        </c:forEach>
    </table>

<script src="resources/js/jquery-3.3.1.min.js"></script>
<script>window.jQuery || document.write('<script src="resources/js/jquery-3.3.1.min.js"><\/script>')</script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
