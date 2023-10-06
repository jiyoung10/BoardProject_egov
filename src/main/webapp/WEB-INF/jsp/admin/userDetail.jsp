<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>UserDetail page</title>
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
    <h1>이용자 관리</h1>
    <form class="signup-form" action="/admin/updateUserInfo.do" method="post">
      <label for ="USER_NAME">이용자 이름</label>
      <input type="text" class="form-control" id="USER_NAME"
      value="<c:out value="${user.USER_NAME}"/>" name="USER_NAME" />
	  <label for ="USER_ID">이용자 ID</label>
      <input type="text" class="form-control" id="USER_ID"
      value="<c:out value="${user.USER_ID}"/>" name="USER_ID" />
	  <label for ="USER_PASSWORD">이용자 PASSWORD</label>	
      <input type="text" class="form-control" id="USER_PASSWORD"
      value="<c:out value="${user.USER_PASSWORD}"/>" name="USER_PASSWORD" />
      <label for ="USER_AUTHORITY">이용자 AUTHORITY</label>	
      <input type="text" class="form-control" id="USER_AUTHORITY"
      value="<c:out value="${user.USER_AUTHORITY}"/>" name="USER_AUTHORITY" />

 	  <button type="submit">수정</button><br><br>
      <button type="button" onclick="location.href='<c:url value='/admin/deleteUserInfo?id=${user.USER_ID}'/>'">삭제</button><br><br>
      <button type="button" onclick="location.href='/admin/userList.do'">목록</button><br>
    </form>
</div>
</body>
</html>
