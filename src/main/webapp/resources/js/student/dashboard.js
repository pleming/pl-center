$(document).ready(function() {
    $ajax.request({
        url: "/counsel/loadPlCertificated",
        method: "GET"
    }, function(err, res) {
        if (err) {
            alert("상담내역 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var plCertificatedInfo = res.contents;

        var plCertificatedTemplate1 = "<div class='card card-pl-certificated'>" +
                                            "<div class='card-header text-center'>프로그래밍언어지원센터 상담확인증</div>" +
                                            "<div class='card-body'>" +
                                                    "<div class='div-student-info'>";

        var plCertificatedTemplate2 = "</div>" +
                                        "<div class='div-student-info-header'>" +
                                                "<div>" +
                                                    "학번 : <br>" +
                                                    "학과 : <br>" +
                                                    "분반 : <br>" +
                                                    "이름 : <br>" +
                                                "</div>" +
                                        "</div>" +
                                        "<div class='div-pl-certificated-contents text-center'>";

        var plCertificatedTemplate3 = "<br>" +
                                        "지원센터를 이용하였음을 확인합니다." +
                                    "</p>" +
                                    "<p>";

        var plCertificatedTemplate4 = "</p>" +
                                    "</div>" +
                                    "<div class='div-pl-certificated-counselor'>" +
                                    "<p>";

        var plCertificatedTemplate5 = "</p>" +
                                    "</div>" +
                                "</div>" +
                                "<div class='card-footer text-center'>PL Center Certificated.</div>" +
                            "</div>"


        for(var i = 0; i < plCertificatedInfo.length; i++) {
            plCertificatedInfo[i].counselDatetime = new Date(plCertificatedInfo[i].counselDatetime);

            $(".div-pl-certificated").append(
                plCertificatedTemplate1 +

                "<span id='student-code'>" + plCertificatedInfo[i].name + "</span><br>" +
                "<span id='dept'>" + plCertificatedInfo[i].dept + "</span><br>" +
                "<span id='class-div'>" + plCertificatedInfo[i].year + "-" + plCertificatedInfo[i].semester + "(0" + plCertificatedInfo[i].classNo + ")</span><br>" +
                "<span id='student-name'>" + plCertificatedInfo[i].name + "</span><br>" +

                plCertificatedTemplate2 +

                "<p class='card-text'>위 학생은 " + "<span id='year'>" + plCertificatedInfo[i].year + "</span>학년도 <span id='semester'>" + plCertificatedInfo[i].semester + "</span>학기 프로그래밍 언어" +

                plCertificatedTemplate3 +

                "<span id='counsel_datetime'>" + plCertificatedInfo[i].counselDatetime.format("yyyy") + "년 " + plCertificatedInfo[i].counselDatetime.format("MM") + "월 " + plCertificatedInfo[i].counselDatetime.format("dd") + "일</span>" +

                plCertificatedTemplate4 +

                "상담내용 : <span id='counsel-contents'>" + plCertificatedInfo[i].counselContents + "</span><br>" +
                "상담자 : <span id='counselor-name'>" + plCertificatedInfo[i].counselorName + "</span>" +

                plCertificatedTemplate5
            );
        }
    });
});