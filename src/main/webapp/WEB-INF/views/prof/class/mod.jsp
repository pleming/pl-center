<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/prof/class/mod.css">
    <script src="/resources/js/prof/class/mod.js"></script>
    <title>PL Center - 분반 수정</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/prof/sidebar.jsp" %>

<div class="container-box">
    <div class="div-class-mod">
        <h1 class="text-center">분반 수정</h1>

        <br>

        <select class="form-control input-class-mod" id="year"></select>
        <select class="form-control input-class-mod" id="semester"></select>
        <select class="form-control input-class-mod" id="class-no"></select>

        <button class="btn btn-primary btn-block btn-class-mod input-class-mod" onclick="modClassInfo()">수정</button>
    </div>
</div>

<input type="hidden" name="class-id" value="${classId}" />

</body>
</html>
