<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/users/signup.css">
    <script src="/resources/js/users/signup.js"></script>
    <title>PL Center - 회원가입</title>
</head>
<body>
<div class="container container-box">
    <div class="guide-box">
        <div class="div-signup">
            <h1 class="display-4 text-center">Sign Up</h1>
            <input class="form-control input-account" type="text" name="userId" placeholder="아이디"/>
            <input class="form-control input-account" type="password" name="passwd" placeholder="비밀번호"/>
            <input class="form-control input-account" type="password" name="chkPasswd" placeholder="비밀번호 확인"/>
            <select class="form-control input-account" id="col"></select>
            <select class="form-control input-account" id="dept"></select>
            <input class="form-control input-account" type="text" name="studentCode" placeholder="학번">
            <input class="form-control input-account" type="text" name="name" placeholder="이름"/>
            <input class="form-control input-account" type="text" name="email" placeholder="이메일"/>
            <input class="form-control input-account" type="text" name="phone" placeholder="휴대폰 번호"/>
            <button class="btn btn-primary btn-signup input-account" onclick="signup()">회원가입</button>
        </div>
    </div>
</div>
</body>
</html>
