<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/worker/workingDiary.css">
    <script src="/resources/js/worker/workingDiary.js"></script>
    <title>PL Center - 상담일지</title>
</head>

<%@ include file="/resources/jsp/navbar.jsp" %>
<%@ include file="/resources/jsp/worker/sidebar.jsp" %>

<div class="container-box">
    <div class="div-working-diary-calendar">
        <div id="working-diary-calendar"></div>
    </div>
    <div class="div-attendance">
        <p>출근 도장을 찍습니다.</p>
        <p>
            시작 시간은 현재 시간을 기준으로 설정되고, 종료 시간은 근무자가 직접 입력합니다.
            <br>
            기타 이유(상담자 과다 등)로 출근 도장을 늦게 찍을 때를 대비하여 출근 시간의 분은 제거됩니다.
            <br>
            즉, 출근 도장에는 한 시간의 여유가 있습니다.
            <br>
            이를 지키지 못하면 지각입니다.
        </p>
        <p>
            근무 종료 시간이나 근무 내용 입력을 잘못해서 수정하고 싶은 경우에는 관리자에게 문의해주세요.
        </p>
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#attendWorkerModal"><i class="fa fa-check-square-o" aria-hidden="true"></i> 출근 도장 찍기</button>
    </div>
</div>

<div class="modal fade" id="attendWorkerModal" tabindex="-1" role="dialog" aria-labelledby="attendWorkerModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center">출근 도장 찍기</h5>
                <button type="button" class="close" data-dismiss="modal" aira-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="div-attend-worker-settings">
                    <i class="fa fa-clock-o" aria-hidden="true"></i>
                    <span>근무 시작 시간 : <span class="span-working-start-datetime"></span></span>
                    <br>
                    <i class="fa fa-clock-o" aria-hidden="true"></i>
                    <span>근무 종료 시간</span>
                    <input type="text" id="working-end-timepicker" />
                </div>
                <input type="text" id="working-contents" class="form-control" placeholder="근무 내용" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary" onclick="attendWorker()">출근 완료</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>