package rentcarServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.board.model.BoardDao;
import rentcarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class ViewBoardFormAction
 */
@WebServlet("/ViewBoardFormAction")
public class ViewBoardFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBoardFormAction() {
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
		int boardCode =  Integer.parseInt(request.getParameter("boardCode")) ;
		BoardDao boardDao = BoardDao.getInstance();
		BoardResponseDto board = boardDao.findBoard(boardCode);
		System.out.println(board.getBoardCode());
		
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		response.sendRedirect("/viewBoard");
	}

}
