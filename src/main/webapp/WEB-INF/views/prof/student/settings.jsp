<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/prof/student/settings.css">
    <script src="/resources/js/prof/student/settings.js"></script>
    <title>PL Center - 학생 설정</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/prof/sidebar.jsp" %>

<div class="container-box">
    <div>
        <h1 class="text-center">${title}</h1>
    </div>
    <div>
        <button type="button" class="btn btn-danger btn-del-student" onclick="delStudent()">- 학생 삭제</button>
        <button type="button" class="btn btn-success btn-add-student">+ 학생 추가</button>
    </div>
    <div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>선택</th>
                <th>#</th>
                <th>아이디</th>
                <th>단과대학</th>
                <th>학과</th>
                <th>학번</th>
                <th>이름</th>
                <th>이메일</th>
                <th>휴대폰번호</th>
            </tr>
            </thead>
            <tbody id="student-row">
            </tbody>
        </table>
    </div>
</div>

<input type="hidden" name="class-id" value="${classId}" />

</body>
</html>
