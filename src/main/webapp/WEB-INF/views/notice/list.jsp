<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

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
    <div class="div-notice-controller">
        <button type="button" class="btn btn-success">+ 글쓰기</button>
    </div>
    <div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
            </thead>
            <tbody id="notice-row">
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
