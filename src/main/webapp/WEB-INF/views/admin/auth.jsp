<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/admin/dashboard.css">
    <script src="/resources/js/admin/dashboard.js"></script>
    <title>PL Center - 관리자</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/admin/sidebar.jsp" %>

<div class="container-box">
    <div>
        <h1 class="text-center">계정 권한</h1>
    </div>
    <div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>아이디</th>
                <th>단과대학</th>
                <th>학과</th>
                <th>학번</th>
                <th>이름</th>
                <th>이메일</th>
                <th>휴대폰번호</th>
                <th>권한</th>
            </tr>
            </thead>
            <tbody id="student-row">
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
