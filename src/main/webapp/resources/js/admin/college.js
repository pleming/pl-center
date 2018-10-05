$(document).ready(function() {
    $ajax.request({
        url: "/colDept/loadCollege",
        method: "GET"
    }, function (err, res) {
        if (err) {
            alert("단과대학 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var collegeList = res.contents;

        for(var i = 0; i < collegeList.length; i++) {
            $("tbody#college-row").append(
                "<tr>" +
                    "<td><input type='checkbox' name='college-id' value='" + collegeList[i].id + "'/></td>" +
                    "<td class='idx'>" + (i + 1) + "</td>" +
                    "<td class='name'>" + collegeList[i].college + "</td>" +
                "</tr>"
            );
        }
    });

    $("input[name=checkAll]").change(function() {
        if($(this).prop("checked"))
            $("tbody#college-row input[name=college-id]").prop("checked", true);
        else {
            $("tbody#college-row input[name=college-id]").prop("checked", false);
        }
    });
});

var addCollege = function() {
    if(!confirm("단과대학을 추가하시겠습니까?"))
        return;

    var data = {
        college: $("input[name=college]").val()
    };

    $ajax.request({
        url: "/admin/addCollege",
        method: "POST",
        data: JSON.stringify(data)
    }, function(err, res) {
        if (err) {
            alert("단과대학 추가를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert(res.contents);
        location.reload();
    });
};

var delCollege = function() {
    if(!confirm("선택한 단과대학을 삭제하시겠습니까?\n삭제 시, 해당 단과대학에 소속된 학생의 단과대학 데이터가 제대로 출력되지 않을 수 있습니다."))
        return;

    var data = {
        idList: []
    };

    $("tbody#college-row input[name=college-id]:checked").each(function() {
        data.idList.push(Number($(this).val()));
    });

    $ajax.request({
        url: "/admin/delCollege",
        method: "POST",
        data: JSON.stringify(data)
    }, function(err, res) {
        if (err) {
            alert("단과대학 삭제를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert(res.contents);
        location.reload();
    });
};