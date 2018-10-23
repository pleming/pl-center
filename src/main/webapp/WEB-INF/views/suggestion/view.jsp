<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/suggestion/view.css">
    <script src="/resources/js/suggestion/view.js"></script>
    <title>PL Center - 건의사항</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<jsp:include page="${sidebarPath}"/>

<div class="container-box">
    <div class="post-container">
        <div class="div-post">
            <div class="card">
                <div class="card-header">
                    <span id="title"><b></b></span>
                    <div class="text-right post-header">
                        <span id="write-datetime"></span>
                        <c:if test="${isExistAuth eq true}">
                            <span> | </span>
                            <a href="/suggestion/mod/${suggestionId}">수정</a></span>
                            <span> | </span>
                            <span class="span-del" onclick="delSuggestion()">삭제</span>
                        </c:if>
                    </div>
                </div>
                <div class="card-body">
                    <p id="post-writer"><i class="fa fa-user-circle-o" aria-hidden="true"></i><b></b></p>
                    <div class="dropdown-divider"></div>
                    <div id="post-contents"></div>
                </div>
                <div class="card-footer">
                    <div class="div-comment-writebox">
                        <textarea class="form-control" id="comment"></textarea>
                        <button class="form-control btn-comment-regist" onclick="addComment()">등록</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="div-post-view-menu">
            <button type="button" class="btn btn-primary" onclick="location.href='/suggestion/add'"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 글쓰기</button>
            <button type="button" class="btn btn-success" onclick="location.href='/suggestion/list'"><i class="fa fa-list" aria-hidden="true"></i> 목록</button>
        </div>
    </div>
</div>

<input type="hidden" name="suggestion-id" value="${suggestionId}" />

</body>
</html>
