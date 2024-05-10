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
				int car_seat = rs.getInt(7);
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
	public List carListWithPageNumber(int startRow, int pageSize) {
		List carList = new ArrayList();
		
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM cars ORDER BY reg_date DESC LIMIT 3 OFFSET 3";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
	        pstmt.setInt(2, pageSize);
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

}
