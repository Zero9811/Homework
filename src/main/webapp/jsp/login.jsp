<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/4/23
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="resources/img/favicon.ico">

    <title>login</title>
    <!--引用bootstrap的时候要在引用链接中跟上项目名称-->
    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/floating-labels.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <form class="form-signin" action="doLogin" method="post">
        <div class="text-center mb-4">
            <span data-feather="users"></span>
            <h1 class="h3 mb-3 font-weight-normal">English Homework</h1>
            <p>欢迎登陆我们的网站 <code>:placeholder-shown</code> pseudo-element. <a href="https://caniuse.com/#feat=css-placeholder-shown">Works in latest Chrome, Safari, and Firefox.</a></p>
        </div>
        <div class="form-label-group">
            <input type="text" id="inputEmail" class="form-control" name="username" placeholder="用户名" required autofocus>
            <label for="inputEmail">用户名</label>

        </div>

        <div class="form-label-group">
            <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
            <label for="inputPassword">Password</label>
        </div>
        <!--老师学生选择框-->
        <div class="checkbox mb-3">
            <label>
                <input type="radio" name="usertype" id="optionsRadios1" value="student" checked> 学生
            </label>
            <label>
                <input type="radio" name="usertype" id="optionsRadios2" value="teacher"> 老师
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <div class="text-center"><a href="jumpRegister" >        新申请一个账号</a></div>
        <p class="mt-5 mb-3 text-muted text-center">&copy; 2018</p>
    </form>
</div>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
    feather.replace()
</script>
</body>
</html>

