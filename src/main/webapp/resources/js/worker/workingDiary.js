$(document).ready(function() {
    $ajax.request({
        url: "",
        method: "POST",
        data: JSON.stringify({ nowYearMonth: new Date().format("yyyy-MM") })
    }, function(err, res) {
        if (err) {
            alert("근무일지 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var workingDiaryCalendarInfo = res.contents;
        var eventsInfo = [];

        for(var i = 0; i < workingDiaryCalendarInfo.length; i++) {
            eventsInfo.push({
                title: workingDiaryCalendarInfo[i].name + "(" + new Date(workingDiaryCalendarInfo[i].workingStartDatetime).format("HH:mm") + "~" + new Date(workingDiaryCalendarInfo[i].workingEndDatetime) +  ")",
                start: workingDiaryCalendarInfo[i].workingStartDatetime.length
            });
        }

        $("div#working-diary-calendar").fullCalendar({
            height: 768,
            header: {
                left: "",
                center: "title"
            },
            monthNames: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
            dayNamesShort: ["일", "월", "화", "수", "목", "금", "토"],
            events: eventsInfo
        });
    });

    $("#attendWorkerModal").on("show.bs.modal", function(event) {
        $(".span-working-start-datetime").text(new Date().format("yyyy-MM-dd HH") + ":00");

        $("#working-end-timepicker").timepicker({
            timeFormat: "HH:mm",
            interval: 60,
            startTime: "00:00",
            maxTime: "23:00",
            defaultTime: new Date().format("HH"),
            dynamic: false,
            scrollbar: true
        });

        $("#working-contents").val("");
    });
});

var attendWorker = function() {
    var data = {
        workingStartDatetime: new Date($(".span-working-start-datetime").text()),
        workingEndDatetime: new Date(new Date().format("yyyy-MM-dd") + " " + $("#working-end-timepicker").val()),
        workingContents: $("#working-contents").val()
    };

    $ajax.request({
        url: "",
        method: "POST",
        data: JSON.stringify(data)
    }, function(err, res) {
        if (err) {
            alert("출근 도장 찍기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert(res.contents);
        location.reload();
    });

    console.log(data);
};