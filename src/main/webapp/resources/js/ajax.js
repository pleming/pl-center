$.ajaxSetup({
    contentType: "application/json; charset=UTF-8",
    dataType: "json"
});

var $ajax = {
    request: function (options, callback) {
        $.ajax(options)
            .done(function (data, textStatus, jqXHR) {
                callback(null, data);
            })
            .fail(function (jqXHR, textStatus, err) {
                callback(err, null);
            });
    },
    imgRequest: function (url, callback) {
        var xhr = new XMLHttpRequest();

        xhr.open("GET", url, true);
        xhr.responseType = "blob";
        xhr.send();

        xhr.onload = function (e) {
            if (this.status == 200) {
                var blobData = this.response;
                callback(null, blobData);
            }
            else
                callback("AJAX Image Request Error.", null);
        };
    }
};