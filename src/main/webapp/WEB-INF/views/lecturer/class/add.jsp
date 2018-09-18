<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/lecturer/class/add.css">
    <script src="/resources/js/lecturer/class/add.js"></script>
    <title>PL Center - 분반 추가</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/lecturer/sidebar.jsp" %>

<div class="container-box">
    <div class="div-class-add">
        <h1 class="text-center">분반 추가</h1>

        <br>

        <select class="form-control input-class-add" id="year"></select>
        <select class="form-control input-class-add" id="semester"></select>
        <select class="form-control input-class-add" id="class-no"></select>

        <button class="btn btn-primary btn-block btn-class-add input-class-add" onclick="addClassInfo()">추가</button>
    </div>
</div>

</body>
</html>
