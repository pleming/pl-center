<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/admin/auth.css">
    <script src="/resources/js/admin/auth.js"></script>
    <title>PL Center - 권한 설정</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/admin/sidebar.jsp" %>

<div class="container-box">
    <div class="text-center">
        <h2><b>권한 설정</b></h2>
    </div>
    <div class="div-auth-filter">
        <button class="btn btn-auth-search" onclick="searchAuth()">
            <i class="fa fa-search" aria-hidden="true"></i>
        </button>
        <input type="text" id="auth-search" class="form-control auth-filter-elem" placeholder="아이디, 학과, 학번, 이름 검색" onkeypress="authEnterKey()" />
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
    <div>
        <nav>
            <ul class="pagination justify-content-center">
                <li class='page-item disabled' id='prevFirst'><a class='page-link' href='#'>&laquo;</a></li>
                <li class='page-item disabled' id='prev'><a class='page-link' href='#'>&lsaquo;</a></li>
                <li class='page-item' id='next'><a class='page-link' href='#'>&rsaquo;</a></li>
                <li class='page-item' id='nextEnd'><a class='page-link' href='#'>&raquo;</a></li>
            </ul>
        </nav>
    </div>
</div>

</body>
</html>
