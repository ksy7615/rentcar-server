package rentcarServer.car.model;

public class CarRequestDto {
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

	public CarRequestDto() {

	}

	public CarRequestDto(int code, String licensePlate, String abroad, String brand, String name, String type, int seat,
			String oil, int year, int price) {
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

	public void setCode(int code) {
		this.code = code;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public void setAbroad(String abroad) {
		this.abroad = abroad;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public void setOil(String oil) {
		this.oil = oil;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
