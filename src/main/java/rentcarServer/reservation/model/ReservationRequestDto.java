package rentcarServer.reservation.model;

import java.sql.Timestamp;

public class ReservationRequestDto {
	private int rezNum;
	private String userId;
	private int carCode;
	private String carName;
	private int carPrice;
	private int totalPrice;
	private Timestamp borrowDate;
	private Timestamp returnDate;
	private String status;
	
	public ReservationRequestDto() {
		
	}

	public ReservationRequestDto(int rezNum, String userId, int carCode, String carName, int carPrice, int totalPrice,
			Timestamp borrowDate, Timestamp returnDate, String status) {
		super();
		this.rezNum = rezNum;
		this.userId = userId;
		this.carCode = carCode;
		this.carName = carName;
		this.carPrice = carPrice;
		this.totalPrice = totalPrice;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
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

	public String getCarName() {
		return carName;
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

	public void setRezNum(int rezNum) {
		this.rezNum = rezNum;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}

	public void setCarName(String carName) {
		this.carName = carName;
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

}
