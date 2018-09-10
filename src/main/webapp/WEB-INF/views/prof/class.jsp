<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/prof/class.css">
    <script src="/resources/js/prof/class.js"></script>
    <title>PL Center - 분반 설정</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/prof/sidebar.jsp" %>

<div class="container-box">
    <div class="div-class-add">
        <button class="btn btn-outline-success btn-block" onclick="location.href='/prof/class/add'">+ 분반 추가</button>
    </div>
    <div id="div-class-list"></div>
</div>

</body>
</html>