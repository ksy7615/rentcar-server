package rentcarServer.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcarServer.board.model.BoardDao;
import rentcarServer.board.model.BoardRequestDto;
import rentcarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class WriteFormAction
 */
@WebServlet("/WriteFormAction")
public class WriteFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteFormAction() {
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

		// Processing Page 에서는 사용자에게 보여주는 화면을 작성하지 않음 
		// 요청에 대한 응답 처리를 작성 
		// 1) 페이지 이동 처리 (흐름을 제어)
		if (isValid) {
			// 연동된 데이터 베이스로부터 
			// 유저의 정보를 조회 하고,
			// 중복에 대한 검증을 한 후에
			// 가입 처리 후, 페이지 이동
			
			BoardRequestDto boardDto = new BoardRequestDto(Integer.parseInt(boardCode), userId, title, content);
			BoardDao boardDao = BoardDao.getInstance();
			BoardResponseDto board = boardDao.createBoard(boardDto);
			if (board == null) {
				System.out.println("문의등록 실패");
				//저장 실패
				response.sendRedirect("/");
			} else {
				//저장 성공
				System.out.println("board : " + board);
				response.sendRedirect("/mypage");
			}
		} else
			response.sendRedirect("/board");
	}

}
