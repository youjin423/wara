<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	body {
		margin: 0;
		padding: 0;
	}
</style>
<!DOCTYPE html>
<html>
<head>
<title>header</title>
</head>
<body>
	<a href="#" class="w3-bar-item w3-button w3-red w3-mobile"><i class="fa fa-bed w3-margin-right"></i>Logo</a>
  <a href="#rooms" class="w3-bar-item w3-button w3-mobile">Rooms</a>
  <a href="#about" class="w3-bar-item w3-button w3-mobile">About</a>
  <a href="#contact" class="w3-bar-item w3-button w3-mobile">Contact</a>
  
	<c:if test="${empty authInfo}">
	<a class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile" href="<c:url value="/owner" />">[가맹점 로그인]</a>
	 <a class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile" href="<c:url value="/register/step1" />">[회원 가입하기]</a>
    <a class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile" href="<c:url value="/login" />">[로그인]</a>
   
    </c:if>
    
    <c:if test="${! empty authInfo}">
    <a class="w3-bar-item w3-button w3-right w3-light-grey href="<c:url value="/mypage" />">[마이페이지]</a>
    <a class="w3-bar-item w3-button w3-right w3-light-grey href="<c:url value="/logout" />">[로그아웃]</a>
    </c:if>
</body>
</html>