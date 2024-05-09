package rentcarServer.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.board.model.BoardDao;
import rentcarServer.board.model.BoardRequestDto;
import rentcarServer.board.model.BoardResponseDto;

public class UpdateBoardFormAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String boardCode = request.getParameter("boardCode");

		// 보드 코드에 해당하는 게시글을 찾습니다.
		BoardDao boardDao = BoardDao.getInstance();
		BoardResponseDto board = boardDao.findBoard(Integer.parseInt(boardCode));

		// 수정 화면으로 보낼 데이터를 설정합니다.
		request.setAttribute("board", board);

		// JSP로 포워딩합니다.
		request.getRequestDispatcher("/updateBoardForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String userId = (String) session.getAttribute("userId");
		String boardCode = request.getParameter("boardCode");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		System.out.println("boardCode: " + boardCode);
		System.out.println(userId);
		System.out.println(title);
		System.out.println(content);

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

			if (board == null) {
				// 저장 실패
				response.sendRedirect("/board");
			} else {
				// 저장 성공
				System.out.println("수정이 완료되었습니다.");

				session.setAttribute("board", board);
				request.getRequestDispatcher("/viewBoard?boardCode=" + board.getBoardCode()).forward(request, response);
			}
		} else
			response.sendRedirect("/board");
	}
}
