package rentcarServer.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentcarServer.util.DBConnection;

public class BoardDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDao() {

	}

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	public List<BoardResponseDto> findBoardAll() {
		List<BoardResponseDto> list = new ArrayList<BoardResponseDto>();
		conn = DBConnection.getConnection();
		String sql = "SELECT board_code,user_id,title,content,admin,reg_date FROM board order by admin desc , reg_date desc;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int boardCode = rs.getInt(1);
				String userId = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				boolean admin = rs.getBoolean(5);
				Timestamp reg_date = rs.getTimestamp(6);
				BoardResponseDto board = new BoardResponseDto(boardCode, userId, title, content, admin, reg_date);
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}

		return list;

	}

	public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
		conn = DBConnection.getConnection();

		BoardResponseDto board = null;
		String userId = boardRequestDto.getUserId();
		String title = boardRequestDto.getTitle();
		String content = boardRequestDto.getContent();

		String sql = "INSERT INTO board (user_id, title, content, admin) VALUES (?, ?, ?, (SELECT admin FROM users where user_id = ?))";

		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, userId);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, userId);

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int boardId = rs.getInt(1);
				board = findBoard(boardId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return board;
	}

	private BoardResponseDto findBoard(int boardId) {
		conn = DBConnection.getConnection();
		BoardResponseDto board = null;
		String sql = "SELECT board_code, user_id, title, content, admin FROM board WHERE board_code = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int boardCode = rs.getInt(1);
				String userId = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				boolean admin = rs.getBoolean(5);

				board = new BoardResponseDto(boardCode, userId, title, content, admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	public boolean deleteBoard(BoardRequestDto boardRequestDto) {
		if (findBoard(boardRequestDto.getBoardCode()) == null) {
			return false;
		}

		try {
			String sql = "DELETE FROM board WHERE board_code=? AND user_id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardRequestDto.getBoardCode());
			pstmt.setString(2, boardRequestDto.getUserId());

			pstmt.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt);
		}
		return false;
	}

	public BoardResponseDto updateBoard(BoardRequestDto boardDto) {
		BoardResponseDto board = null;

		if (findBoard(boardDto.getBoardCode()) == null) {
			return board;
		}

		try {
			conn = DBConnection.getConnection();

			String sql = "UPDATE board SET title=? content=? WHERE board_code=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getTitle());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getBoardCode());

			pstmt.execute();

			board = findBoard(boardDto.getBoardCode());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	
//	public void updateBoard(BoardRequestDto board) {
//		conn = DBConnection.getConnection();
//		String sql = "UPDATE board SET title = ? , content = ? WHERE board_code = ?";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, board.getTitle());
//			pstmt.setString(2, board.getContent());
//			pstmt.setInt(3, board.getBoardCode());
//			
//			pstmt.execute();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBConnection.close(conn, pstmt);
//		}
//		
//	}

}
