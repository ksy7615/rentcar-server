package rentcarServer.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.board.model.BoardDao;
import rentcarServer.board.model.BoardResponseDto;

public class BoardViewAction extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardCode = request.getParameter("boardCode");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
	
        if (boardCode != null) {
            BoardDao boardDao = BoardDao.getInstance();
            int boardId = Integer.parseInt(boardCode);
            
            BoardResponseDto board = boardDao.findBoard(boardId);
            
            request.setAttribute("userId", id);
            request.setAttribute("board", board);
            request.setAttribute("boardCode", board.getBoardCode());
            
            request.getRequestDispatcher("/viewBoard").forward(request, response);
        } else {
        	response.sendRedirect("/board");
        }
	}

}
