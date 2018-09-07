<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/student/dashboard.css">
    <script src="/resources/js/student/dashboard.js"></script>
    <script src="/resources/js/users/signout.js"></script>
    <title>PL Center - 학생</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/admin/sidebar.jsp" %>

<div class="container-box">
    <h1>PL Center - 학생</h1>
    <button onclick="signout()">로그아웃</button>
</div>

</body>
</html>
