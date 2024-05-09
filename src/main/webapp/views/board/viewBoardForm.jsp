<%@page import="rentcarServer.board.model.BoardRequestDto"%>
<%@page import="rentcarServer.board.model.BoardResponseDto"%>
<%@page import="java.util.List"%>
<%@page import="rentcarServer.board.model.BoardDao"%>
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
	<h1>게시글 확인</h1>
	<div>
		<p>${board.boardCode }</p>
		<p>${requestScope.board.title }</p>
		<p>${board.content }</p>
		
	<c:if test="${board.userId eq user.userId}">
		<form method="POST" action="/updateBoard?boardCode=${board.boardCode}">
			<input type="hidden" name="boardCode" value="${board.boardCode}">
			<button type="submit">수정하기</button>
		</form>
	</c:if>
	<c:if test="${board.userId eq user.userId}">
		<form method="POST" action="/DeleteBoard?boardCode=${board.boardCode}" >
			<input type="hidden" name="boardCode" value="${board.boardCode}">
			<button type="submit">삭제하기</button>
		</form>
	</c:if>
	</div>
</body>
</html>