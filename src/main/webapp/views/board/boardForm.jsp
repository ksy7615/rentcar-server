<%@page import="rentcarServer.board.model.BoardResponseDto"%>
<%@page import="rentcarServer.board.model.BoardDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<h1>문의사항</h1>
	<section id="board">

		<table border="1">
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
			</tr>
			<%
			List<BoardResponseDto> list = (List) session.getAttribute("list");
			for(BoardResponseDto board : list) {
			%>
			<tr>
				<td><%=board.isAdmin() ? "공지" : board.getBoardCode()%></td>
				<td><%=board.getUserId()%></td>
				<td><a href="/detail?boardCode=<%=board.getBoardCode()%>">
						<%=board.getTitle()%>
				</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<button onclick="location.href='/write'">게시물 작성</button>

	</section>
</body>
</html>