<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
    <title>userRegister page</title>
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

        .signup-form button[type="submit"],
        .signup-form button[type="button"] {
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
    <h1>User register</h1>

    <form class="signup-form" action="/admin/registerUser.do" method="post">
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="text" id="USER_NAME" name="USER_NAME" placeholder="이름을 입력하시오.">
        <input type="text" id="USER_ID" name="USER_ID" placeholder="ID를 입력하시오.">
        <input type="password" id="USER_PASSWORD" name="USER_PASSWORD" placeholder="PASSWORD를 입력하시오.">
		
		<div>
        <label for="ROLE_USER">User</label>
        <input type="checkbox" name ="USER_AUTHORITY" value="ROLE_USER" id ="ROLE_USER"/>
        <label for="ROLE_ADMIN">Admin</label>
        <input type="checkbox" name ="USER_AUTHORITY" value="ROLE_ADMIN" id ="ROLE_ADMIN"/>
    </div><br>
		
		<button type="submit">이용자 등록</button><br><br>
		<button type="button" onclick="location.href='/admin/userList.do'">목록</button>
    </form>
</div>

</body>
</html>
