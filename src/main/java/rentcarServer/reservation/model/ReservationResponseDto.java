package rentcarServer.reservation.model;

import java.sql.Timestamp;

public class ReservationResponseDto {
	private int rezNum;
	private String userId;
	private int carCode;
	private int carPrice;
	private int totalPrice;
	private Timestamp borrowDate;
	private Timestamp returnDate;
	private String status;
	private String carName;

	public ReservationResponseDto(int rezNum, String userId, int carCode, int carPrice, int totalPrice,
			Timestamp borrowDate, Timestamp returnDate, String status, String carName) {
		super();
		this.rezNum = rezNum;
		this.userId = userId;
		this.carCode = carCode;
		this.carPrice = carPrice;
		this.totalPrice = totalPrice;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
		this.carName = carName;
	}

	public ReservationResponseDto(int rezNum, String userId, int carCode, int carPrice, Timestamp borrowDate,
			Timestamp returnDate, String status, String carName) {
		super();
		this.rezNum = rezNum;
		this.userId = userId;
		this.carCode = carCode;
		this.carPrice = carPrice;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
		this.carName = carName;
	}

	public int getRezNum() {
		return rezNum;
	}

	public String getUserId() {
		return userId;
	}

	public int getCarCode() {
		return carCode;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public Timestamp getBorrowDate() {
		return borrowDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public String getStatus() {
		return status;
	}

	public String getCarName() {
		return carName;
	}

	public void setRezNum(int rezNum) {
		this.rezNum = rezNum;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setBorrowDate(Timestamp borrowDate) {
		this.borrowDate = borrowDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
}