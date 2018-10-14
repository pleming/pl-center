<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/users/profileUser.css">
    <script src="/resources/js/users/profileUser.js"></script>
    <title>PL Center - 회원정보</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<jsp:include page="${sidebarPath}"/>

<div class="container-box">
    <div>
        <h1 class="text-center">PL Center - 회원정보</h1>
    </div>
    <br>
    <div class="guide-box">
        <div class="div-user-info-update">
            <h1 class="display-4 text-center">Sign Up</h1>
            <input class="form-control input-account" type="text" name="userId" placeholder="아이디" disabled/>
            <input class="form-control input-account" type="password" name="passwd" placeholder="비밀번호"/>
            <input class="form-control input-account" type="password" name="chkPasswd" placeholder="비밀번호 확인"/>
            <select class="form-control input-account" id="col"></select>
            <select class="form-control input-account" id="dept"></select>
            <input class="form-control input-account" type="text" name="studentCode" placeholder="학번">
            <input class="form-control input-account" type="text" name="name" placeholder="이름"/>
            <input class="form-control input-account" type="text" name="email" placeholder="이메일"/>
            <input class="form-control input-account" type="text" name="phone" placeholder="휴대폰 번호"/>
            <button class="btn btn-primary btn-user-info-update input-account" onclick="updateUserInfo()">변경</button>
        </div>
    </div>
</div>

</body>
</html>
