package rentcarServer.reservation.model;

import java.sql.Timestamp;

public class Reservation {
	private int rezNum;
	private String userId;
	private int carCode;
	private int carPrice;
	private int totalPrice;
	private Timestamp borrowDate;
	private Timestamp returnDate;
	private String status;
	private Timestamp regDate;
	private Timestamp modDate;
	private String carName;

	public Reservation(int rezNum, String userId, int carCode, int carPrice, int totalPrice,
			Timestamp borrowDate, Timestamp returnDate, String status, Timestamp regDate, Timestamp modDate, String carName) {
		super();
		this.rezNum = rezNum;
		this.userId = userId;
		this.carCode = carCode;
		this.carPrice = carPrice;
		this.totalPrice = totalPrice;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
		this.regDate = regDate;
		this.modDate = modDate;
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

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

}