<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="/resources/css/navbar.css">
<script src="/resources/js/users/signout.js"></script>
<script src="/resources/js/navbar.js"></script>

<div class="navbar-box">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="/">PL Center</a>
        <buttion class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle Navigation">
            <span class="navbar-toggler-icon"></span>
        </buttion>

        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">공지사항</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">건의사항</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">상담예약</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${sessionInfo.userId}
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">회원정보</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" id="a-signout" href="#" onclick="signout()">로그아웃</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</div>