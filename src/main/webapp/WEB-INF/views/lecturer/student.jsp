<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/lecturer/student.css">
    <script src="/resources/js/lecturer/student.js"></script>
    <title>PL Center - 학생 설정</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/lecturer/sidebar.jsp" %>

<div class="container-box">
    <div class="div-class-filter">
        <select class="form-control" id="year"></select>
    </div>

    <div id="div-class-list"></div>
</div>

</body>
</html>
