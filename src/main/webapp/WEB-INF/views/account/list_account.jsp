<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>계좌 목록</h3>
	<table border="1" class="review">
      <thead>
        <tr>
          <th colspan="4">계좌</th>
        </tr>
      </thead>
      <tbody>  
	<c:forEach var="acc" items="${account}">
         <tr class ="review-header">
          <td>계좌번호</td>
          <td>타입</td>
          <td>잔액</td>
          <td>이체</td>
        </tr>
         <tr class="review-title">
           <td>${acc.accountNum}</td>
           <td>${acc.accType}</td>
           <td>${acc.balance}</td>
           <td><a href="/banking/account/transfer_account?aid=${acc.aid}&accType=${acc.accType}" class="in-btn">이체하기</a></td>
         </tr>
    </c:forEach>
    </tbody>
    </table>
</body>
</html>