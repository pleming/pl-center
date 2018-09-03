var signin = function () {
    var data = {
        userId: $("input[name=userId]").val(),
        passwd: $("input[name=passwd]").val()
    };

    $ajax.request({
       url: "/users/signin",
       method: "POST",
       data: JSON.stringify(data)
    }, function (err, res) {
        if (err || res.status == false) {
            alert("로그인을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        location.href = "/";
    });
};
