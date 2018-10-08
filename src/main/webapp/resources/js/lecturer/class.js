$(document).ready(function () {
    $ajax.request({
        url: "/class/loadClass",
        method: "GET"
    }, function (err, res) {
        if (err) {
            alert("분반 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var classData = res.contents;
        var yearInfo = {};

        for (var i = 0; i < classData.length; i++) {
            $("div#div-class-list").append(
                "<div class='card card-class' data-id='" + classData[i].id + "'>" +
                "<div class='card-body'>" +
                "<h1 class='card-title text-center'>" + classData[i].year + "-" + classData[i].semester + "(0" + classData[i].classNo + ")</h1>" +
                "</div>" +
                "</div>"
            );

            yearInfo[classData[i].year] = null;
        }

        yearInfo = Object.keys(yearInfo);

        $("select#year").append("<option value='-1'>연도</option>");

        for (var i = 0; i < yearInfo.length; i++)
            $("select#year").append("<option value='" + yearInfo[i] + "'>" + yearInfo[i] + "년</option>");
    });

    $("div#div-class-list").on("click", "div.card-class", function () {
        location.href = "/lecturer/class/mod/" + $(this).attr("data-id");
    });

    $("select#year").change(function () {
        var data = {
            year: Number($(this).val())
        };

        if (data.year == -1)
            return;

        $ajax.request({
            url: "/class/loadClassByYear",
            method: "POST",
            data: JSON.stringify(data)
        }, function (err, res) {
            if (err) {
                alert("분반 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
                return;
            }

            var classData = res.contents;

            $("div#div-class-list").html("");

            for (var i = 0; i < classData.length; i++) {
                $("div#div-class-list").append(
                    "<div class='card card-class' data-id='" + classData[i].id + "'>" +
                    "<div class='card-body'>" +
                    "<h1 class='card-title text-center'>" + classData[i].year + "-" + classData[i].semester + "(0" + classData[i].classNo + ")</h1>" +
                    "</div>" +
                    "</div>"
                );
            }
        });
    });
});
