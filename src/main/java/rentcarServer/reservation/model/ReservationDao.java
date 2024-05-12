package rentcarServer.reservation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentcarServer.util.DBConnection;

public class ReservationDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private ReservationDao() {

	}

	private static ReservationDao instance = new ReservationDao();

	public static ReservationDao getInstance() {
		return instance;
	}
	
	public ReservationResponseDto createReservation(ReservationRequestDto reservationRequestDto) {
		ReservationResponseDto reservation = null;
		conn = DBConnection.getConnection();

		String sql = "INSERT INTO reservations (user_id,car_code,car_price,borrow_date,return_date,car_name) VALUES(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, reservationRequestDto.getUserId());
			pstmt.setInt(2, reservationRequestDto.getCarCode());
			pstmt.setInt(3, reservationRequestDto.getCarPrice());
			pstmt.setTimestamp(4, reservationRequestDto.getBorrowDate());
			pstmt.setTimestamp(5, reservationRequestDto.getReturnDate());
			pstmt.setString(6, reservationRequestDto.getCarName());

			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int reservationNum = rs.getInt(1);
				reservation = findReservationByReservationNum(reservationNum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return reservation;
	}

	public ReservationResponseDto findReservationByReservationNum(int reservationNum) {
		conn = DBConnection.getConnection();
		ReservationResponseDto reservationsResponseDto = null;
		String sql = "SELECT reservation_num,user_id,car_code,car_price,borrow_date,return_date,status,car_name FROM reservations WHERE reservation_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservationNum);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String userId = rs.getString(2);
				int carCode = rs.getInt(3);
				int carPrice = rs.getInt(4);
				Timestamp borrowDate = rs.getTimestamp(5);
				Timestamp returnDate = rs.getTimestamp(6);
				String status = rs.getString(7);
				String carName = rs.getString(8);

				reservationsResponseDto = new ReservationResponseDto(reservationNum, userId, carCode, carPrice,
						borrowDate, returnDate, status, carName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservationsResponseDto;
	}

	public boolean checkAvailability(String startDateTime, String endDateTime, String carCode) {
		conn = DBConnection.getConnection();
		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM reservations " + "WHERE car_code = ? AND "
					+ "((borrow_date <= ? AND return_date >= ?) OR " + "(borrow_date BETWEEN ? AND ?) OR "
					+ "(return_date BETWEEN ? AND ?))AND status = '예약중'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carCode);
			pstmt.setString(2, startDateTime);
			pstmt.setString(3, endDateTime);
			pstmt.setString(4, startDateTime);
			pstmt.setString(5, endDateTime);
			pstmt.setString(6, startDateTime);
			pstmt.setString(7, endDateTime);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}

		return count == 0;
	}

	public List<ReservationResponseDto> findReservationsById(String userId) {
		List<ReservationResponseDto> reservationList = new ArrayList<ReservationResponseDto>();

		conn = DBConnection.getConnection();
		String sql = "SELECT reservation_num, user_id, car_code, car_price, borrow_date, return_date, status, car_name FROM reservations WHERE user_id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int reservation_num = rs.getInt(1);
				int carCode = rs.getInt(3);
				int carPrice = rs.getInt(4);
				Timestamp borrowDate = rs.getTimestamp(5);
				Timestamp returnDate = rs.getTimestamp(6);
				String status = rs.getString(7);
				String carName = rs.getString(8);

				ReservationResponseDto reservationsResponseDto = new ReservationResponseDto(reservation_num, userId,
						carCode, carPrice, borrowDate, returnDate, status, carName);
				reservationList.add(reservationsResponseDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return reservationList;
	}

	public void cancelReservationByReservationNum(int reservationNum) {
		conn = DBConnection.getConnection();

		String sql = "UPDATE reservations SET status = '예약취소' WHERE reservation_num = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservationNum);

			pstmt.execute();
			System.out.println("예약취소 완료");
		} catch (SQLException e) {
			System.out.println("예약취소 실패");
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt);
		}

	}

	public void updateReservation(ReservationResponseDto reservation) {
		conn = DBConnection.getConnection();

		String sql = "UPDATE reservations SET borrow_date = ? , return_date = ? , car_price = ? WHERE reservation_num = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, reservation.getBorrowDate());
			pstmt.setTimestamp(2, reservation.getReturnDate());
			pstmt.setInt(3, reservation.getCarPrice());
			pstmt.setInt(4, reservation.getRezNum());

			pstmt.execute();
			System.out.println("업데이트 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("업데이트 실패");
		} finally {
			DBConnection.close(conn, pstmt);
		}

	}

	public boolean checkAvailabilityForUpdate(String startDateTime, String endDateTime, String carCode,
			int reservationNum) {
		conn = DBConnection.getConnection();
		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM reservations " + "WHERE car_code = ? AND "
					+ "((borrow_date <= ? AND return_date >= ?) OR " + "(borrow_date BETWEEN ? AND ?) OR "
					+ "(return_date BETWEEN ? AND ?))AND status = '예약중' AND reservation_num != ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carCode);
			pstmt.setString(2, startDateTime);
			pstmt.setString(3, endDateTime);
			pstmt.setString(4, startDateTime);
			pstmt.setString(5, endDateTime);
			pstmt.setString(6, startDateTime);
			pstmt.setString(7, endDateTime);
			pstmt.setInt(8, reservationNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}

		return count == 0;
	}
}
