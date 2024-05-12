package rentcarServer.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.board.model.BoardDao;
import rentcarServer.board.model.BoardRequestDto;
import rentcarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class DeleteFormAction
 */
public class DeleteBoardFormAction extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BoardDao boardDao = BoardDao.getInstance();
		String boardCode = request.getParameter("boardCode");
		int boardId = Integer.parseInt(boardCode);
		
		boardDao.deleteBoard(boardId);
		response.sendRedirect("/board");
	}
}
