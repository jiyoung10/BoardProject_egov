<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
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

<div class="menu-bar">
    <ul>
	    <li><a href="/admin/registerUser.do">이용자 등록</a></li>
	    <li><a href="/admin/userList.do">이용자 관리</a></li>
	    <li><a href="/logout.do">로그아웃</a></li>
	    <li><a href="signinAfter.do" class="btn">메인 페이지</a></li>
	    
    </ul> 
</div>

<div align="center">
<h1>Admin Page</h1>
</div>