<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/5/29
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadFile</title>
</head>
<body>
    <form action="upload?taskId=${taskId}" method="post" enctype="multipart/form-data">
        选择上传文件：<input type = "file" name = "file">
        <input type="submit" name="上传">
    </form>
</body>
</html>
