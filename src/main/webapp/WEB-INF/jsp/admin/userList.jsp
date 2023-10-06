<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"      uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/board/board.css'/>"/>
<meta charset="UTF-8">
<title>User list</title>
</head>
<body>
  <div class="container">
  <h2>이용자 목록</h2>
    <table class="board_list">
      <colgroup>
        <col width="15%"/>
        <col width="*"/>
        <col width="15%"/>
        <col width="20%"/>
      </colgroup>
      <thead>
        <tr>
          <th scope="col">이용자 이름</th>
          <th scope="col">이용자 ID</th>
          <th scope="col">이용자 PASSWORD</th>
          <th scope="col">이용자 AUTHORITY</th>
        </tr>
      </thead>
      <tbody>
		<c:forEach items="${list}" var="user">
		    <tr>
		        <td><c:out value="${user.USER_NAME}"/></td>
		        <td class="totle" ><a href="<c:url value='/admin/userDetail?id=${user.USER_ID}'/>">
		        <c:out value="${user.USER_ID}"/></a></td>
		        <td><c:out value="${user.USER_PASSWORD}"/></td>
		        <td><c:out value="${user.USER_AUTHORITY}"/></td>
		    </tr>
		</c:forEach>
        
        <tr th:unless="${#lists.size(list)} > 0">
          <td colspan="4">조회된 결과가 없습니다.</td>
        </tr>
      </tbody>
    </table>
    <a href="/admin/registerUser.do" class="btn">이용자 등록</a>
  </div>
</body>
</html>