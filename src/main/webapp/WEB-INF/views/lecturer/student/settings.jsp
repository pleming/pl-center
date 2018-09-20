<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/lecturer/student/settings.css">
    <script src="/resources/js/lecturer/student/settings.js"></script>
    <title>PL Center - 학생 설정</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/lecturer/sidebar.jsp" %>

<div class="container-box">
    <div>
        <h1 class="text-center">${title}</h1>
    </div>
    <div>
        <button type="button" class="btn btn-danger btn-del-student" onclick="delStudent()">- 학생 삭제</button>
        <button type="button" class="btn btn-success btn-add-student" data-toggle="modal" data-target="#addStudentModal">+ 학생 추가</button>
    </div>
    <div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th><input type="checkbox" name="checkAll"/></th>
                <th>아이디</th>
                <th>단과대학</th>
                <th>학과</th>
                <th>학번</th>
                <th>이름</th>
                <th>이메일</th>
                <th>휴대폰번호</th>
            </tr>
            </thead>
            <tbody id="student-row"></tbody>
        </table>
    </div>
</div>

<div class="modal fade" id="addStudentModal" tabindex="-1" role="dialog" aria-labelledby="addStudentModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center">학생 추가</h5>
                <button type="button" class="close" data-dismiss="modal" aira-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="add-student-search" class="form-control" placeholder="아이디, 학과, 학번, 이름 검색" />
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th><input type="checkbox" name="checkAll"/></th>
                        <th>아이디</th>
                        <th>학과</th>
                        <th>학번</th>
                        <th>이름</th>
                    </tr>
                    </thead>
                    <tbody id="student-row-modal"></tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary" onclick="addStudent()">학생 추가</button>
            </div>
        </div>
    </div>
</div>

<input type="hidden" name="class-id" value="${classId}" />

</body>
</html>
