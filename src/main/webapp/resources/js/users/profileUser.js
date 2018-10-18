var userInfo = null;
var firstCalled = true;

$(document).ready(function () {
    $ajax.request({
        url: "/users/loadUserInfo",
        method: "GET"
    }, function (err, res) {
        if (err) {
            alert("회원 정보 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        userInfo = res.contents;

        $("input[name=userId]").val(userInfo.userId);
        $("input[name=studentCode]").val(userInfo.studentCode);
        $("input[name=name]").val(userInfo.name);
        $("input[name=email]").val(userInfo.email);
        $("input[name=phone]").val(userInfo.phone);

        $ajax.request({
            url: "/colDept/loadCollege",
            method: "GET"
        }, function (err, res) {
            if (err || res.status == false) {
                alert("단과대학 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
                return;
            }

            var college = res.contents;

            $("select#col").append("<option value='-1'>단과대학</option>");
            $("select#dept").append("<option value='-1'>학과</option>");

            for (var i = 0; i < college.length; i++) {
                $("select#col").append(
                    "<option value=" + college[i].id + ">" + college[i].college + "</option>"
                );
            }

            $("select#col").val(userInfo.colId);
            $("select#col").trigger("change");
        });
    });

    $("select#col").change(function () {
        $("select#dept").html("");
        $("select#dept").append("<option value='-1'>학과</option>");
        loadDept(parseInt($(this).val()));
    });
});


var loadDept = function (colId) {
    $ajax.request({
        url: "/colDept/loadDept",
        method: "POST",
        data: JSON.stringify({id: colId})
    }, function (err, res) {
        if (err || res.status == false) {
            alert("학과 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var dept = res.contents;

        for (var i = 0; i < dept.length; i++) {
            $("select#dept").append(
                "<option value=" + dept[i].id + ">" + dept[i].dept + "</option>"
            );
        }

        if (firstCalled) {
            $("select#dept").val(userInfo.deptId);
            firstCalled = false;
        }
    });
};

var updateUserInfo = function () {
    var data = {
        userId: $("input[name=userId]").val(),
        passwd: $("input[name=passwd]").val(),
        chkPasswd: $("input[name=chkPasswd]").val(),
        colId: $("select#col").val(),
        deptId: $("select#dept").val(),
        studentCode: $("input[name=studentCode]").val(),
        name: $("input[name=name]").val(),
        email: $("input[name=email]").val(),
        phone: $("input[name=phone]").val()
    };

    if (data.passwd != data.chkPasswd) {
        alert("패스워드와 패스워드 확인이 일치하지 않습니다.");
        return;
    }

    if (data.colId == -1) {
        alert("단과대학을 선택해주세요.");
        return;
    }

    if (data.deptId == -1) {
        alert("학과를 선택해주세요.");
        return;
    }

    var keys = Object.keys(data);

    for (var i = 0; i < keys.length; i++) {
        if (data[keys[i]] == "") {
            alert("빈 칸을 전부 입력해주세요.");
            return;
        }
    }

    if (!confirm("회원 정보를 변경하시겠습니까?"))
        return;

    $ajax.request({
        url: "/users/updateUserInfo",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("회원정보 변경을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert(res.contents);
        location.href = "/";
    });
};