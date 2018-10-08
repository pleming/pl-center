$(document).ready(function () {
    $ajax.request({
        url: "/suggestion/loadSuggestionList",
        method: "GET"
    }, function (err, res) {
        if (err) {
            alert("공지사항 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var suggestionInfo = res.contents;

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
});