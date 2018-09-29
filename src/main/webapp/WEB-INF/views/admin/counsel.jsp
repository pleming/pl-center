<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/admin/counsel.css">
    <script src="/resources/js/admin/counsel.js"></script>
    <title>PL Center - 상담일지</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/admin/sidebar.jsp" %>

<div class="container-box">
    <div class="div-counsel-filter">
        <button class="btn btn-counsel-search" onclick="searchCounsel()">
            <i class="fa fa-search" aria-hidden="true"></i>
        </button>
        <button type="button" class="btn btn-danger" onclick="delCounsel()">- 상담일지 삭제</button>
        <input type="text" id="counsel-search" class="form-control counsel-filter-elem" placeholder="아이디, 학과, 학번, 이름 검색" />
        <select class="form-control counsel-filter-elem" id="class-no"></select>
        <select class="form-control counsel-filter-elem" id="semester"></select>
        <select class="form-control counsel-filter-elem" id="year"></select>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th><input type="checkbox" name="checkAll"/></th>
            <th>아이디</th>
            <th>단과대학</th>
            <th>학과</th>
            <th>학번</th>
            <th>분반</th>
            <th>이름</th>
            <th>상담일자</th>
            <th>상담내용</th>
            <th>상담자</th>
        </tr>
        </thead>
        <tbody id="counsel-row">
        </tbody>
    </table>
</div>

</body>
</html>
