<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h3>회원가입 성공!</h3>
	<label>E-mail : </label>${customer.email}<br>
	<label>비밀번호 : </label>${customer.passwd}<br>
	<label>이름 : </label>${customer.name}<br>
	<label>주민번호 : </label>${customer.ssn}<br>
	<label>연락처 : </label>${customer.phone}<br>
	<h3>로그인</h3>
	<form action="login" method="post">
		<label>아이디</label><input type="text" name="userId"><br>
		<label>비밀번호</label><input type="password" name="passwd"><br>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>