$(document).ready(function () {
    $ajax.request({
        url: "/notice/loadNoticeList",
        method: "GET"
    }, function (err, res) {
        if (err) {
            alert("공지사항 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var noticeInfo = res.contents;

        for (var i = 0; i < noticeInfo.length; i++) {
            $("#notice-row").append(
                "<tr>" +
                "<td class='notice-id'>" + noticeInfo[i].id + "</td>" +
                "<td class='notice-title'><a href='/notice/view/" + noticeInfo[i].id + "'>" + noticeInfo[i].title + "</a></td>" +
                "<td class='notice-writer'>" + noticeInfo[i].writer + "</td>" +
                "<td class='notice-write-datetime'>" + new Date(noticeInfo[i].writeDatetime).format("yyyy-MM-dd") + "</td>" +
                "<td class='notice-views'>" + noticeInfo[i].views + "</td>" +
                "</tr>"
            );
        }
    });
});