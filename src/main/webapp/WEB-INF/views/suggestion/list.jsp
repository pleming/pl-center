<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/suggestion/list.css">
    <script src="/resources/js/suggestion/list.js"></script>
    <title>PL Center - 건의사항</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<jsp:include page="${sidebarPath}"/>

<div class="container-box">
    <div class="text-center">
        <h2><b>건의사항</b></h2>
    </div>
    <div class="div-suggestion-controller">
        <button class="btn btn-suggestion-search" onclick="searchSuggestion()">
            <i class="fa fa-search" aria-hidden="true"></i>
        </button>
        <input type="text" id="suggestion-search" class="form-control input-suggestion-search" placeholder="제목, 내용, 작성자 검색" />
        <button type="button" class="btn btn-success" onclick="location.href='/suggestion/add'">+ 글쓰기</button>
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
            <tbody id="suggestion-row">
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
