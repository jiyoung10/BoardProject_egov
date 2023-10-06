<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"      uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></head>
<body>
<div class="container">
  <h2>게시판 글쓰기</h2>
  <form action="/user/writeContent.do" method="post" enctype="multipart/form-data">
  	<div class="form-group">
      <label for="WRITER">작성자</label>
      <input type="text" class="form-control" id="WRITER" 
      value="<sec:authentication property="principal.username"/>" name="WRITER" />
    </div>
    <div class="form-group">
      <label for="TITLE">제목</label>
      <input type="text" class="form-control" id="TITLE" 
      placeholder="제목 입력(4-100)" name="TITLE"
       maxlength="100"
       pattern=".{4,100}" />
    </div>
    <div class="form-group">
	   <label for="CONTENT">내용</label>
	   <textarea class="form-control" rows="5" id="CONTENT" style="resize:none"
	   name="CONTENT" placeholder="내용 작성"></textarea>
 	</div>
 	<div class="form-group">
      <label for="FILE">파일첨부</label>
      <input type="file" id="FILE" name="FILE" />
    </div><br>
 
    <button type="submit" class="btn btn-default">등록</button>
    <button type="button" onclick="location.href='/boardList.do'" class="btn btn-default">목록</button>
    </form>
</div>
</body>
</html>