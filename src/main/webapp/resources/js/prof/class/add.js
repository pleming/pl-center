$(document).ready(function() {
    var year = new Date().getFullYear();

    for(var i = 2011; i <= year; i++) {
        $("select#year").append("<option value='" + i + "'>" + i + "</option>");
    }
});

var classAdd = function() {
    var data = {
        year: Number($("select#year").val()),
        semester: Number($("select#semester").val()),
        classNo: Number($("select#class-no").val())
    };

    $ajax.request({
        url: "/class/addClass",
        method: "POST",
        data : JSON.stringify(data)
    }, function(err, res) {
        if (err || res.status == false) {
            alert("분반 추가를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        location.href = "/prof/class";
    });
};
