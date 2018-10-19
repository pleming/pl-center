<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/notice/list.css">
    <script src="/resources/js/notice/list.js"></script>
    <title>PL Center - 공지사항</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<jsp:include page="${sidebarPath}"/>

<div class="container-box">
    <div class="text-center">
        <h2><b>공지사항</b></h2>
    </div>
    <div class="div-notice-controller">
        <button class="btn btn-notice-search" onclick="searchNotice()">
            <i class="fa fa-search" aria-hidden="true"></i>
        </button>
        <input type="text" id="notice-search" class="form-control input-notice-search" placeholder="제목, 내용, 작성자 검색" onkeypress="searchNoticeEnterKey()" />
        <c:if test="${isAdmin eq true}">
            <button type="button" class="btn btn-success" onclick="location.href='/notice/add'">+ 글쓰기</button>
        </c:if>
    </div>
    <div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th class="width-no">#</th>
                <th class="width-title">제목</th>
                <th class="width-writer">작성자</th>
                <th class="width-date">작성일</th>
                <th class="width-views">조회수</th>
            </tr>
            </thead>
            <tbody id="notice-row">
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
