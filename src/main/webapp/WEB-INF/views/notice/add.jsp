<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/notice/add.css">
    <script src="/resources/js/notice/add.js"></script>
    <title>PL Center - 공지사항</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<jsp:include page="${sidebarPath}"/>

<div class="container-box">
    <div class="div-editor-header">
        <input class="form-control" type="text" name="title" placeholder="게시글 제목" />
    </div>
    <div class="editor-container">
        <textarea id="post-editor"></textarea>
    </div>
    <div class="div-editor-footer">
        <button type="button" class="btn btn-success" onclick="addNotice()"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 작성완료</button>
        <button type="button" class="btn btn-danger" onclick="cancelNotice()"><i class="fa fa-ban" aria-hidden="true"></i> 작성취소</button>
    </div>
</div>

<input type="file" name="imageFile" id="image-upload" />

</body>
</html>
