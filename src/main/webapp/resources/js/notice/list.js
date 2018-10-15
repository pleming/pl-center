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

var searchNotice = function () {
    var data = {
        searchKey: $(".input-notice-search").val()
    };

    $ajax.request({
        url: "/notice/search",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("공지사항 검색을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var noticeInfo = res.contents;

        $("tbody#notice-row").html("");

        if (noticeInfo.length == 0) {
            $("#notice-row").append(
                "<tr>" +
                "<td class='notice-id'></td>" +
                "<td class='notice-title'>검색 결과가 존재하지 않습니다.</td>" +
                "<td class='notice-writer'></td>" +
                "<td class='notice-write-datetime'></td>" +
                "<td class='notice-views'></td>" +
                "</tr>"
            );
        }

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
};

var searchNoticeEnterKey = function () {
    if (event.keyCode  == 13)
        searchNotice();
};