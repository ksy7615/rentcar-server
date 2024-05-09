<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<c:import url="/header" />
<body>
<h1>문의 수정</h1>
	<form method="POST" action="/UpdateBoardAction?boardCode=${board.boardCode}">
		<input type="hidden" name="boardCode" value="${board.boardCode}">
		<input type="text" name="title" placeholder="제목을 입력하세요.">
		<input type="text" name="content" placeholder="내용을 입력하세요.">
		
		<input type="submit" value="수정하기">
	</form>
</body>
</html>