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

.container{
  width: 100%;
  height: calc(100vh - 30px);
}

.center{
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 auto;
  flex-direction: column;
  padding-top: 150px;
  
}

.card {
  width: 450px;
  height: 250px;
  border-radius: 6px;
  overflow: hidden;
  position: relative;
  margin: 1.5rem;
  background: beige;
}

.type{
  text-align: left;
  padding-left: 30px;
  padding-top: 20px;
}

.text-wrap{
  text-align: center;
}

.num{
  padding-top: 45px;
  color: gray;
}

.balance{
  padding-bottom: 45px;
}


</style>
<body>
	 <header>
	 	<%@ include file="/incl/header.jsp" %>	
	 </header>
     <div class="container">
      <div class="center">
		    <c:forEach var="acc" items="${account}">
			  <div class="card">
			  	<div class="text-wrap">
			  	  <h2 class="type">${acc.accType}</h2>
			  	  <h4 class="num">${acc.accountNum}</h4>
			      <h1 class="balance">${acc.balance}</h1>
			     <a href="/banking/account/transfer_account?aid=${acc.aid}&accType=${acc.accType}" class="transfer">이체하기</a>	 
			  	</div>   
			  </div>
			  </c:forEach>
		</div>
    </div>
</body>
</html>