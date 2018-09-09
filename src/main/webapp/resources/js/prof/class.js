$(document).ready(function() {
    $ajax.request({
        url: "/class/loadClass",
        method: "GET"
    }, function (err, res) {
        if (err || res.status == false) {
            alert("분반 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var classData = res.contents;
    });
});
