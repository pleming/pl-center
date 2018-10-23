$(document).ready(function () {
    var data = {
        pagingInfo: {
            nowPage: 1
        }
    };

    $ajax.pagingRequest({
        url: "/student/loadStudent",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("학생 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var userList = res.contents.userList;
        var pagingInfo = res.pagingInfo;

        for (var i = 0; i < userList.length; i++) {
            $("tbody#student-row").append(
                "<tr>" +
                "<td class='user-code'>" + userList[i].userCode + "</td>" +
                "<td class='user-id'>" + userList[i].userId + "</td>" +
                "<td class='college'>" + userList[i].college + "</td>" +
                "<td class='dept'>" + userList[i].dept + "</td>" +
                "<td class='student-code'>" + userList[i].studentCode + "</td>" +
                "<td class='name'>" + userList[i].name + "</td>" +
                "<td class='email'>" + userList[i].email + "</td>" +
                "<td class='phone'>" + userList[i].phone + "</td>" +
                "<td class='auth'>" +
                "<select id='auth'>" +
                "<option value='0'" + (userList[i].auth == 0 ? "selected" : "") + ">학생</option>" +
                "<option value='1'" + (userList[i].auth == 1 ? "selected" : "") + ">근무자</option>" +
                "<option value='2'" + (userList[i].auth == 2 ? "selected" : "") + ">강의진</option>" +
                "<option value='3'" + (userList[i].auth == 3 ? "selected" : "") + ">관리자</option>" +
                "</select>" +
                "</td>" +
                "</tr>"
            );
        }

        pagingUtil.initPaging("ul.pagination", pagingInfo, loadStudent);

        var prevSelectValue = null;

        $("select#auth").focus(function () {
            prevSelectValue = $(this).val();
        }).change(function () {
            if (confirm("권한을 변경하시겠습니까?")) {
                var authData = {
                    userCode: Number($(this).parent("td").siblings("td.user-code").text()),
                    auth: $(this).val()
                };

                $ajax.request({
                    url: "/admin/updateAuth",
                    method: "POST",
                    data: JSON.stringify(authData)
                }, function (err, res) {
                    if (err || res.status == false) {
                        $(this).val(prevSelectValue);
                        alert("권한 변경을 실패하였습니다. 관리자에게 문의해주세요.");
                        return;
                    }
                });
            }
            else
                $(this).val(prevSelectValue);
        });
    });
});

var loadStudent = function (nowPage) {
    var data = {
        pagingInfo: {
            nowPage: nowPage
        }
    };

    $ajax.pagingRequest({
        url: "/student/loadStudent",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("학생 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var userList = res.contents.userList;

        $("tbody#student-row").html("");

        for (var i = 0; i < userList.length; i++) {
            $("tbody#student-row").append(
                "<tr>" +
                "<td class='user-code'>" + userList[i].userCode + "</td>" +
                "<td class='user-id'>" + userList[i].userId + "</td>" +
                "<td class='college'>" + userList[i].college + "</td>" +
                "<td class='dept'>" + userList[i].dept + "</td>" +
                "<td class='student-code'>" + userList[i].studentCode + "</td>" +
                "<td class='name'>" + userList[i].name + "</td>" +
                "<td class='email'>" + userList[i].email + "</td>" +
                "<td class='phone'>" + userList[i].phone + "</td>" +
                "<td class='auth'>" +
                "<select id='auth'>" +
                "<option value='0'" + (userList[i].auth == 0 ? "selected" : "") + ">학생</option>" +
                "<option value='1'" + (userList[i].auth == 1 ? "selected" : "") + ">근무자</option>" +
                "<option value='2'" + (userList[i].auth == 2 ? "selected" : "") + ">강의진</option>" +
                "<option value='3'" + (userList[i].auth == 3 ? "selected" : "") + ">관리자</option>" +
                "</select>" +
                "</td>" +
                "</tr>"
            );
        }

        var prevSelectValue = null;

        $("select#auth").focus(function () {
            prevSelectValue = $(this).val();
        }).change(function () {
            if (confirm("권한을 변경하시겠습니까?")) {
                var authData = {
                    userCode: Number($(this).parent("td").siblings("td.user-code").text()),
                    auth: $(this).val()
                };

                $ajax.request({
                    url: "/admin/updateAuth",
                    method: "POST",
                    data: JSON.stringify(authData)
                }, function (err, res) {
                    if (err || res.status == false) {
                        $(this).val(prevSelectValue);
                        alert("권한 변경을 실패하였습니다. 관리자에게 문의해주세요.");
                        return;
                    }
                });
            }
            else
                $(this).val(prevSelectValue);
        });
    });
};

var searchAuth = function () {
    var data = {
        searchKey: $("input#auth-search").val(),
        pagingInfo: {
            nowPage: 1
        }
    };

    $ajax.pagingRequest({
        url: "/student/searchStudent",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("학생 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var userList = res.contents.userList;
        var pagingInfo = res.pagingInfo;

        $("tbody#student-row").html("");

        if (userList.length == 0) {
            $("tbody#student-row").append(
                "<tr>" +
                "<td class='user-code'></td>" +
                "<td class='user-id'></td>" +
                "<td class='college'></td>" +
                "<td class='dept'></td>" +
                "<td class='student-code'>검색 결과가 존재하지 않습니다.</td>" +
                "<td class='name'></td>" +
                "<td class='email'></td>" +
                "<td class='phone'></td>" +
                "<td class='auth'></td>" +
                "</tr>"
            );
        }

        for (var i = 0; i < userList.length; i++) {
            $("tbody#student-row").append(
                "<tr>" +
                "<td class='user-code'>" + userList[i].userCode + "</td>" +
                "<td class='user-id'>" + userList[i].userId + "</td>" +
                "<td class='college'>" + userList[i].college + "</td>" +
                "<td class='dept'>" + userList[i].dept + "</td>" +
                "<td class='student-code'>" + userList[i].studentCode + "</td>" +
                "<td class='name'>" + userList[i].name + "</td>" +
                "<td class='email'>" + userList[i].email + "</td>" +
                "<td class='phone'>" + userList[i].phone + "</td>" +
                "<td class='auth'>" +
                "<select id='auth'>" +
                "<option value='0'" + (userList[i].auth == 0 ? "selected" : "") + ">학생</option>" +
                "<option value='1'" + (userList[i].auth == 1 ? "selected" : "") + ">근무자</option>" +
                "<option value='2'" + (userList[i].auth == 2 ? "selected" : "") + ">강의진</option>" +
                "<option value='3'" + (userList[i].auth == 3 ? "selected" : "") + ">관리자</option>" +
                "</select>" +
                "</td>" +
                "</tr>"
            );
        }

        pagingUtil.initPaging("ul.pagination", pagingInfo, searchAuthForPaging);

        var prevSelectValue = null;

        $("select#auth").focus(function () {
            prevSelectValue = $(this).val();
        }).change(function () {
            if (confirm("권한을 변경하시겠습니까?")) {
                var authData = {
                    userCode: Number($(this).parent("td").siblings("td.user-code").text()),
                    auth: $(this).val()
                };

                $ajax.request({
                    url: "/admin/updateAuth",
                    method: "POST",
                    data: JSON.stringify(authData)
                }, function (err, res) {
                    if (err || res.status == false) {
                        $(this).val(prevSelectValue);
                        alert("권한 변경을 실패하였습니다. 관리자에게 문의해주세요.");
                        return;
                    }
                });
            }
            else
                $(this).val(prevSelectValue);
        });
    });
};

var searchAuthForPaging = function (nowPage) {
    var data = {
        searchKey: $("input#auth-search").val(),
        pagingInfo: {
            nowPage: nowPage
        }
    };

    $ajax.pagingRequest({
        url: "/student/searchStudent",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("학생 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var userList = res.contents.userList;

        $("tbody#student-row").html("");

        if (userList.length == 0) {
            $("tbody#student-row").append(
                "<tr>" +
                "<td class='user-code'></td>" +
                "<td class='user-id'></td>" +
                "<td class='college'></td>" +
                "<td class='dept'></td>" +
                "<td class='student-code'>검색 결과가 존재하지 않습니다.</td>" +
                "<td class='name'></td>" +
                "<td class='email'></td>" +
                "<td class='phone'></td>" +
                "<td class='auth'></td>" +
                "</tr>"
            );
        }

        for (var i = 0; i < userList.length; i++) {
            $("tbody#student-row").append(
                "<tr>" +
                "<td class='user-code'>" + userList[i].userCode + "</td>" +
                "<td class='user-id'>" + userList[i].userId + "</td>" +
                "<td class='college'>" + userList[i].college + "</td>" +
                "<td class='dept'>" + userList[i].dept + "</td>" +
                "<td class='student-code'>" + userList[i].studentCode + "</td>" +
                "<td class='name'>" + userList[i].name + "</td>" +
                "<td class='email'>" + userList[i].email + "</td>" +
                "<td class='phone'>" + userList[i].phone + "</td>" +
                "<td class='auth'>" +
                "<select id='auth'>" +
                "<option value='0'" + (userList[i].auth == 0 ? "selected" : "") + ">학생</option>" +
                "<option value='1'" + (userList[i].auth == 1 ? "selected" : "") + ">근무자</option>" +
                "<option value='2'" + (userList[i].auth == 2 ? "selected" : "") + ">강의진</option>" +
                "<option value='3'" + (userList[i].auth == 3 ? "selected" : "") + ">관리자</option>" +
                "</select>" +
                "</td>" +
                "</tr>"
            );
        }

        var prevSelectValue = null;

        $("select#auth").focus(function () {
            prevSelectValue = $(this).val();
        }).change(function () {
            if (confirm("권한을 변경하시겠습니까?")) {
                var authData = {
                    userCode: Number($(this).parent("td").siblings("td.user-code").text()),
                    auth: $(this).val()
                };

                $ajax.request({
                    url: "/admin/updateAuth",
                    method: "POST",
                    data: JSON.stringify(authData)
                }, function (err, res) {
                    if (err || res.status == false) {
                        $(this).val(prevSelectValue);
                        alert("권한 변경을 실패하였습니다. 관리자에게 문의해주세요.");
                        return;
                    }
                });
            }
            else
                $(this).val(prevSelectValue);
        });
    });
};

var authEnterKey = function () {
    if (event.keyCode == 13)
        searchAuth();
};