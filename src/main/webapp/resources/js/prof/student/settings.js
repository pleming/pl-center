$(document).ready(function() {
    var classId = Number($("input[name=class-id]").val());

    $ajax.request({
        url: "/class/std/loadStudentInClass",
        method: "POST",
        data: JSON.stringify({classId: classId})
    }, function (err, res) {
        if (err || res.status == false) {
            alert("학생 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var userList = res.contents;

        for(var i = 0; i < userList.length; i++) {
            $("tbody#student-row").append(
                "<tr>" +
                "<td><input type='checkbox' name='user-code' value='" + userList[i].userCode + "'/></td>" +
                "<td class='user-code'>" + userList[i].userCode + "</td>" +
                "<td class='user-id'>" + userList[i].userId + "</td>" +
                "<td class='college'>" + userList[i].college + "</td>" +
                "<td class='dept'>" + userList[i].dept + "</td>" +
                "<td class='student-code'>" + userList[i].studentCode + "</td>" +
                "<td class='name'>" + userList[i].name + "</td>" +
                "<td class='email'>" + userList[i].email + "</td>" +
                "<td class='phone'>" + userList[i].phone + "</td>" +
                "</tr>"
            );
        }
    });
});

var delStudent = function() {
    var data = {
        classId: Number($("input[name=class-id]").val()),
        userList: []
    };

    $("input[name=user-code]").each(function() {
        if($(this).prop("checked")) {
            data.userList.push($(this).val());
        }
    });

    $ajax.request({
        url: "/class/std/delStudentInClass",
        method: "POST",
        data: JSON.stringify(data)
    }, function(err, res) {
        if(err || res.status == false) {
            alert("학생 삭제를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        location.reload();
    });
};