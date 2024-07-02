package 상품_Collection_실습;

public class Product {
	private String pCode, pName, brand, desc;
	private int price, quantity;
	
	Product() {}
	Product(String pCode, String pName, int price, int quantity, String brand, String desc){
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.desc = desc;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Product [getpCode()=" + getpCode() + ", getpName()=" + getpName() + ", getBrand()=" + getBrand()
				+ ", getDesc()=" + getDesc() + ", getPrice()=" + getPrice() + ", getQuantity()=" + getQuantity() + "]";
	}
}
