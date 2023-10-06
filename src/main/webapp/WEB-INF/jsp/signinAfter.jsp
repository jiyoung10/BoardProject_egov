<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Main Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        .menu-bar {
            background-color: #f2f2f2;
            padding: 10px;
			display: flex;
			justify-content: space-between;
			align-items: center;
		}

        .menu-bar ul {
            list-style-type: none;
			margin-left:auto; 
			padding-right :20px
        }

        .menu-bar li {
            display: inline-block;
			margin-right :10px
        }

        .menu-bar a {
			text-decoration:none; 
			color:#333333; 
			padding :5px 10px
		}
    </style>
</head>
<body>
<sec:authorize access="isAuthenticated()">
<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<div class="menu-bar">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <ul>
    	<li><a><sec:authentication property="principal.username"/> 님</a></li>
	    <li><a href="/logout.do">로그아웃</a></li>
   	    <li><a href="/admin/adminPage.do">관리자 페이지</a></li>
	    <li><a href="/boardList.do">게시판</a></li>
    </ul> 
</div>

<div align="center">
<h1>Main Page</h1>
</div>


</body>
</html>