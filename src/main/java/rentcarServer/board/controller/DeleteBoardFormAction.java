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
@WebServlet("/DeleteBoardFormAction")
public class DeleteBoardFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBoardFormAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		BoardDao boardDao = BoardDao.getInstance();
		List<BoardResponseDto> list = boardDao.findBoardAll();
		String id = (String) session.getAttribute("userId");
		String boardCode = (String) session.getAttribute("boardCode");
		
		boolean result = false;
		for (BoardResponseDto board : list) {
			if (board.getUserId().equals(id)) {
				request.setAttribute("board", board);						
				int boardId = board.getBoardCode();
				BoardRequestDto boardDto = new BoardRequestDto();
				result = boardDao.deleteBoard(boardDto);
			}
		}
		
		if (result) {
			session.removeAttribute("board");
			request.getRequestDispatcher("/viewBoard").forward(request, response);
		} else {
			response.sendRedirect("/board");
		}
	}

}
