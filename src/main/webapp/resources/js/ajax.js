$.ajaxSetup({
    contentType: "application/json; charset=UTF-8",
    dataType: "json"
});

var $ajax = {
    request: function (options, callback) {
        /**
         * Required Options : url, method
         */
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
    },
    pagingRequest: function (options, callback) {
        /**
         * Required Options : url, method, data
         * Required Data : pagingInfo(nowPage),
         * Selection Data : pagingInfo(rowPerPage, pagingCount)
         */

        var parsedData = JSON.parse(options.data);
        var pagingCount = 10;

        if (!parsedData.pagingInfo.hasOwnProperty("rowPerPage"))
            parsedData.pagingInfo.rowPerPage = 10;

        if (parsedData.pagingInfo.hasOwnProperty("pagingCount")) {
            pagingCount = parsedData.pagingInfo.pagingCount;
            delete parsedData.pagingInfo.pagingCount;
        }

        options.data = JSON.stringify(parsedData);

        $.ajax(options)
            .done(function (data, textStatus, jqXHR) {
                options.data = JSON.parse(options.data);

                var __data = data;
                var contents = data.contents;
                var startPage = parseInt((options.data.pagingInfo.nowPage / pagingCount)) * pagingCount + 1;

                __data.pagingInfo = {
                    nowPage: options.data.pagingInfo.nowPage,
                    rowPerPage: options.data.pagingInfo.rowPerPage,
                    pagingCount: pagingCount,
                    totalRowCount: contents.totalRowCount,
                    totalPage: contents.totalRowCount % pagingCount ? parseInt(contents.totalRowCount / pagingCount) + 1 : parseInt(contents.totalRowCount / pagingCount),
                    startPage: startPage,
                    endPage: startPage + pagingCount - 1
                };

                __data.pagingInfo.endPage = __data.pagingInfo.endPage < __data.pagingInfo.totalPage ? __data.pagingInfo.endPage : __data.pagingInfo.totalPage;

                delete __data.contents.totalRowCount;

                callback(null, __data);
            })
            .fail(function (jqXHR, textStatus, err) {
                callback(err, null);
            });
    }
};