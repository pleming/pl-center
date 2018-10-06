<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/notice/view.css">
    <script src="/resources/js/notice/view.js"></script>
    <title>PL Center - 공지사항</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<jsp:include page="${sidebarPath}"/>

<div class="container-box">
    <div class="post-container">
        <div class="div-post">
            <div class="card">
                <div class="card-header">
                    <span id="title"><b>멤버 변수가 배열인 경우</b></span>
                    <div class="text-right post-header">
                        <span id="write-datetime">2017.01.01. 00:00</span>
                    </div>
                </div>
                <div class="card-body">
                    <p id="post-writer"><i class="fa fa-user-circle-o" aria-hidden="true"></i><b> 밍밍(abc012)</b></p>
                    <div class="dropdown-divider"></div>
                    <div id="post-contents">
                        멤버 변수가 배열인 경우에는
                        그냥 쓰세요 -_-
                    </div>
                </div>
            </div>
        </div>
        <div class="div-notice-view-menu">
            <button type="button" class="btn btn-primary"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 글쓰기</button>
            <button type="button" class="btn btn-success" onclick="location.href='/notice/list'"><i class="fa fa-list" aria-hidden="true"></i> 목록</button>
        </div>
    </div>
</div>

<input type="hidden" name="notice-id" value="${noticeId}" />

</body>
</html>
