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
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addCounselStudentModal">+ 상담일지 추가</button>
        <input type="text" id="counsel-search" class="form-control counsel-filter-elem" placeholder="아이디, 학과, 학번, 이름 검색" onkeypress="searchCounselEnterKey()"/>
        <select class="form-control counsel-filter-elem" id="class-no" onkeypress="searchCounselEnterKey()"></select>
        <select class="form-control counsel-filter-elem" id="semester" onkeypress="searchCounselEnterKey()"></select>
        <select class="form-control counsel-filter-elem" id="year" onkeypress="searchCounselEnterKey()"></select>
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
                <div class="div-pl-certificated">
                    <div class='card card-pl-certificated'>
                        <div class='card-header text-center'>프로그래밍언어지원센터 상담확인증</div>
                        <div class='card-body'>
                            <div class='div-student-info'>
                                <span id='student-code'></span><br>
                                <span id='dept'></span><br>
                                <span id='class-div'></span><br>
                                <span id='student-name'></span><br>
                            </div>
                            <div class='div-student-info-header'>
                                <div>
                                    학번 : <br>
                                    학과 : <br>
                                    분반 : <br>
                                    이름 : <br>
                                </div>
                            </div>
                            <div class='div-pl-certificated-contents text-center'>
                                <p class='card-text'>위 학생은 <span id='pl-certificated-year'></span>학년도 <span
                                        id='pl-certificated-semester'></span>학기 프로그래밍 언어
                                    <br>
                                    지원센터를 이용하였음을 확인합니다.
                                    <br><br>
                                    * 여러 명일 경우 대표자 1명만 화면에 표시됩니다만,<br>
                                    실제로는 모두가 등록됩니다.
                                </p>
                                <p>
                                    <span id='counsel-datetime'></span>
                                </p>
                            </div>
                            <div class='div-pl-certificated-counselor'>
                                <p>
                                    상담내용 : <span id='counsel-contents'></span><br>
                                    상담자 : <span id='counselor-name'>${sessionInfo.name}</span>
                                </p>
                            </div>
                        </div>
                        <div class='card-footer text-center'>PL Center Certificated.</div>
                    </div>
                </div>
                <div class="dropdown-divider"></div>
                <input class="form-control input-counsel-contents" type="text" name="counsel-contents"
                       placeholder="상담 내용"/>
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
