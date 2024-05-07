package rentcarServer.board.model;

import java.sql.Timestamp;

public class BoardResponseDto {

	private int boardCode;
	private String userId;
	private String title;
	private String content;
	private boolean admin;
	private Timestamp regDate;
	
	public BoardResponseDto(int boardCode, String userId, String title, String content, boolean admin) {
		super();
		this.boardCode = boardCode;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.admin = admin;
	}

	public BoardResponseDto(int boardCode, String userId, String title, String content, boolean admin,
			Timestamp regDate) {
		super();
		this.boardCode = boardCode;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.admin = admin;
		this.regDate = regDate;
	}

	public boolean isAdmin() {
		return admin;
	}

	public String getUserId() {
		return userId;
	}

	public int getBoardCode() {
		return boardCode;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
