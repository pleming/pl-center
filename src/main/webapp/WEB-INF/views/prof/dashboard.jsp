<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/prof/dashboard.css">
    <script src="/resources/js/prof/dashboard.js"></script>
    <script src="/resources/js/users/signout.js"></script>
    <title>PL Center - 교수</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/sidebar.jsp" %>

<div class="container-box">
    <h1>PL Center - 교수</h1>
    <button onclick="signout()">로그아웃</button>
</div>

</body>
</html>
