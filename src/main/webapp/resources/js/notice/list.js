$(document).ready(function () {
    var data = {
        pagingInfo: {
            nowPage: 1
        }
    };

    $ajax.pagingRequest({
        url: "/notice/loadNoticeList",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("공지사항 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var noticeList = res.contents.noticeList;
        var pagingInfo = res.pagingInfo;

        for (var i = 0; i < noticeList.length; i++) {
            $("#notice-row").append(
                "<tr>" +
                "<td class='notice-id'>" + noticeList[i].id + "</td>" +
                "<td class='notice-title'><a href='/notice/view/" + noticeList[i].id + "'>" + noticeList[i].title + "</a></td>" +
                "<td class='notice-writer'>" + noticeList[i].writer + "</td>" +
                "<td class='notice-write-datetime'>" + new Date(noticeList[i].writeDatetime).format("yyyy-MM-dd") + "</td>" +
                "<td class='notice-views'>" + noticeList[i].views + "</td>" +
                "</tr>"
            );
        }

        pagingUtil.initPaging("ul.pagination", pagingInfo, loadNoticeList);
    });
});

var loadNoticeList = function (nowPage) {
    var data = {
        pagingInfo: {
            nowPage: nowPage
        }
    };

    $ajax.pagingRequest({
        url: "/notice/loadNoticeList",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("공지사항 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var noticeList = res.contents.noticeList;

        $("#notice-row").html("");

        for (var i = 0; i < noticeList.length; i++) {
            $("#notice-row").append(
                "<tr>" +
                "<td class='notice-id'>" + noticeList[i].id + "</td>" +
                "<td class='notice-title'><a href='/notice/view/" + noticeList[i].id + "'>" + noticeList[i].title + "</a></td>" +
                "<td class='notice-writer'>" + noticeList[i].writer + "</td>" +
                "<td class='notice-write-datetime'>" + new Date(noticeList[i].writeDatetime).format("yyyy-MM-dd") + "</td>" +
                "<td class='notice-views'>" + noticeList[i].views + "</td>" +
                "</tr>"
            );
        }
    });
};

var searchNotice = function () {
    var data = {
        searchKey: $(".input-notice-search").val(),
        pagingInfo: {
            nowPage: 1
        }
    };

    $ajax.pagingRequest({
        url: "/notice/search",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("공지사항 검색을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var noticeList = res.contents.noticeList;
        var pagingInfo = res.pagingInfo;

        $("tbody#notice-row").html("");

        if (noticeList.length == 0) {
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

        for (var i = 0; i < noticeList.length; i++) {
            $("#notice-row").append(
                "<tr>" +
                "<td class='notice-id'>" + noticeList[i].id + "</td>" +
                "<td class='notice-title'><a href='/notice/view/" + noticeList[i].id + "'>" + noticeList[i].title + "</a></td>" +
                "<td class='notice-writer'>" + noticeList[i].writer + "</td>" +
                "<td class='notice-write-datetime'>" + new Date(noticeList[i].writeDatetime).format("yyyy-MM-dd") + "</td>" +
                "<td class='notice-views'>" + noticeList[i].views + "</td>" +
                "</tr>"
            );
        }

        pagingUtil.initPaging("ul.pagination", pagingInfo, searchNoticeForPaging);
    });
};

var searchNoticeForPaging = function (nowPage) {
    var data = {
        searchKey: $(".input-notice-search").val(),
        pagingInfo: {
            nowPage: nowPage
        }
    };

    $ajax.pagingRequest({
        url: "/notice/search",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("공지사항 검색을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var noticeList = res.contents.noticeList;

        $("tbody#notice-row").html("");

        if (noticeList.length == 0) {
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

        for (var i = 0; i < noticeList.length; i++) {
            $("#notice-row").append(
                "<tr>" +
                "<td class='notice-id'>" + noticeList[i].id + "</td>" +
                "<td class='notice-title'><a href='/notice/view/" + noticeList[i].id + "'>" + noticeList[i].title + "</a></td>" +
                "<td class='notice-writer'>" + noticeList[i].writer + "</td>" +
                "<td class='notice-write-datetime'>" + new Date(noticeList[i].writeDatetime).format("yyyy-MM-dd") + "</td>" +
                "<td class='notice-views'>" + noticeList[i].views + "</td>" +
                "</tr>"
            );
        }
    });
};

var searchNoticeEnterKey = function () {
    if (event.keyCode == 13)
        searchNotice();
};