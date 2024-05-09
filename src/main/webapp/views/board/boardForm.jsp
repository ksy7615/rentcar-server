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
<link rel="stylesheet" href="/resources/style/board.css">
<body>
	<section id="board">
		<h1>게시판</h1>

		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="board" items="${boardList }">
				<tr>
					<td>${board.boardCode }</td>
					<td><a href="/board/view?boardCode=${board.boardCode }">${board.title }</a></td>
					<td>${board.userId }</td>
					<td>${board.regDate }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	<button onclick="location.href='/writeBoard'">게시물 작성</button>
	
	</section>
</body>
<c:import url="/footer" />
</html>