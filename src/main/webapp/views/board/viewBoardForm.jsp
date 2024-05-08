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
        if (boardCode != null) {
            BoardDao boardDao = BoardDao.getInstance();
            BoardResponseDto board = boardDao.findBoard(Integer.parseInt(boardCode));
            if (board != null) {
            	String boardTitle = board.getTitle();
                String boardContent = board.getContent();
    %>
                <div>
                	<p><%= boardTitle %></p>
                    <p><%= boardContent %></p>
                </div>
    <%
            }
        }
    %>
</body>
</html>