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
import rentcarServer.user.model.UserResponseDto;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardDao boardDao = BoardDao.getInstance();
		HttpSession session = request.getSession();
		UserResponseDto user = (UserResponseDto) session.getAttribute("user");
		
		String userId = user.getUserId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(userId);
		System.out.println(title);
		System.out.println(content);

		// Backend 에서 전달받은 데이터에 대한 유효성 검증 
		boolean isValid = true;

		if (userId == null || userId.equals(""))
			isValid = false;
		else if (title == null || title.equals(""))
			isValid = false;
		else if (content == null || content.equals(""))
			isValid = false;

		if (isValid) {			
			BoardRequestDto boardDto = new BoardRequestDto();
			
			boardDto.setUserId(userId);
			boardDto.setTitle(title);
			boardDto.setContent(content);
			
			BoardResponseDto board = boardDao.createBoard(boardDto);
			session.setAttribute("board", board);
			
			if (board == null) {
				System.out.println("문의등록 실패");
				//저장 실패
				response.sendRedirect("/main");
			} else {
				//저장 성공
				System.out.println("board : " + board);
				response.sendRedirect("/viewBoard?boardCode=" + board.getBoardCode());
			}
		} else
			response.sendRedirect("/board");
	}

}
