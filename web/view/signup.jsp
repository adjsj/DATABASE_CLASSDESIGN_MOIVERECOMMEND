<%--
  Created by IntelliJ IDEA.
  User: zhanghesu
  Date: 2019/11/13
  Time: 4:29 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin for iMoive</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath}/docs/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/docs/examples/signin/signin.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/docs/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form class="form-signin" action="/UserservletRegist">
        <h2 class="form-signin-heading">Sign up</h2>
        <label for="username" class="sr-only">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Input your username····" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <label for="password1" class="sr-only">Password</label>
        <input type="password" id="password1" name="password1" class="form-control" placeholder="Please repeat password" required>
        <label for="phone_number" class="sr-only">Password</label>
        <input type="text" id="phone_number" name="phone_number" class="form-control" placeholder="Please input your phone number" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    </form>

</div>
<script src="${pageContext.request.contextPath}/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>