<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/users/profile.css">
    <script src="/resources/js/users/profile.js"></script>
    <title>PL Center - 회원정보</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<jsp:include page="${sidebarPath}"/>

<div class="container-box">
    <div>
        <h1 class="text-center">PL Center - 회원정보</h1>
    </div>
    <br>
    <div>
        <p>개인정보보호를 위해 비밀번호를 입력해주세요.</p>
        <input class="form-control input-passwd" type="password" name="passwd" placeholder="비밀번호"/>
        <button class="btn btn-success btn-check-passwd" onclick="checkPasswd()">확인</button>
    </div>
</div>

</body>
</html>
