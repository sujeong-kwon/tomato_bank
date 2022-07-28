<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>"/>
</head>
<style>
	@font-face {
	  src: url("/chacha/css/Jalnan.ttf");
	  font-family: "Jalnan";
	}
	.gnb ul li a {
	  line-height: 70px;
	  font-size: 20px;
	  color: white;
	  font-family: "Jalnan";
	} 

    section {
      height: 100%;
      overflow: hidden;
      padding-top: 150px;
    }
    .container {
      display: flex;
      flex-wrap: wrap;
      height: 100%;
      width: 700px;
      margin: 0 auto;
      align-items: center;
    }
</style>
<body>
	<header>
	   	<%@ include file="/incl/header.jsp" %>
	</header>
	<section>
		<h3>신규 계좌 신청</h3>
		<div class="container">
			<form action="add_account" method="post">		
				<label>SavingsAccount</label><input type="radio" name="accType" value="S"><br>
				<label>CheckingAccount</label><input type="radio" name="accType" value="C"><br>
				<label>초기입금액</label><input type="text" name="balance"></br>
				<label>비밀번호</label><input type="password" name="passwd">
				<input type="submit" value="신청"/>
			</form>
		</div>
	</section>
</body>
</html>