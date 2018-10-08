$(document).ready(function () {
    $ajax.request({
        url: "/counsel/loadCounsel",
        method: "GET"
    }, function (err, res) {
        if (err) {
            alert("상담일지 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var counselList = res.contents;

        for (var i = 0; i < counselList.length; i++) {
            $("tbody#counsel-row").append(
                "<tr>" +
                "<td class='user-id'>" + counselList[i].userId + "</td>" +
                "<td class='college'>" + counselList[i].college + "</td>" +
                "<td class='dept'>" + counselList[i].dept + "</td>" +
                "<td class='student-code'>" + counselList[i].studentCode + "</td>" +
                "<td class='class-div'>" + counselList[i].year + "-" + counselList[i].semester + "(0" + counselList[i].classNo + ")</td>" +
                "<td class='name'>" + counselList[i].name + "</td>" +
                "<td class='counsel-datetime'>" + new Date(counselList[i].counselDatetime).format("yyyy-MM-dd HH:mm:ss") + "</td>" +
                "<td class='counsel-contents'>" + counselList[i].counselContents + "</td>" +
                "</tr>"
            );
        }

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

    $("input[name=checkAll]").change(function () {
        if ($(this).prop("checked"))
            $("input[name=counsel-id]").prop("checked", true);
        else {
            $("input[name=counsel-id]").prop("checked", false);
        }
    });
});

var searchCounsel = function () {
    var data = {
        year: Number($("select#year").val()),
        semester: Number($("select#semester").val()),
        classNo: Number($("select#class-no").val()),
        searchKey: $("input#counsel-search").val()
    };

    $ajax.request({
        url: "/counsel/loadCounselByCondition",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("상담일지 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var counselList = res.contents;

        $("tbody#counsel-row").html("");

        if (counselList.length == 0) {
            $("tbody#counsel-row").append(
                "<tr>" +
                "<td class='user-id'></td>" +
                "<td class='college'></td>" +
                "<td class='dept'></td>" +
                "<td class='student-code'>검색 결과가 존재하지 않습니다.</td>" +
                "<td class='class-div'></td>" +
                "<td class='name'></td>" +
                "<td class='counsel-datetime'></td>" +
                "<td class='counsel-contents'></td>" +
                "</tr>"
            );
            return;
        }

        for (var i = 0; i < counselList.length; i++) {
            $("tbody#counsel-row").append(
                "<tr>" +
                "<td class='user-id'>" + counselList[i].userId + "</td>" +
                "<td class='college'>" + counselList[i].college + "</td>" +
                "<td class='dept'>" + counselList[i].dept + "</td>" +
                "<td class='student-code'>" + counselList[i].studentCode + "</td>" +
                "<td class='class-div'>" + counselList[i].year + "-" + counselList[i].semester + "(0" + counselList[i].classNo + ")</td>" +
                "<td class='name'>" + counselList[i].name + "</td>" +
                "<td class='counsel-datetime'>" + new Date(counselList[i].counselDatetime).format("yyyy-MM-dd HH:mm:ss") + "</td>" +
                "<td class='counsel-contents'>" + counselList[i].counselContents + "</td>" +
                "</tr>"
            );
        }
    });
};