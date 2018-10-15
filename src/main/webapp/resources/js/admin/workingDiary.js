$(document).ready(function () {
    $ajax.request({
        url: "/admin/loadWorkingDiary",
        method: "GET"
    }, function (err, res) {
        if (err) {
            alert("근무일지 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var workingDiaryList = res.contents;

        for (var i = 0; i < workingDiaryList.length; i++) {
            $("tbody#working-diary-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='working-diary-id' value='" + workingDiaryList[i].workingDiaryId + "'/></td>" +
                "<td class='user-id'>" + workingDiaryList[i].userId + "</td>" +
                "<td class='college'>" + workingDiaryList[i].college + "</td>" +
                "<td class='dept'>" + workingDiaryList[i].dept + "</td>" +
                "<td class='student-code'>" + workingDiaryList[i].studentCode + "</td>" +
                "<td class='name'>" + workingDiaryList[i].name + "</td>" +
                "<td class='working-datetime'>" + new Date(workingDiaryList[i].workingStartDatetime).format("yyyy-MM-dd HH:mm") + "~" + new Date(workingDiaryList[i].workingEndDatetime).format("HH:mm") + "</td>" +
                "<td class='working-contents'>" + workingDiaryList[i].workingContents + "</td>" +
                "</tr>"
            );
        }
    });

    var datepickerInitInfo = {
        dateFormat: "yy-mm-dd",
        dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
        monthNames: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
    };

    var timepickerInitInfo = {
        timeFormat: "HH:mm",
        interval: 60,
        startTime: "00:00",
        maxTime: "23:00",
        defaultTime: new Date().format("HH"),
        dynamic: false,
        scrollbar: true
    };

    $("#working-diary-start-datepicker").datepicker(datepickerInitInfo);
    $("#working-diary-end-datepicker").datepicker(datepickerInitInfo);

    $("input[name=checkAll]").change(function () {
        if ($(this).prop("checked"))
            $("tbody#working-diary-row input[name=working-diary-id]").prop("checked", true);
        else
            $("tbody#working-diary-row input[name=working-diary-id]").prop("checked", false);
    });

    $("input[name=checkAll-modal]").change(function () {
        if ($(this).prop("checked"))
            $("tbody#student-row-modal input[name=user-code]").prop("checked", true);
        else
            $("tbody#student-row-modal input[name=user-code]").prop("checked", false);
    });

    $("#addWorkingDiaryModal").on("show.bs.modal", function (event) {
        $("#working-diary-start-datepicker-modal").datepicker(datepickerInitInfo);
        $("#working-diary-end-datepicker-modal").datepicker(datepickerInitInfo);

        $("#working-diary-start-timepicker-modal").timepicker(timepickerInitInfo);
        $("#working-diary-end-timepicker-modal").timepicker(timepickerInitInfo);

        $("tbody#student-row-modal").html("");
        $("input#add-working-diary-student-search").val("");

        $("tbody#student-row-modal").append(
            "<tr>" +
            "<td><input type='checkbox' name='user-code' value='-1'/></td>" +
            "<td class='user-id'></td>" +
            "<td class='dept'></td>" +
            "<td class='student-code'>검색 결과가 존재하지 않습니다.</td>" +
            "<td class='name'></td>" +
            "</tr>"
        );
    });

    $("input#add-working-diary-student-search").change(function () {
        addWorkingDiaryStudentSearch();
    });
});

var searchWorkingDiary = function () {
    var data = {
        workingDiarySearchStartDate: new Date($("input#working-diary-start-datepicker").val()).format("yyyy-MM-dd") + " 00:00:00",
        workingDiarySearchEndDate: new Date($("input#working-diary-end-datepicker").val()).format("yyyy-MM-dd") + " 23:59:59",
        searchKey: $("input#working-diary-search").val()
    };

    if (data.workingDiarySearchStartDate == "  00:00:00")
        data.workingDiarySearchStartDate = null;

    if (data.workingDiarySearchEndDate == "  23:59:59")
        data.workingDiarySearchEndDate = null;

    $ajax.request({
        url: "/admin/searchWorkingDiary",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("근무일지 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var workingDiaryList = res.contents;

        $("tbody#working-diary-row").html("");

        if (workingDiaryList.length == 0) {
            $("tbody#working-diary-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='working-diary-id' value='" + workingDiaryList[i].workingDiaryId + "'/></td>" +
                "<td class='user-id'></td>" +
                "<td class='college'></td>" +
                "<td class='dept'></td>" +
                "<td class='student-code'>검색 결과가 존재하지 않습니다.</td>" +
                "<td class='name'></td>" +
                "<td class='working-datetime'></td>" +
                "<td class='working-contents'></td>" +
                "</tr>"
            );
            return;
        }

        for (var i = 0; i < workingDiaryList.length; i++) {
            $("tbody#working-diary-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='working-diary-id' value='" + workingDiaryList[i].workingDiaryId + "'/></td>" +
                "<td class='user-id'>" + workingDiaryList[i].userId + "</td>" +
                "<td class='college'>" + workingDiaryList[i].college + "</td>" +
                "<td class='dept'>" + workingDiaryList[i].dept + "</td>" +
                "<td class='student-code'>" + workingDiaryList[i].studentCode + "</td>" +
                "<td class='name'>" + workingDiaryList[i].name + "</td>" +
                "<td class='working-datetime'>" + new Date(workingDiaryList[i].workingStartDatetime).format("yyyy-MM-dd HH:mm") + "~" + new Date(workingDiaryList[i].workingEndDatetime).format("HH:mm") + "</td>" +
                "<td class='working-contents'>" + workingDiaryList[i].workingContents + "</td>" +
                "</tr>"
            );
        }
    });
};

var listAllWorkingDiary = function () {
    $ajax.request({
        url: "/admin/loadWorkingDiary",
        method: "GET"
    }, function (err, res) {
        if (err) {
            alert("근무일지 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var workingDiaryList = res.contents;

        $("tbody#working-diary-row").html("");

        for (var i = 0; i < workingDiaryList.length; i++) {
            $("tbody#working-diary-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='working-diary-id' value='" + workingDiaryList[i].workingDiaryId + "'/></td>" +
                "<td class='user-id'>" + workingDiaryList[i].userId + "</td>" +
                "<td class='college'>" + workingDiaryList[i].college + "</td>" +
                "<td class='dept'>" + workingDiaryList[i].dept + "</td>" +
                "<td class='student-code'>" + workingDiaryList[i].studentCode + "</td>" +
                "<td class='name'>" + workingDiaryList[i].name + "</td>" +
                "<td class='working-datetime'>" + new Date(workingDiaryList[i].workingStartDatetime).format("yyyy-MM-dd HH:mm") + "~" + new Date(workingDiaryList[i].workingEndDatetime).format("HH:mm") + "</td>" +
                "<td class='working-contents'>" + workingDiaryList[i].workingContents + "</td>" +
                "</tr>"
            );
        }
    });
};

var addWorkingDiaryStudentSearch = function () {
    var data = {
        requireClassInfo: false,
        searchKey: $("input#add-working-diary-student-search").val()
    };

    $ajax.request({
        url: "/admin/loadStudentForAdmin",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("학생 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var userList = res.contents;

        $("tbody#student-row-modal").html("");

        if (userList.length == 0) {
            $("tbody#student-row-modal").append(
                "<tr>" +
                "<td><input type='checkbox' name='user-code' value='-1'/></td>" +
                "<td class='user-id'></td>" +
                "<td class='dept'></td>" +
                "<td class='student-code'>검색 결과가 존재하지 않습니다.</td>" +
                "<td class='name'></td>" +
                "</tr>"
            );
            return;
        }

        for (var i = 0; i < userList.length; i++) {
            $("tbody#student-row-modal").append(
                "<tr>" +
                "<td><input type='checkbox' name='user-code' value='" + userList[i].userCode + "'/></td>" +
                "<td class='user-id'>" + userList[i].userId + "</td>" +
                "<td class='dept'>" + userList[i].dept + "</td>" +
                "<td class='student-code'>" + userList[i].studentCode + "</td>" +
                "<td class='name'>" + userList[i].name + "</td>" +
                "</tr>"
            );
        }
    });
};

var addWorkingDiary = function () {
    if (!confirm("근무일지를 추가하시겠습니까?"))
        return;

    var data = {
        workingDiaryAddList: []
    };

    $("tbody#student-row-modal input[name=user-code]:checked").each(function () {
        var __data = {
            userCode: $(this).val(),
            workingStartDatetime: new Date($("#working-diary-start-datepicker-modal").val() + " " + $("#working-diary-start-timepicker-modal").val() + ":00"),
            workingEndDatetime: new Date($("#working-diary-end-datepicker-modal").val() + " " + $("#working-diary-end-timepicker-modal").val() + ":00"),
            workingContents: $("input[name=working-contents]").val()
        };

        data.workingDiaryAddList.push(__data);
    });

    $ajax.request({
        url: "/admin/addWorkingDiary",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("근무일지 추가를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert(res.contents);
        location.reload();
    });
};

var delWorkingDiary = function () {
    if (!confirm("선택한 근무일지를 삭제하시겠습니까?\nPL Center 감사 등의 이유로 근무일지의 유지가 필요합니다.\n정확한 근무일지를 선택했는지 확인해주세요."))
        return;

    var data = {
        idList: []
    };

    $("tbody#working-diary-row input[name=working-diary-id]:checked").each(function () {
        data.idList.push(Number($(this).val()));
    });

    $ajax.request({
        url: "/admin/delWorkingDiary",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("근무일지 삭제를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert(res.contents);
        location.reload();
    });
};

var searchWorkingDiaryEnterKey = function () {
    if (event.keyCode  == 13)
        searchWorkingDiary();
};