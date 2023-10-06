<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
    <title>signin page</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .signin-container {
            width: 300px;
            padding: 20px;
            background-color: #f2f2f2;
            border-radius: 5px;
        }

        .signin-container h1 {
            text-align: center;
        }

        .signin-form input[type="text"],
        .signin-form input[type="password"] {
            width: 92%;
            padding: 10px;
            margin-bottom: 10px;
        }

        .signin-form button[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #878787; /* Gray */
    		    color:white; 
    		    border:none; 
    		    cursor:pointer; 
    		    text-align:center; 
    		    text-decoration:none
     	  }
    </style>
</head>
<body>

<div class="signin-container">
    <h1>Signin</h1>

    <form class="signin-form" action="/signin.do" method="post">
<%--     	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
        <input type="text" id="userId" name="userId" placeholder="ID를 입력하시오.">
        <input type="password" id="userPassword" name="userPassword" placeholder="PASSWORD를 입력하시오.">
		<button type='submit'>로그인</button>
    </form>
</div>

</body>
</html>
