$(document).ready(function() {
    var data = {
        id: Number($("input[name=class-id]").val())
    };

    $ajax.request({
        url: "/class/loadClassById",
        method: "POST",
        data : JSON.stringify(data)
    }, function (err, res) {
        if (err || res.status == false) {
            alert("분반 정보 불러오기를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        var classInfo = res.contents;
        var year = new Date().getFullYear();

        $("select#year").append("<option value='-1'>연도</option>");
        $("select#semester").append("<option value='-1'>학기</option>");
        $("select#class-no").append("<option value='-1'>분반</option>");

        for(var i = 2011; i <= year; i++)
            $("select#year").append("<option value='" + i + "'>" + i + "년</option>");

        $("select#year").val(classInfo.year);

        for(var i = 1; i <= 2; i++)
            $("select#semester").append("<option value='" + i + "'>" + i + "학기</option>");

        $("select#semester").val(classInfo.semester);

        for(var i = 1; i <= 9; i++)
            $("select#class-no").append("<option value='" + i + "'>" + i + "분반</option>");

        $("select#class-no").val(classInfo.classNo);
    });
});

var modClassInfo = function() {
    if(!confirm("분반 정보를 수정하시겠습니까?"))
        return;

    var data = {
        id: Number($("input[name=class-id]").val()),
        year: Number($("select#year").val()),
        semester: Number($("select#semester").val()),
        classNo: Number($("select#class-no").val())
    };

    if(data.year == -1) {
        alert("연도를 선택해주세요.");
        return;
    }

    if(data.semester == -1) {
        alert("학기를 선택해주세요.");
        return;
    }

    if(data.classNo == -1) {
        alert("분반을 선택해주세요.");
        return;
    }

    $ajax.request({
        url: "/class/modClass",
        method: "POST",
        data : JSON.stringify(data)
    }, function (err, res) {
        if (err || res.status == false) {
            alert("분반 수정을 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        alert("분반 수정이 완료되었습니다.");
    });
};

var removeClassInfo = function() {
    if(!confirm("분반을 삭제하시겠습니까?"))
        return;

    $ajax.request({
        url: "/class/removeClass/",
        method: "POST",
        data: JSON.stringify({id: Number($("input[name=class-id]").val())})
    }, function (err, res) {
        if (err || res.status == false) {
            alert("분반 삭제를 실패하였습니다. 관리자에게 문의해주세요.");
            return;
        }

        location.href = "/lecturer/class";
    });
};
