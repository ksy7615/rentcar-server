<%@page import="rentcarServer.user.model.UserResponseDto"%>
<%@page import="rentcarServer.user.model.User"%>
<%@page import="java.util.ArrayList"%>
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
	<h1>내 문의내역</h1>
	<%
		BoardDao boardDao = BoardDao.getInstance();
		String id = (String) session.getAttribute("userId");
		List<BoardResponseDto> myBoard = boardDao.findBoardAllByUserId(id);
		%>
	<% for (BoardResponseDto board : myBoard) { %>
	<span><%= board.getBoardCode() %></span>
	<br>
	<span><a
		href="http://localhost:8080/viewBoard?boardCode=<%= board.getBoardCode() %>"><%= board.getTitle() %></a></span>
	<br>
	<span><%= board.getUserId() %></span>

	<c:if test="${id == board.userId }">
		<form method="POST" action="/updateBoard">
			<input type="hidden" name="boardCode" value="${board.boardCode}">
			<button type="submit">수정하기</button>
		</form>
	</c:if>
	<c:if test="${id == board.userId }">
		<form method="POST" action="/DeleteBoard">
			<input type="hidden" name="boardCode" value="${board.boardCode}">
			<button type="submit">삭제하기</button>
		</form>
	</c:if>
	<% }
    %>
</body>
</html>