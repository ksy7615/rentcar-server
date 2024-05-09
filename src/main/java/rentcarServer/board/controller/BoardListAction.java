package rentcarServer.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcarServer.board.model.BoardDao;
import rentcarServer.board.model.BoardResponseDto;

public class BoardListAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao boardDao = BoardDao.getInstance();
		List<BoardResponseDto> boardList = boardDao.findBoardAll();
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/list");
		dispatcher.forward(request, response);
	}
}
