<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/admin/workingDiary.css">
    <script src="/resources/js/admin/workingDiary.js"></script>
    <title>PL Center - 근무일지</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/admin/sidebar.jsp" %>

<div class="container-box">
    <div class="div-working-diary-filter">
        <button type="button" class="btn btn-danger" onclick="delWorkingDiary()">- 근무일지 삭제</button>
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addWorkingDiaryModal">+ 근무일지 추가</button>
        <button class="btn btn-working-diary-search" onclick="searchWorkingDiary()">
            <i class="fa fa-search" aria-hidden="true"></i>
        </button>
        <input type="text" id="working-diary-search" class="form-control working-diary-filter-elem" placeholder="아이디, 학과, 학번, 이름 검색" />
        <div class="div-working-diary-filter-calendar">
            <input type="text" id="working-diary-end-datepicker" class="form-control" />
            <span>~</span>
            <input type="text" id="working-diary-start-datepicker" class="form-control" />
            <i class="fa fa-calendar working-diary-filter-elem" aria-hidden="true"></i>
        </div>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th><input type="checkbox" name="checkAll"/></th>
            <th>아이디</th>
            <th>단과대학</th>
            <th>학과</th>
            <th>학번</th>
            <th>이름</th>
            <th>근무시간</th>
            <th>근무내용</th>
        </tr>
        </thead>
        <tbody id="working-diary-row">
        </tbody>
    </table>
</div>

<div class="modal fade" id="addWorkingDiaryModal" tabindex="-1" role="dialog" aria-labelledby="addWorkingDiaryModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center">근무일지 추가</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="add-working-diary-student-search" class="form-control" placeholder="아이디, 학과, 학번, 이름 검색" />
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th><input type="checkbox" name="checkAll-modal"/></th>
                        <th>아이디</th>
                        <th>학과</th>
                        <th>학번</th>
                        <th>이름</th>
                    </tr>
                    </thead>
                    <tbody id="student-row-modal"></tbody>
                </table>
                <div class="dropdown-divider"></div>
                <div class="div-working-diary-info">
                    <span>근무 시작 시간 : </span>
                    <i class="fa fa-calendar" aria-hidden="true"></i>
                    <input type="text" id="working-diary-start-datepicker-modal" class="form-control working-diary-picker-modal" />
                    <i class="fa fa-clock-o" aria-hidden="true"></i>
                    <input type="text" id="working-diary-start-timepicker-modal" class="form-control working-diary-picker-modal"/>
                    <br>
                    <span>근무 종료 시간 : </span>
                    <i class="fa fa-calendar" aria-hidden="true"></i>
                    <input type="text" id="working-diary-end-datepicker-modal" class="form-control working-diary-picker-modal" />
                    <i class="fa fa-clock-o" aria-hidden="true"></i>
                    <input type="text" id="working-diary-end-timepicker-modal" class="form-control working-diary-picker-modal" />
                    <input class="form-control input-working-contents" type="text" name="working-contents" placeholder="근무 내용"/>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary" onclick="addWorkingDiary()">근무일지 추가</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
