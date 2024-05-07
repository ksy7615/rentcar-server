<%@page import="rentcarServer.board.model.BoardDao"%>
<%@page import="rentcarServer.board.model.BoardResponseDto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header" />
<body>
	<section id="board">
		<h1>게시판</h1>

		<table border="1">
			<tr>번호</tr>
			<tr>제목</tr>
			<tr>작성자</tr>
			<tr>작성일</tr>
		</table>
		<%
		BoardDao boardDao = BoardDao.getInstance();
		List<BoardResponseDto> boardList = boardDao.findBoardAll();
		%>
		<% for (BoardResponseDto board : boardList) { %>
        <tr>
            <td><%= board.getBoardCode() %></td>
            <td><a href="http://localhost:8080/viewBoard?id=<%= board.getBoardCode() %>"><%= board.getTitle() %></a></td>
            <td><%= board.getUserId() %></td>
        </tr>
    <% } %>
		
	<button onclick="location.href='/write'">게시물 작성</button>
	
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>