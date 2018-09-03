var signout = function () {
    $ajax.request({
        url: "/users/signout",
        method: "GET"
    }, function (err, res) {
        if (err || res.status == false) {
            alert("로그아웃을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        location.href = "/users/signin";
    });
};
