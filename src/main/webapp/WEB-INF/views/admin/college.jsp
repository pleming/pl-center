<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/admin/college.css">
    <script src="/resources/js/admin/college.js"></script>
    <title>PL Center - 단과대학</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/admin/sidebar.jsp" %>

<div class="container-box">
    <div class="div-college-controller">
        <button type="button" class="btn btn-danger" onclick="delCollege()">- 단과대학 삭제</button>
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addCollegeModal">+ 단과대학 추가</button>
    </div>
    <table class="table table-striped table-hover table-college">
        <thead>
        <tr>
            <th><input type="checkbox" name="checkAll"/></th>
            <th>#</th>
            <th>단과대학</th>
        </tr>
        </thead>
        <tbody id="college-row">
        </tbody>
    </table>
</div>

<div class="modal fade" id="addCollegeModal" tabindex="-1" role="dialog" aria-labelledby="addCollegeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center">단과대학 추가</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" name="college" class="form-control" placeholder="단과대학 이름"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary" onclick="addCollege()">단과대학 추가</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
