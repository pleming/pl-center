var checkPasswd = function () {
    var data = {
        passwd: $("input[name=passwd]").val()
    };

    $ajax.request({
        url: "/users/checkPasswd",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("비밀번호 확인을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        if (res.code == 2) {
            alert(res.contents);
            return;
        }

        location.href = res.contents;
    });
};