$(document).ready(function () {
    var data = {
        pagingInfo: {
            nowPage: 1
        }
    };

    $ajax.pagingRequest({
        url: "/counsel/loadCounsel",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("상담일지 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var counselList = res.contents.counselList;
        var pagingInfo = res.pagingInfo;

        for (var i = 0; i < counselList.length; i++) {
            $("tbody#counsel-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='counsel-id' value='" + counselList[i].counselId + "'/></td>" +
                "<td class='user-id'>" + counselList[i].userId + "</td>" +
                "<td class='college'>" + counselList[i].college + "</td>" +
                "<td class='dept'>" + counselList[i].dept + "</td>" +
                "<td class='student-code'>" + counselList[i].studentCode + "</td>" +
                "<td class='class-div'>" + counselList[i].year + "-" + counselList[i].semester + "(0" + counselList[i].classNo + ")</td>" +
                "<td class='name'>" + counselList[i].name + "</td>" +
                "<td class='counsel-datetime'>" + new Date(counselList[i].counselDatetime).format("yyyy-MM-dd HH:mm:ss") + "</td>" +
                "<td class='counsel-contents'>" + counselList[i].counselContents + "</td>" +
                "<td class='counselor-name'>" + counselList[i].counselorName + "</td>" +
                "</tr>"
            );
        }

        pagingUtil.initPaging("ul.pagination", pagingInfo, loadCounsel);

        $ajax.request({
            url: "/class/loadClass",
            method: "GET"
        }, function (err, res) {
            if (err) {
                alert("분반 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
                return;
            }

            var classInfo = res.contents;
            var yearInfo = {};
            var semesterInfo = {};
            var classNoInfo = {};

            for (var i = 0; i < classInfo.length; i++) {
                yearInfo[classInfo[i].year] = null;
                semesterInfo[classInfo[i].semester] = null;
                classNoInfo[classInfo[i].classNo] = null;
            }

            var sortOrderFunc = function (a, b) {
                return a - b;
            };

            yearInfo = Object.keys(yearInfo).sort(sortOrderFunc);
            semesterInfo = Object.keys(semesterInfo).sort(sortOrderFunc);
            classNoInfo = Object.keys(classNoInfo).sort(sortOrderFunc);

            $("select#year").append("<option value='-1'>연도</option>");
            $("select#semester").append("<option value='-1'>학기</option>");
            $("select#class-no").append("<option value='-1'>분반</option>");

            for (var i = 0; i < yearInfo.length; i++)
                $("select#year").append("<option value='" + yearInfo[i] + "'>" + yearInfo[i] + "년</option>");

            for (var i = 0; i < semesterInfo.length; i++)
                $("select#semester").append("<option value='" + semesterInfo[i] + "'>" + semesterInfo[i] + "학기</option>");

            for (var i = 0; i < classNoInfo.length; i++)
                $("select#class-no").append("<option value='" + classNoInfo[i] + "'>" + classNoInfo[i] + "분반</option>");
        });
    });

    $ajax.request({
        url: "/admin/loadWorker",
        method: "GET"
    }, function (err, res) {
        if (err) {
            alert("근무자 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var workerInfo = res.contents;

        $("select#counselor").append("<option value='-1'>상담자</option>");

        for (var i = 0; i < workerInfo.length; i++)
            $("select#counselor").append("<option value='" + workerInfo[i].userCode + "'>" + workerInfo[i].name + "(" + workerInfo[i].userId + ")</option>");
    });

    var datepickerInitInfo = {
        dateFormat: "yy-mm-dd",
        dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
        monthNames: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
    };

    var timepickerInitInfo = {
        timeFormat: "HH:mm",
        interval: 5,
        startTime: "00:00",
        maxTime: "23:55",
        dynamic: false,
        scrollbar: true
    };

    $("input[name=checkAll]").change(function () {
        if ($(this).prop("checked"))
            $("tbody#counsel-row input[name=counsel-id]").prop("checked", true);
        else
            $("tbody#counsel-row input[name=counsel-id]").prop("checked", false);
    });

    $("input[name=checkAll-modal]").change(function () {
        if ($(this).prop("checked"))
            $("tbody#student-row-modal input[name=user-code]").prop("checked", true);
        else
            $("tbody#student-row-modal input[name=user-code]").prop("checked", false);

        $("input[name=user-code]").trigger("change");
    });

    $("#addCounselStudentModal").on("show.bs.modal", function (event) {
        $("#counsel-datepicker-modal").datepicker(datepickerInitInfo);
        $("#counsel-datepicker-modal").datepicker(datepickerInitInfo);

        $("#counsel-timepicker-modal").timepicker(timepickerInitInfo);
        $("#counsel-timepicker-modal").timepicker(timepickerInitInfo);

        $("tbody#student-row-modal").html("");
        $("input#add-counsel-student-search").val("");

        $("tbody#student-row-modal").append(
            "<tr>" +
            "<td><input type='checkbox' name='user-code' value='-1'/></td>" +
            "<td class='user-id'></td>" +
            "<td class='dept'></td>" +
            "<td class='student-code'>검색 결과가 존재하지 않습니다.</td>" +
            "<td class='class-div' data-class-id='-1'></td>" +
            "<td class='name'></td>" +
            "</tr>"
        );
    });

    $("input#add-counsel-student-search").change(function () {
        addCounselStudentSearch();
    });
});

var loadCounsel = function (nowPage) {
    var data = {
        pagingInfo: {
            nowPage: 1
        }
    };

    $ajax.pagingRequest({
        url: "/counsel/loadCounsel",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("상담일지 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var counselList = res.contents.counselList;

        $("tbody#counsel-row").html("");

        for (var i = 0; i < counselList.length; i++) {
            $("tbody#counsel-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='counsel-id' value='" + counselList[i].counselId + "'/></td>" +
                "<td class='user-id'>" + counselList[i].userId + "</td>" +
                "<td class='college'>" + counselList[i].college + "</td>" +
                "<td class='dept'>" + counselList[i].dept + "</td>" +
                "<td class='student-code'>" + counselList[i].studentCode + "</td>" +
                "<td class='class-div'>" + counselList[i].year + "-" + counselList[i].semester + "(0" + counselList[i].classNo + ")</td>" +
                "<td class='name'>" + counselList[i].name + "</td>" +
                "<td class='counsel-datetime'>" + new Date(counselList[i].counselDatetime).format("yyyy-MM-dd HH:mm:ss") + "</td>" +
                "<td class='counsel-contents'>" + counselList[i].counselContents + "</td>" +
                "<td class='counselor-name'>" + counselList[i].counselorName + "</td>" +
                "</tr>"
            );
        }
    });
};

var searchCounsel = function () {
    var data = {
        year: Number($("select#year").val()),
        semester: Number($("select#semester").val()),
        classNo: Number($("select#class-no").val()),
        searchKey: $("input#counsel-search").val(),
        pagingInfo: {
            nowPage: 1
        }
    };

    $ajax.pagingRequest({
        url: "/counsel/loadCounselByCondition",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("상담일지 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var counselList = res.contents.counselList;
        var pagingInfo = res.pagingInfo;

        $("tbody#counsel-row").html("");

        if (counselList.length == 0) {
            $("tbody#counsel-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='counsel-id' value='-1'/></td>" +
                "<td class='user-id'></td>" +
                "<td class='college'></td>" +
                "<td class='dept'></td>" +
                "<td class='student-code'>검색 결과가 존재하지 않습니다.</td>" +
                "<td class='class-div'></td>" +
                "<td class='name'></td>" +
                "<td class='counsel-datetime'></td>" +
                "<td class='counsel-contents'></td>" +
                "<td class='counselor-name'></td>" +
                "</tr>"
            );
        }

        for (var i = 0; i < counselList.length; i++) {
            $("tbody#counsel-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='counsel-id' value='" + counselList[i].counselId + "'/></td>" +
                "<td class='user-id'>" + counselList[i].userId + "</td>" +
                "<td class='college'>" + counselList[i].college + "</td>" +
                "<td class='dept'>" + counselList[i].dept + "</td>" +
                "<td class='student-code'>" + counselList[i].studentCode + "</td>" +
                "<td class='class-div'>" + counselList[i].year + "-" + counselList[i].semester + "(0" + counselList[i].classNo + ")</td>" +
                "<td class='name'>" + counselList[i].name + "</td>" +
                "<td class='counsel-datetime'>" + new Date(counselList[i].counselDatetime).format("yyyy-MM-dd HH:mm:ss") + "</td>" +
                "<td class='counsel-contents'>" + counselList[i].counselContents + "</td>" +
                "<td class='counselor-name'>" + counselList[i].counselorName + "</td>" +
                "</tr>"
            );
        }

        pagingUtil.initPaging("ul.pagination", pagingInfo, searchCounselForPaging);
    });
};

var searchCounselForPaging = function (nowPage) {
    var data = {
        year: Number($("select#year").val()),
        semester: Number($("select#semester").val()),
        classNo: Number($("select#class-no").val()),
        searchKey: $("input#counsel-search").val(),
        pagingInfo: {
            nowPage: nowPage
        }
    };

    $ajax.pagingRequest({
        url: "/counsel/loadCounselByCondition",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("상담일지 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var counselList = res.contents.counselList;

        $("tbody#counsel-row").html("");

        if (counselList.length == 0) {
            $("tbody#counsel-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='counsel-id' value='-1'/></td>" +
                "<td class='user-id'></td>" +
                "<td class='college'></td>" +
                "<td class='dept'></td>" +
                "<td class='student-code'>검색 결과가 존재하지 않습니다.</td>" +
                "<td class='class-div'></td>" +
                "<td class='name'></td>" +
                "<td class='counsel-datetime'></td>" +
                "<td class='counsel-contents'></td>" +
                "<td class='counselor-name'></td>" +
                "</tr>"
            );
        }

        for (var i = 0; i < counselList.length; i++) {
            $("tbody#counsel-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='counsel-id' value='" + counselList[i].counselId + "'/></td>" +
                "<td class='user-id'>" + counselList[i].userId + "</td>" +
                "<td class='college'>" + counselList[i].college + "</td>" +
                "<td class='dept'>" + counselList[i].dept + "</td>" +
                "<td class='student-code'>" + counselList[i].studentCode + "</td>" +
                "<td class='class-div'>" + counselList[i].year + "-" + counselList[i].semester + "(0" + counselList[i].classNo + ")</td>" +
                "<td class='name'>" + counselList[i].name + "</td>" +
                "<td class='counsel-datetime'>" + new Date(counselList[i].counselDatetime).format("yyyy-MM-dd HH:mm:ss") + "</td>" +
                "<td class='counsel-contents'>" + counselList[i].counselContents + "</td>" +
                "<td class='counselor-name'>" + counselList[i].counselorName + "</td>" +
                "</tr>"
            );
        }
    });
};

var addCounselStudentSearch = function () {
    var data = {
        requireClassInfo: true,
        searchKey: $("input#add-counsel-student-search").val()
    };

    $ajax.request({
        url: "/student/loadStudentByCondition",
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
                "<td class='class-div' data-class-id='-1'></td>" +
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
                "<td class='class-div' data-class-id='" + userList[i].classId + "'>" + userList[i].year + "-" + userList[i].semester + "(0" + userList[i].classNo + ")</td>" +
                "<td class='name'>" + userList[i].name + "</td>" +
                "</tr>"
            );

            $("input[name=user-code]").change(function () {
                if ($(this).prop("checked")) {
                    $("span#student-code").html($(this).parent().siblings("td.student-code").html());
                    $("span#dept").html($(this).parent().siblings("td.dept").html());
                    $("span#class-div").html($(this).parent().siblings("td.class-div").html());
                    $("span#student-name").html($(this).parent().siblings("td.name").html());
                }
                else {
                    $("span#student-code").html("");
                    $("span#dept").html("");
                    $("span#class-div").html("");
                    $("span#student-name").html("");
                }
            });
        }
    });
};

var addCounsel = function () {
    if (!confirm("선택한 학생의 상담일지를 추가하시겠습니까?\n재수강 등으로 동일 인원이 여러 분반에 분산되어 있을 수 있습니다.\n소속 분반이 정확한지 확인해주세요."))
        return;

    if ($("input#counsel-datepicker-modal").val() == "") {
        alert("상담 날짜를 선택해주세요.");
        return;
    }

    if ($("input#counsel-timepicker-modal").val() == "") {
        alert("상담 시간을 선택해주세요.");
        return;
    }

    if ($("select#counselor").val() == -1) {
        alert("상담자를 선택해주세요.");
        return;
    }

    var data = {
        counselAddForAdminList: []
    };

    $("tbody#student-row-modal input[name=user-code]:checked").each(function () {
        var __data = {
            counselorUserCode: $("select#counselor").val(),
            classId: $(this).parent("td").siblings("td.class-div").attr("data-class-id"),
            userCode: $(this).val(),
            counselDatetime: $("input#counsel-datepicker-modal").val() + " " + $("input#counsel-timepicker-modal").val() + ":00",
            counselContents: $("input[name=counsel-contents]").val()
        };

        data.counselAddForAdminList.push(__data);
    });

    $ajax.request({
        url: "/admin/addCounselForAdmin",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("상담일지 추가를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert(res.contents);
        location.reload();
    });
};

var delCounsel = function () {
    if (!confirm("선택한 학생의 상담일지를 삭제하시겠습니까?\nPL Center 감사 등의 이유로 상담일지의 유지가 필요합니다.\n정확한 인원을 선택했는지 확인해주세요."))
        return;

    var data = {
        idList: []
    };

    $("tbody#counsel-row input[name=counsel-id]:checked").each(function () {
        data.idList.push(Number($(this).val()));
    });

    $ajax.request({
        url: "/counsel/delCounsel",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("상담일지 삭제를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert(res.contents);
        location.reload();
    });
};

var searchCounselEnterKey = function () {
    if (event.keyCode == 13)
        searchCounsel();
};