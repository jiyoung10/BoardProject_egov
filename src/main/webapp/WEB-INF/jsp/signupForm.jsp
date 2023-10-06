<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
    <title>signup page</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .signup-container {
            width: 300px;
            padding: 20px;
            background-color: #f2f2f2;
            border-radius: 5px;
        }

        .signup-container h1 {
            text-align: center;
        }

        .signup-form input[type="text"],
        .signup-form input[type="password"] {
            width: 92%;
            padding: 10px;
            margin-bottom: 10px;
        }

        .signup-form button[type="submit"] {
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

<div class="signup-container">
    <h1>Signup</h1>

    <form class="signup-form" action="/signup.do" method="post">
    	<input type="hidden" id="USER_AUTHORITY" name="USER_AUTHORITY" value="ROLE_USER">
        <input type="text" id="USER_NAME" name="USER_NAME" placeholder="이름을 입력하시오.">
        <input type="text" id="USER_ID" name="USER_ID" placeholder="ID를 입력하시오.">
        <input type="password" id="USER_PASSWORD" name="USER_PASSWORD" placeholder="PASSWORD를 입력하시오.">
		<button type='submit'>회원가입</button>
    </form>
</div>

</body>
</html>
