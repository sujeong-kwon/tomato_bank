<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
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
     #leftbox {
       float: left; 
       background: tomato;
       width: 30%;
       height: 1280px;
      }
     #middlebox{
       float: left; 
       background: Green;
       width: 40%;
       height: 1280px;
     }
     #rightbox{
       float: right;
       background: blue;
       width: 30%;
       height: 1280px;
     }
     .button-wrap{
       	height: 80%;
       	display: flex;
    	flex-direction: column;
   		justify-content: center;
   		align-items: center
     }
     .button{
    	width: 250px;
    	height: 150px;
    	background-color: white;
    	margin: 30px 30px 30px 30px;
    	
    	font-weight: bold;
    	color: black;
    	padding: 10px 16px;
    	font-size: 2rem;
    	border-radius: .5rem;
    	transition: all .15s cubic-bezier(0.4,0,0.2,1);
    	border: none;
    	cursor: pointer;
    	display: flex;
		align-items:center;
		text-align: center;
		line-height: 250px;
		justify-content: center;
     }
    .button > .in-btn {
      	line-height: 250px;
     	text-align: center;
    }
    .button > .in-btn:hover {
      	font-weight: normal;
      	color: tomato;
    }
    .logo_box{
      	width:  20px;
      	height: 20px;
      	margin-top: 30px;
    }
</style>
<body>
	<header>
    	<%@ include file="/incl/header.jsp" %>
	</header>
	<div id="boxes">   
       <div id="leftbox">
       		
       		<div class="button-wrap">
	       		<div class="button">
		            <a href="/banking/account/add_account" class="in-btn">계좌신청</a>
	   			</div >
	   			<div class="button">
		            <a href="/banking/account/list_account" class="in-btn">계좌조회</a>
	   			</div >
	  			<div class="button">
	  			</div>
       		</div>
       </div>       
       <div id="middlebox">
       	   <!--
       	   <div class="logo_box">
        		<img src="<spring:url value='/resources/img/tomato.png'/>">
    		</div> 
       	    -->
       </div>
       <div id="rightbox">
           <div class="button-wrap">
	       		<div class="button">
	   			</div >
	   			<div class="button">
	  			</div>
	  			<div class="button">
	  			</div>
       		</div>
       </div>
     </div>
</body>
</html>