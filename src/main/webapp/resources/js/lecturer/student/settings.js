$(document).ready(function() {
    var classId = Number($("input[name=class-id]").val());

    $ajax.request({
        url: "/class/std/loadStudentInClass",
        method: "POST",
        data: JSON.stringify({classId: classId})
    }, function (err, res) {
        if (err) {
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

    $("input[name=checkAll]").change(function() {
        if($(this).prop("checked"))
            $("input[name=user-code]").prop("checked", true);
        else {
            $("input[name=user-code]").prop("checked", false);
        }
    });

    $("#addStudentModal").on("show.bs.modal", function(event) {
        $("tbody#student-row-modal").html("");
        $("input#add-student-search").val("");

        $("tbody#student-row-modal").append(
            "<tr>" +
            "<td><input type='checkbox' name='user-code' value='-1'/></td>" +
            "<td class='user-id'></td>" +
            "<td class='dept'>검색 결과가 존재하지 않습니다.</td>" +
            "<td class='student-code'></td>" +
            "<td class='name'></td>" +
            "</tr>"
        );
    });

    $("input#add-student-search").change(function() {
        addStudentSearch();
    })
});

var addStudentSearch = function() {
    var data = {
        searchKey: $("input#add-student-search").val()
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

        if(userList.length == 0) {
            $("tbody#student-row-modal").append(
                "<tr>" +
                "<td><input type='checkbox' name='user-code' value='-1'/></td>" +
                "<td class='user-id'></td>" +
                "<td class='dept'>검색 결과가 존재하지 않습니다.</td>" +
                "<td class='student-code'></td>" +
                "<td class='name'></td>" +
                "</tr>"
            );
            return;
        }

        for(var i = 0; i < userList.length; i++) {
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

var addStudent = function() {
    if(!confirm("선택한 학생을 추가하시겠습니까?"))
        return;

    var data = {
        classId: Number($("input[name=class-id]").val()),
        userList: []
    };

    $("tbody#student-row-modal input[name=user-code]:checked").each(function() {
        data.userList.push($(this).val());
    });

    $ajax.request({
        url: "/class/std/addStudentInClass",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("학생 추가를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert(res.contents);
        location.reload();
    });
};

var delStudent = function() {
    if(!confirm("선택한 학생을 삭제하시겠습니까?"))
        return;

    var data = {
        classId: Number($("input[name=class-id]").val()),
        userList: []
    };

    $("tbody#student-row input[name=user-code]:checked").each(function() {
        data.userList.push($(this).val());
    });

    $ajax.request({
        url: "/class/std/delStudentInClass",
        method: "POST",
        data: JSON.stringify(data)
    }, function(err, res) {
        if(err) {
            alert("학생 삭제를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        location.reload();
    });
};