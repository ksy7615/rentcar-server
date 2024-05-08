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
	<%
        String boardCode = request.getParameter("boardCode");
		String id = (String) session.getAttribute("userId");
	
        if (boardCode != null) {
            BoardDao boardDao = BoardDao.getInstance();
            int boardId = Integer.parseInt(boardCode);
            BoardResponseDto board = boardDao.findBoard(boardId);
            if (board != null) {
            	String userId = board.getUserId();
            	String boardTitle = board.getTitle();
                String boardContent = board.getContent();
    %>
	<div>
		<p><%= boardTitle %></p>
		<p><%= boardContent %></p>
	</div>
	<c:if test="${user.userId == userId }">
		<form method="POST" action="/updateBoard">
			<input type="hidden" name="boardCode" value="${boardId}">
			<button type="submit">수정하기</button>
		</form>
	</c:if>
	<c:if test="${user.userId == userId }">
		<form method="POST" action="/DeleteBoard" >
			<input type="hidden" name="boardCode" value="${boardId}">
			<button type="submit">삭제하기</button>
		</form>
	</c:if>
	<%
            }
        }
    %>
</body>
</html>