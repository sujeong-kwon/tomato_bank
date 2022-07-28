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
		<h3>계좌 이체</h3>
		<div class="container">
			<form action="transfer_account" method="post">		
				<label>출금계좌</label><input type="text" placeholder="${account.accountNum}"></br>
				<label>출금액</label><input type="password" name="passwd">
				<input type="submit" value="신청"/>
			</form>
		</div>
	</section>
</body>
</html>