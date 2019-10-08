<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>wara :: 로그인 페이지</title>
</head>
<body>
	  <form:form modelAttribute="loginCommand">
    <form:errors />
    <p>
      	아이디:<br>
        <form:input path="id" />
        <form:errors path="id"/>
    </p>
    <p>
      	 비밀번호:<br>
        <form:password path="password" />
        <form:errors path="password"/>
    </p>
    <p>
     	아이디 저장 :
        <form:checkbox path="rememberId"/> 
    </p>
    <input type="submit" value="로그인" />
    </form:form>
</body>
</html>