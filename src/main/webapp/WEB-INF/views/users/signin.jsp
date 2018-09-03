<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <script src="/resources/js/users/signin.js"></script>
    <title>PL Center - 로그인</title>
</head>
<body>
<div>
    <label>아이디 </label>
    <input type="text" name="userId"/>
</div>
<div>
    <label>비밀번호 </label>
    <input type="password" name="passwd"/>
</div>
<div>
    <button onclick="signin()">로그인</button>
</div>
</body>
</html>
