package rentcarServer.board.controller;

import java.io.IOException;

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
 * Servlet implementation class UpdateBoardFormAction
 */
@WebServlet("/UpdateBoardFormAction")
public class UpdateBoardFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String boardCode = request.getParameter("boardCode");
		String userId = request.getParameter("userId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// Backend 에서 전달받은 데이터에 대한 유효성 검증
		boolean isValid = true;

		if (boardCode == null || boardCode.equals(""))
			isValid = false;
		else if (userId == null || userId.equals(""))
			isValid = false;
		else if (title == null || title.equals(""))
			isValid = false;
		else if (content == null || content.equals(""))
			isValid = false;

		if (isValid) {
			BoardDao boardDao = BoardDao.getInstance();

			BoardRequestDto boardDto = new BoardRequestDto(Integer.parseInt(boardCode), userId, title, content);
			BoardResponseDto board = boardDao.updateBoard(boardDto);

			HttpSession session = request.getSession();

			if (board == null) {
				// 저장 실패
				response.sendRedirect("/board");
			} else {
				// 저장 성공
				System.out.println("수정이 완료되었습니다.");

				session.setAttribute("board", board);
				response.sendRedirect("/viewBoard?boardCode=" + board.getBoardCode());
			}
		} else
			response.sendRedirect("/board");
	}
}
