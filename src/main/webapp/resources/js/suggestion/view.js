$(document).ready(function () {
    var data = {
        suggestionId: Number($("input[name=suggestion-id]").val())
    };

    $ajax.request({
        url: "/suggestion/loadSuggestionById",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("게시글 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var postInfo = res.contents;

        $("span#title > b").html(postInfo.title);
        $("span#write-datetime").html(new Date(postInfo.writeDatetime).format("yyyy-MM-dd HH:mm"));
        $("p#post-writer > b").html(" " + postInfo.writer);
        $("div#post-contents").html(postInfo.contents);

        $ajax.request({
            url: "/suggestion/loadComment",
            method: "POST",
            data: JSON.stringify(data)
        }, function (err, res) {
            if (err) {
                alert("댓글 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
                return;
            }

            var commentList = res.contents.commentList;
            var userCode = res.contents.userCode;

            for (var i = 0; i < commentList.length; i++) {
                var template1 = "<div class='div-comment-box' data-comment-id='" + commentList[i].id + "'>" +
                    "<div class='div-comment-writer'>" +
                    "<i class='fa fa-user-circle-o' aria-hidden='true'></i>" +
                    "<b id='comment-writer'> " + commentList[i].writer + "</b>" +
                    "<span id='comment-datetime'> " + new Date(commentList[i].writeDatetime).format("yyyy-MM-dd HH:mm:ss") + "</span>" +
                    "<div class='div-comment-control'>";

                var template2 = "<span onclick='openModComment(this)'>수정</span>" +
                    "<span> | </span>" +
                    "<span onclick='delComment(this)'>삭제</span>";

                var template3 = "</div>" +
                    "</div>" +
                    "<div class='comment-contents'>" +
                    "<p>" + commentList[i].contents + "</p>" +
                    "</div>" +
                    "</div>";

                var templateResult = template1;

                if (commentList[i].writerId == userCode)
                    templateResult += template2;

                templateResult += template3;

                $("div.div-comment-writebox").before(templateResult);
            }
        });
    });
});

var delSuggestion = function () {
    if (!confirm("게시글을 삭제하시겠습니까?"))
        return;

    $ajax.request({
        url: "/suggestion/del/" + $("input[name=suggestion-id]").val(),
        method: "GET"
    }, function (err, res) {
        if (err) {
            alert("게시글 삭제를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        if (res.code == 1) {
            alert(res.contents);
            return;
        }

        location.href = "/suggestion/list";
    });
};

var addComment = function () {
    if (!confirm("댓글을 등록하시겠습니까?"))
        return;

    var data = {
        postId: Number($("input[name=suggestion-id]").val()),
        contents: $("textarea#comment").val()
    };

    console.log(data);

    $ajax.request({
        url: "/suggestion/addComment",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("댓글 등록을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        location.reload();
    });
};

var openModComment = function (eventTarget) {
    var divCommentControl = $(eventTarget).parent(".div-comment-control");
    var divCommentContents = $(eventTarget).closest(".div-comment-writer").siblings(".comment-contents");

    var bakCommentControlHtml = divCommentControl.html();
    var bakCommentContentsHtml = divCommentContents.html();

    divCommentControl.html("<span class='cancelModComment'>취소</span>");

    divCommentContents.html(
        "<textarea class='form-control' id='comment-mod'></textarea>" +
        "<button class='form-control btn-comment-mod' onclick='modComment(this)'>수정</button>"
    );

    $("textarea#comment-mod").val($(bakCommentContentsHtml).text());

    $("span.cancelModComment").click(function () {
        divCommentControl.html(bakCommentControlHtml);
        divCommentContents.html(bakCommentContentsHtml);
    });
};

var modComment = function (eventTarget) {
    if (!confirm("댓글을 수정하시겠습니까?"))
        return;

    var data = {
        id: $(eventTarget).closest(".div-comment-box").attr("data-comment-id"),
        contents: $(eventTarget).siblings("textarea#comment-mod").val()
    };

    $ajax.request({
        url: "/suggestion/modComment",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("댓글 수정을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        if (res.code != 3) {
            alert(res.contents);
            return;
        }

        $(eventTarget).closest(".comment-contents").siblings(".div-comment-writer").find(".div-comment-control").html(
            "<span onclick='openModComment(this)'>수정</span>" +
            "<span> | </span>" +
            "<span onclick='delComment(this)'>삭제</span>"
        );

        $(eventTarget).closest(".comment-contents").html("<p>" + data.contents + "</p>");
    });
};

var delComment = function (eventTarget) {
    if (!confirm("댓글을 삭제하시겠습니까?"))
        return;

    var data = {
        idList: [$(eventTarget).closest(".div-comment-box").attr("data-comment-id")]
    };

    $ajax.request({
        url: "/suggestion/delComment",
        method: "POST",
        data: JSON.stringify(data)
    }, function (err, res) {
        if (err) {
            alert("댓글 삭제를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        if (res.code != 3) {
            alert(res.contents);
            return;
        }

        location.reload();
    });
};