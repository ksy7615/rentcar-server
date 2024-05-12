package rentcarServer.car.model;

import java.sql.Timestamp;

public class Car {
	// 차 코드, 번호판, 국산/외제 구분, 브랜드, 차명,
	// 차종, 인승, 기름(휘발유경유), 연식, 가격, 사진
	private int code;
	private String licensePlate;
	private String abroad;
	private String brand;
	private String name;
	private String type;
	private int seat;
	private String oil;
	private int year;
	private int price;
	private Timestamp regDate;
	private Timestamp modDate;

	public Car(int code, String licensePlate, String abroad, String brand, String name, String type, int seat,
			String oil, int year, int price, String img_url, Timestamp regDate, Timestamp modDate) {
		super();
		this.code = code;
		this.licensePlate = licensePlate;
		this.abroad = abroad;
		this.brand = brand;
		this.name = name;
		this.type = type;
		this.seat = seat;
		this.oil = oil;
		this.year = year;
		this.price = price;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getCode() {
		return code;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public String getAbroad() {
		return abroad;
	}

	public String getBrand() {
		return brand;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getSeat() {
		return seat;
	}

	public String getOil() {
		return oil;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return price;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

}
