$(document).ready(function () {
    var data = {
        nowPage: 1
    };

    $ajax.pagingRequest({
        url: "/suggestion/loadSuggestionList",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("건의사항 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var suggestionInfo = res.contents.suggestionList;
        var pagingInfo = res.pagingInfo;

        for (var i = 0; i < suggestionInfo.length; i++) {
            $("#suggestion-row").append(
                "<tr>" +
                "<td class='suggestion-id'>" + suggestionInfo[i].id + "</td>" +
                "<td class='suggestion-title'><a href='/suggestion/view/" + suggestionInfo[i].id + "'>" + suggestionInfo[i].title + "</a></td>" +
                "<td class='suggestion-writer'>" + suggestionInfo[i].writer + "</td>" +
                "<td class='suggestion-write-datetime'>" + new Date(suggestionInfo[i].writeDatetime).format("yyyy-MM-dd") + "</td>" +
                "<td class='suggestion-views'>" + suggestionInfo[i].views + "</td>" +
                "</tr>"
            );
        }

        pagingUtil.initPaging("ul.pagination", pagingInfo, loadSuggestionList);
    });
});

var loadSuggestionList = function (nowPage) {
    var data = {
        nowPage: nowPage
    };

    $ajax.pagingRequest({
        url: "/suggestion/loadSuggestionList",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("건의사항 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var suggestionInfo = res.contents.suggestionList;

        $("#suggestion-row").html("");

        for (var i = 0; i < suggestionInfo.length; i++) {
            $("#suggestion-row").append(
                "<tr>" +
                "<td class='suggestion-id'>" + suggestionInfo[i].id + "</td>" +
                "<td class='suggestion-title'><a href='/suggestion/view/" + suggestionInfo[i].id + "'>" + suggestionInfo[i].title + "</a></td>" +
                "<td class='suggestion-writer'>" + suggestionInfo[i].writer + "</td>" +
                "<td class='suggestion-write-datetime'>" + new Date(suggestionInfo[i].writeDatetime).format("yyyy-MM-dd") + "</td>" +
                "<td class='suggestion-views'>" + suggestionInfo[i].views + "</td>" +
                "</tr>"
            );
        }
    });
};

var searchSuggestion = function () {
    var data = {
        searchKey: $(".input-suggestion-search").val()
    };

    $ajax.request({
        url: "/suggestion/search",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("건의사항 검색을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var suggestionInfo = res.contents;

        $("tbody#suggestion-row").html("");

        if (suggestionInfo.length == 0) {
            $("#suggestion-row").append(
                "<tr>" +
                "<td class='suggestion-id'></td>" +
                "<td class='suggestion-title'>검색 결과가 존재하지 않습니다.</td>" +
                "<td class='suggestion-writer'></td>" +
                "<td class='suggestion-write-datetime'></td>" +
                "<td class='suggestion-views'></td>" +
                "</tr>"
            );
        }

        for (var i = 0; i < suggestionInfo.length; i++) {
            $("#suggestion-row").append(
                "<tr>" +
                "<td class='suggestion-id'>" + suggestionInfo[i].id + "</td>" +
                "<td class='suggestion-title'><a href='/suggestion/view/" + suggestionInfo[i].id + "'>" + suggestionInfo[i].title + "</a></td>" +
                "<td class='suggestion-writer'>" + suggestionInfo[i].writer + "</td>" +
                "<td class='suggestion-write-datetime'>" + new Date(suggestionInfo[i].writeDatetime).format("yyyy-MM-dd") + "</td>" +
                "<td class='suggestion-views'>" + suggestionInfo[i].views + "</td>" +
                "</tr>"
            );
        }
    });
};

var searchSuggestionEnterKey = function () {
    if (event.keyCode == 13)
        searchSuggestion();
};
