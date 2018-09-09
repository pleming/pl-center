$(document).ready(function() {
    $ajax.request({
        url: "/admin/loadStudent",
        method: "GET"
    }, function (err, res) {
        if (err || res.status == false) {
            alert("학생 목록 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var userList = res.contents;

        for(var i = 0; i < userList.length; i++) {
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
                            "<option value='2'" + (userList[i].auth == 2 ? "selected" : "") + ">조교</option>" +
                            "<option value='3'" + (userList[i].auth == 3 ? "selected" : "") + ">교수</option>" +
                            "<option value='4'" + (userList[i].auth == 4 ? "selected" : "") + ">관리자</option>" +
                        "</select>" +
                    "</td>" +
                "</tr>"
            );
        }

        var prevSelectValue = null;

        $("select#auth").focus(function() {
            prevSelectValue = $(this).val();
        }).change(function() {
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