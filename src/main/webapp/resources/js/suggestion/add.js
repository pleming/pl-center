$(document).ready(function () {
    tinymce.init({
        selector: "#post-editor",
        height: "640",
        plugins: "textcolor lists advlist image",
        menubar: false,
        toolbar: "fontsizeselect | image | bold italic underline strikethrough forecolor backcolor | alignleft aligncenter alignright alignjustify | numlist bullist outdent indent",
        fontsize_formats: "7pt 8pt 9pt 10pt 11pt 12pt 14pt 18pt 24pt 36pt",
        file_picker_callback: function (callback, value, meta) {
            if (meta.filetype == "image") {
                $("#image-upload").trigger("click");
                $("#image-upload").on("change", function () {
                    var file = this.files[0];
                    var reader = new FileReader();
                    var splitFilename = file.name.split(".");
                    var newFilename = splitFilename[0] + "-" + new Date().getTime() + "." + splitFilename[1];

                    reader.readAsDataURL(file);

                    reader.onload = function (e) {
                        callback(e.target.result, {
                            alt: newFilename
                        });
                    };
                });
            }
        }
    });
});

var addSuggestion = function () {
    var imageList = [];

    $("iframe#post-editor_ifr").contents().find("body[data-id=post-editor] img").each(function () {
        imageList.push({
            blobUrl: $(this).attr("src"),
            filename: $(this).attr("alt")
        });
    });

    parseBlobUrlToBase64(imageList, 0, function () {
        var postHTML = $("iframe#post-editor_ifr").contents().find("body[data-id=post-editor]").html();
        var data = {
            title: $("input[name=title]").val(),
            contents: postHTML,
            imageList: imageList
        };

        $ajax.request({
            url: "/suggestion/add",
            method: "POST",
            data: JSON.stringify(data)
        }, function (err, res) {
            if (err) {
                alert("공지사항 등록을 실패하였습니다. 관리자에게 문의해주세요.");
                return;
            }

            location.href = "/suggestion/list";
        });
    });
};

var cancelSuggestion = function () {
    if(!confirm("게시글 작성을 취소하시겠습니까?\n취소 시, 작성 중인 데이터를 되돌릴 수 없습니다."))
        return;

    location.href = "/suggestion/list";
};

var parseBlobUrlToBase64 = function (imageList, idx, callback) {
    if (imageList.length == idx) {
        callback();
        return;
    }

    $ajax.imgRequest(imageList[idx].blobUrl, function (err, res) {
        var reader = new FileReader();
        reader.readAsDataURL(res);

        reader.onload = function (e) {
            delete imageList[idx].blobUrl;
            imageList[idx].base64Data = e.target.result;
            parseBlobUrlToBase64(imageList, idx + 1, callback);
        }
    });
};
