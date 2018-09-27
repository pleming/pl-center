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
        if(err) {
            alert("로그인을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        if (res.status == false) {
            alert(res.contents);
            return;
        }

        location.href = "/";
    });
};

var signinEnterKey = function() {
    if(event.keyCode == 13)
        signin();
};