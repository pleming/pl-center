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
    }
};