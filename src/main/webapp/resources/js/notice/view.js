$(document).ready(function() {
    var data = {
        noticeId: Number($("input[name=notice-id]").val())
    };

    $ajax.request({
        url: "/notice/loadNoticeById",
        method: "POST",
        data: JSON.stringify(data)
    }, function(err, res) {
        if (err) {
            alert("게시글 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var postInfo = res.contents;

        $("span#title > b").html(postInfo.title);
        $("span#write-datetime").html(new Date(postInfo.writeDatetime).format("yyyy-MM-dd HH:mm"));
        $("p#post-writer > b").html(" " + postInfo.writer);
        $("div#post-contents").html(postInfo.contents);
    });
});

