<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/prof/class/add.css">
    <script src="/resources/js/prof/class/add.js"></script>
    <title>PL Center - 분반 추가</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/prof/sidebar.jsp" %>

<div class="container-box">
    <div class="div-class-add">
        <h1 class="text-center">분반 추가</h1>
        <br>
        <select class="form-control input-class-add" id="year"></select>
        <select class="form-control input-class-add" id="semester">
            <option value="1">1학기</option>
            <option value="2">2학기</option>
        </select>
        <select class="form-control input-class-add" id="class-no">
            <option value="1">1분반</option>
            <option value="2">2분반</option>
            <option value="3">3분반</option>
            <option value="4">4분반</option>
            <option value="5">5분반</option>
            <option value="6">6분반</option>
            <option value="7">7분반</option>
            <option value="8">8분반</option>
            <option value="9">9분반</option>
        </select>
        <button class="btn btn-primary btn-block btn-class-add input-account" onclick="classAdd()">추가</button>
    </div>
</div>

</body>
</html>
