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
body { overflow: auto; }

section {
  width: 100%;
  height: calc(100vh - 30px);
}
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 auto;
  flex-direction: column;
  padding-top: 150px;
}

.type{
  padding-top: 20px;
}

.box{
	display: block;
    width: 100%;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 30px 10px 30px;
    box-sizing: border-box;
    background: #fff;
    position: relative;
}
</style>
<body>
	<header>
	   	<%@ include file="/incl/header.jsp" %>
	</header>
	<section>
		<div class="container">
			<h3>신규 계좌 신청</h3>
			<form action="add_account" method="post">
				<div class="type">
				<label>SavingsAccount</label><input type="radio" name="accType" value="S"><br>
				<label>CheckingAccount</label><input type="radio" name="accType" value="C"><br>
				</div>					
				<label>초기입금액</label><input type="text" name="balance" class="box"></br>
				<label>비밀번호</label><input type="password" name="passwd" class="box">
				<input type="submit" value="신청"/>
			</form>
		</div>		
	</section>
</body>
</html>