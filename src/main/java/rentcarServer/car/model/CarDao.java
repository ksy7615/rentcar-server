package rentcarServer.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rentcarServer.util.DBConnection;

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
	
	public int carSize() {
	    int size = 0;
	    conn = DBConnection.getConnection();
	    String sql = "SELECT COUNT(*) FROM cars";
	    
	    try {
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            size = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(conn, pstmt, rs);
	    }
	    return size;
	}
	
	public List<CarResponseDto> findCarAll() {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();
		
		conn = DBConnection.getConnection();
	    String sql = "SELECT car_code, car_num, car_abroad, car_brand, car_name, car_type, car_seat, car_oil, car_year, car_price FROM cars";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int car_code = rs.getInt(1);
				String car_num = rs.getString(2);
				String car_abroad = rs.getString(3);
				String car_brand = rs.getString(4);
				String car_name = rs.getString(5);
				String car_type = rs.getString(6);
				String car_seat = rs.getString(7);
				String car_oil = rs.getString(8);
				int car_year = rs.getInt(9);
				int car_price = rs.getInt(10);
				
				CarResponseDto car = new CarResponseDto(car_code, car_num, car_abroad, car_brand, car_name, car_type, car_seat, car_oil, car_year, car_price);
				list.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 데이터 시작행 페이지 갖고 들고오는 리스트
	// > car list 액션 할 때 불러오는거 이걸로 변경 해보기
	public List carListWithPageNumber(int pageSize, int startRow) {
		List carList = new ArrayList();
		
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM cars ORDER BY reg_date DESC LIMIT ? OFFSET ?";
			
			pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, pageSize);
	        pstmt.setInt(2, startRow-1);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CarRequestDto carDto = new CarRequestDto();
				
				carDto.setCode(rs.getInt("car_code"));
				carDto.setLicensePlate(rs.getString("car_num"));
				carDto.setAbroad(rs.getString("car_abroad"));
				carDto.setBrand(rs.getString("car_brand"));
				carDto.setName(rs.getString("car_name"));
				carDto.setType(rs.getString("car_type"));
				carDto.setSeat(rs.getInt("car_seat"));
				carDto.setOil(rs.getString("car_oil"));
				carDto.setYear(rs.getInt("car_year"));
				carDto.setPrice(rs.getInt("car_price"));
				
				carList.add(carDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return carList;
	}
	
	public List<CarResponseDto> findValidCars(String startDateTime, String endDateTime) {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();
		
		conn = DBConnection.getConnection();
		try {
			String sql = "SELECT car_code, car_num, car_abroad, car_brand, car_name, car_type, car_seat, car_oil, car_year, car_price FROM cars WHERE car_code NOT IN (SELECT car_code FROM reservations WHERE ((borrow_date BETWEEN ? AND ?) OR (return_date BETWEEN ? AND ?) OR (borrow_date <= ? AND return_date >= ?)) AND status = '예약중')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDateTime);
			pstmt.setString(2, endDateTime);
			pstmt.setString(3, startDateTime);
			pstmt.setString(4, endDateTime);
			pstmt.setString(5, startDateTime);
			pstmt.setString(6, endDateTime);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int car_code = rs.getInt(1);
				String car_num = rs.getString(2);
				String car_abroad = rs.getString(3);
				String car_brand = rs.getString(4);
				String car_name = rs.getString(5);
				String car_type = rs.getString(6);
				String car_seat = rs.getString(7);
				String car_oil = rs.getString(8);
				int car_year = rs.getInt(9);
				int car_price = rs.getInt(10);
				
				CarResponseDto car = new CarResponseDto(car_code, car_num, car_abroad, car_brand, car_name, car_type, car_seat, car_oil, car_year, car_price);
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public CarResponseDto findCarsByCarCode(int carCode) {
		conn = DBConnection.getConnection();
		CarResponseDto car = null;
		String sql = "SELECT car_code, car_num, car_abroad,car_brand,car_name,car_type,car_seat,car_oil,car_year,car_price FROM Cars WHERE car_code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carCode);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String carNum = rs.getString(2);
				String carAbroad = rs.getString(3);
				String carBrand = rs.getString(4);
				String carName = rs.getString(5);
				String carType = rs.getString(6);
				String carSeat = rs.getString(7);
				String carOil = rs.getString(8);
				int carYear = rs.getInt(9);
				int carPrice = rs.getInt(10);
				
				car = new CarResponseDto(carCode, carNum, carAbroad, carBrand, carName, carType, carSeat, carOil, carYear, carPrice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return car;
	}

}
