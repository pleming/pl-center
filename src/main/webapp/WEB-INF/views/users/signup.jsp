<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/resources/jsp/header.jsp" %>
    <script src="/resources/js/users/signup.js"></script>
    <title>PL Center - 회원가입</title>
</head>
<body>
<div>
    <label>아이디 </label>
    <input type="text" name="userId"/>
</div>
<div>
    <label>비밀번호 </label>
    <input type="password" name="passwd"/>
</div>
<div>
    <label>비밀번호 확인 </label>
    <input type="password" name="chkPasswd"/>
</div>
<div>
    <label>단과대학 </label>
    <select id="col"></select>
</div>
<div>
    <label>학과 </label>
    <select id="dept"></select>
</div>
<div>
    <label>학번 </label>
    <input type="text" name="studentCode">
</div>
<div>
    <label>이름 </label>
    <input type="text" name="name"/>
</div>
<div>
    <label>이메일 </label>
    <input type="text" name="email"/>
</div>
<div>
    <label>전화번호 </label>
    <input type="text" name="phone"/>
</div>
<div>
    <button onclick="signup()">회원가입</button>
</div>
</body>
</html>
