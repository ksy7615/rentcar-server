package rentcarServer.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CarDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private CarDao() {

	}

	private static CarDao instance = new CarDao();

	public static CarDao getInstance() {
		return instance;
	}
}
