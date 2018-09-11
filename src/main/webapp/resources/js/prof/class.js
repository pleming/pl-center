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

        for(var i = 0; i < classData.length; i++) {
            $("div#div-class-list").append(
                "<div class='card card-class' data-id='" + classData[i].id + "'>" +
                    "<div class='card-body'>" +
                        "<h1 class='card-title text-center'>" + classData[i].year + "-" + classData[i].semester + "(0" + classData[i].classNo + ")</h1>" +
                    "</div>" +
                "</div>"
            );
        }
    });

    $("div#div-class-list").on("click", "div.card-class", function() {
        location.href = "/prof/class/mod/" + $(this).attr("data-id");
    });
});
