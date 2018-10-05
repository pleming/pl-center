<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/admin/dept.css">
    <script src="/resources/js/admin/dept.js"></script>
    <title>PL Center - 학과</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/admin/sidebar.jsp" %>

<div class="container-box">
    <div class="div-dept-controller">
        <button type="button" class="btn btn-danger" onclick="delDept()">- 학과 삭제</button>
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addDeptModal">+ 학과 추가</button>
        <div>
            <select class="form-control select-college" id="college"></select>
        </div>
    </div>
    <table class="table table-striped table-hover table-dept">
        <thead>
        <tr>
            <th><input type="checkbox" name="checkAll"/></th>
            <th>#</th>
            <th>학과</th>
        </tr>
        </thead>
        <tbody id="dept-row">
        </tbody>
    </table>
</div>

<div class="modal fade" id="addDeptModal" tabindex="-1" role="dialog" aria-labelledby="addDeptModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center">학과 추가</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>학과는 특정 단과대학에 포함됩니다. 단과대학을 선택해주세요.</p>
                <select class="form-control select-college-modal" id="college-modal"></select>
                <input type="text" name="dept" class="form-control" placeholder="학과 이름"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary" onclick="addDept()">학과 추가</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
