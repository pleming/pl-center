$(document).ready(function () {
    $ajax.request({
        url: "/colDept/loadCollege",
        method: "GET"
    }, function (err, res) {
        if (err) {
            alert("단과대학 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var collegeList = res.contents;

        $("select#college").append("<option value='-1'>단과대학</option>");
        $("select#college-modal").append("<option value='-1'>단과대학</option>");

        for (var i = 0; i < collegeList.length; i++) {
            $("select#college").append(
                "<option value='" + collegeList[i].id + "'>" + collegeList[i].college + "</option>"
            );

            $("select#college-modal").append(
                "<option value='" + collegeList[i].id + "'>" + collegeList[i].college + "</option>"
            );
        }
    });

    $("select#college").change(function () {
        $("tbody#dept-row").html("");
        loadDept(parseInt($(this).val()));
    });

    $("input[name=checkAll]").change(function () {
        if ($(this).prop("checked"))
            $("tbody#dept-row input[name=dept-id]").prop("checked", true);
        else {
            $("tbody#dept-row input[name=dept-id]").prop("checked", false);
        }
    });
});

var loadDept = function (colId) {
    $ajax.request({
        url: "/colDept/loadDept",
        method: "POST",
        data: JSON.stringify({id: colId})
    }, function (err, res) {
        if (err) {
            alert("학과 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var deptList = res.contents;

        for (var i = 0; i < deptList.length; i++) {
            $("tbody#dept-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='dept-id' value='" + deptList[i].id + "'/></td>" +
                "<td class='idx'>" + (i + 1) + "</td>" +
                "<td class='name'>" + deptList[i].dept + "</td>" +
                "</tr>"
            );
        }
    });
};

var addDept = function () {
    if (!confirm("학과를 추가하시겠습니까?"))
        return;

    var data = {
        collegeId: Number($("select#college-modal").val()),
        deptName: $("input[name=dept]").val()
    };

    $ajax.request({
        url: "/admin/addDept",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("학과 추가를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert(res.contents);
        location.reload();
    });
};

var delDept = function () {
    if (!confirm("선택한 학과를 삭제하시겠습니까?\n삭제 시, 해당 학과에 소속된 학생의 학과 데이터가 제대로 출력되지 않을 수 있습니다."))
        return;

    var data = {
        colDeptIdList: []
    };

    $("tbody#dept-row input[name=dept-id]:checked").each(function () {
        data.colDeptIdList.push({
            collegeId: Number($("select#college").val()),
            deptId: Number($(this).val())
        });
    });

    $ajax.request({
        url: "/admin/delDept",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("학과 삭제를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert(res.contents);
        location.reload();
    });
};