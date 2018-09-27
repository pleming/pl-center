<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/users/signin.css">
    <script src="/resources/js/users/signin.js"></script>
    <title>PL Center - 로그인</title>
</head>
<body>
<div class="container container-box">
    <div class="guide-box">
        <div class="div-signin">
            <h1 class="display-4">PL Center</h1>
            <input class="form-control input-account" type="text" name="userId" placeholder="아이디"/>
            <input class="form-control input-account" type="password" name="passwd" placeholder="비밀번호" onkeypress="signinEnterKey()"/>
            <button class="btn btn-primary btn-signin input-account" onclick="signin()">로그인</button>
            <div class="dropdown-divider"></div>
            <p class="text-center">New to PL Center <a href="/users/signup">Craete an account.</a></p>
        </div>
    </div>
</div>
</body>
</html>
