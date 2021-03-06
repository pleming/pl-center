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
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addCounselStudentModal">+ 상담일지 추가</button>
        <input type="text" id="counsel-search" class="form-control counsel-filter-elem" placeholder="아이디, 학과, 학번, 이름 검색" onkeypress="searchCounselEnterKey()"/>
        <select class="form-control counsel-filter-elem" id="class-no" onkeypress="searchCounselEnterKey()"></select>
        <select class="form-control counsel-filter-elem" id="semester" onkeypress="searchCounselEnterKey()"></select>
        <select class="form-control counsel-filter-elem" id="year" onkeypress="searchCounselEnterKey()"></select>
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

<div class="modal fade" id="addCounselStudentModal" tabindex="-1" role="dialog"
     aria-labelledby="addCounselStudentModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center">상담일지 추가</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="add-counsel-student-search" class="form-control"
                       placeholder="아이디, 학과, 학번, 이름 검색"/>
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
                <div>
                    <div class='div-counsel-info'>
                        <span>상담 날짜 : </span>
                        <i class="fa fa-calendar" aria-hidden="true"></i>
                        <input type="text" id="counsel-datepicker-modal" class="form-control counsel-picker-modal" />
                        <br>
                        <span>상담 시간 : </span>
                        <i class="fa fa-clock-o" aria-hidden="true"></i>
                        <input type="text" id="counsel-timepicker-modal" class="form-control counsel-picker-modal"/>
                    </div>
                    <div class="div-counselor-info">
                        <span>상담자 : </span>
                        <i class="fa fa-user" aria-hidden="true"></i>
                        <select class="form-control" id="counselor"></select>
                    </div>
                </div>
                <div class="dropdown-divider"></div>
                <input class="form-control input-counsel-contents" type="text" name="counsel-contents" placeholder="상담 내용"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary" onclick="addCounsel()">상담일지 추가</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
