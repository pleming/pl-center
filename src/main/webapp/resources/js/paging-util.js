var pagingUtil = {
    initPaging: function (selector, pagingInfo, loadFunc) {
        $("#prevFirst").addClass("disabled");
        $("#prev").addClass("disabled");
        $("#next").removeClass("disabled");
        $("#nextEnd").removeClass("disabled");

        $(".paging-number").remove();

        for (var i = pagingInfo.endPage; i >= pagingInfo.startPage; i--)
            $("#prev").after("<li class='page-item paging-number'><a class='page-link' href='#'>" + i + "</a></li>");

        $("#nextEnd").attr("data-total-page", pagingInfo.totalPage);

        if (pagingInfo.endPage == parseInt($("#nextEnd").attr("data-total-page"))) {
            $("#next").addClass("disabled");
            $("#nextEnd").addClass("disabled");
        }

        $(".paging-number:first").addClass("active");

        pagingUtil.eventBinding(loadFunc);

        $("#prevFirst").click(function () {
            if (!$("#prevFirst").hasClass("disabled")) {
                $(".paging-number").remove();

                for (var i = 10; i >= 1; i--)
                    $("#prev").after("<li class='page-item paging-number'><a class='page-link' href='#'>" + i + "</a></li>");

                $("#prevFirst").addClass("disabled");
                $("#prev").addClass("disabled");
                $("#next").removeClass("disabled");
                $("#nextEnd").removeClass("disabled");

                pagingUtil.eventBinding(loadFunc);
            }
        });

        $("#prev").click(function () {
            if (!$("#prev").hasClass("disabled")) {
                var start = parseInt($(".paging-number:first").text()) - pagingInfo.pagingCount;
                var end = start + pagingInfo.pagingCount - 1;

                $(".paging-number").remove();

                for (var i = end; i >= start; i--)
                    $("#prev").after("<li class='page-item paging-number'><a class='page-link' href='#'>" + i + "</a></li>");

                if (start == 1) {
                    $("#prevFirst").addClass("disabled");
                    $("#prev").addClass("disabled");
                }

                $("#next").removeClass("disabled");
                $("#nextEnd").removeClass("disabled");

                pagingUtil.eventBinding(loadFunc);
            }
        });

        $("#next").click(function () {
            if (!$("#next").hasClass("disabled")) {
                var start = parseInt($(".paging-number:first").text()) + pagingInfo.pagingCount;
                var end = start + pagingInfo.pagingCount - 1;

                end = end > pagingInfo.totalPage ? pagingInfo.totalPage : end;

                $(".paging-number").remove();

                for (var i = end; i >= start; i--)
                    $("#prev").after("<li class='page-item paging-number'><a class='page-link' href='#'>" + i + "</a></li>");

                $("#prevFirst").removeClass("disabled");
                $("#prev").removeClass("disabled");

                if (end == pagingInfo.totalPage) {
                    $("#next").addClass("disabled");
                    $("#nextEnd").addClass("disabled");
                }

                pagingUtil.eventBinding(loadFunc);
            }
        });

        $("#nextEnd").click(function () {
            if (!$("#nextEnd").hasClass("disabled")) {
                $(".paging-number").remove();

                for (var i = pagingInfo.totalPage; i >= Math.floor(pagingInfo.totalPage / pagingInfo.pagingCount) * pagingInfo.pagingCount + 1; i--)
                    $("#prev").after("<li class='page-item paging-number'><a class='page-link' href='#'>" + i + "</a></li>");

                $("#prevFirst").removeClass("disabled");
                $("#prev").removeClass("disabled");
                $("#next").addClass("disabled");
                $("#nextEnd").addClass("disabled");

                pagingUtil.eventBinding(loadFunc);
            }
        });
    },
    eventBinding: function (loadFunc) {
        $(".paging-number > a").click(function (event) {
            event.preventDefault();
            $(".page-item").removeClass("active");
            $(this).parent().addClass("active");
            loadFunc(parseInt($(this).text()));
        })
    }
};