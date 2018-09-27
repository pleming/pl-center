<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/worker/counsel.css">
    <script src="/resources/js/worker/counsel.js"></script>
    <title>PL Center - 상담일지</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/worker/sidebar.jsp" %>

<div class="container-box">
    <div class="div-counsel-filter">
        <button class="btn btn-counsel-search" onclick="searchCounsel()">
            <i class="fa fa-search" aria-hidden="true"></i>
        </button>
        <button type="button" class="btn btn-danger" onclick="delCounsel()">- 상담일지 삭제</button>
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addCounselStudentModal">+ 상담일지 등록</button>
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

<div class="modal fade" id="addCounselStudentModal" tabindex="-1" role="dialog" aria-labelledby="addCounselStudentModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center">상담일지 등록</h5>
                <button type="button" class="close" data-dismiss="modal" aira-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="add-counsel-student-search" class="form-control" placeholder="아이디, 학과, 학번, 이름 검색" />
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th><input type="checkbox" name="checkAll-modal"/></th>
                        <th>아이디</th>
                        <th>학과</th>
                        <th>학번</th>
                        <th>분반</th>
                        <th>이름</th>
                    </tr>
                    </thead>
                    <tbody id="student-row-modal"></tbody>
                </table>
                <div class="dropdown-divider"></div>
                <input class="form-control input-counsel-contents" type="text" name="counsel-contents" placeholder="상담 내용"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary" onclick="addCounsel()">상담일지 등록</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
