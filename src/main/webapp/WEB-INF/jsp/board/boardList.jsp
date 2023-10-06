<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/board/board.css'/>"/>
<meta charset="UTF-8">
<title>Board list</title>
</head>
<body>
  <div class="container">
  <h2>게시판 목록</h2>
  	<form action="/searchContentByKeyword?keyword={keyword}" method="get">
<%--   	<form action="<c:url value='/searchContentByKeyword/'/>${keyword}" method="post"> --%>
  	<div>
	 	<input type="text" id="keyword" name="keyword" placeholder="검색어를 입력하시오."/>
		<button type="submit" class="btn btn-default">검색</button>
  	</div>
  
    <table class="board_list">
      <colgroup>
        <col width="15%"/>
        <col width="*"/>
        <col width="20%"/>
        <col width="20%"/>
      </colgroup>
      <thead>
        <tr>
          <th scope="col">글번호</th>
          <th scope="col">제목</th>
          <th scope="col">작성일</th>
          <th scope="col">수정일</th>
        </tr>
      </thead>
      <tbody>
		<c:forEach items="${list}" var="board">
		    <tr>
		        <td><c:out value="${board.BNO}"/></td>
		        <td align="center" class="title" ><a href="<c:url value='/user/boardDetail?bno=${board.BNO}'/>">
		        <c:out value="${board.TITLE}"/></a></td>
		        <td><c:out value="${board.REGDATE}"/></td>
		        <td><c:out value="${board.MODIDATE}"/></td>
		    </tr>
		</c:forEach>
        
        <tr th:unless="${#lists.size(list)} > 0">
          <td colspan="4">조회된 결과가 없습니다.</td>
        </tr>
        
      </tbody>
    </table>
    <a href="user/boardForm" class="btn">글 쓰기</a>
    <a href="signinAfter.do" class="btn">메인 페이지</a>
   </form>
  </div>
</body>
</html>