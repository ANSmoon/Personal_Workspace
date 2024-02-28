package 상품_Collection_실습;

public class Refrigerator extends Product{
	private String category;
	private int liter, year;
	private boolean freezer;
	
	public Refrigerator() {
	}
	
	public Refrigerator(String pCode, String pName, int price, int quantity, String brand, String desc, String category, int liter, boolean freezer, int year) {
		super(pCode, pName, price, quantity, brand, desc);
		this.category = category;
		this.liter = liter;
		this.year = year;
		this.freezer = freezer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isFreezer() {
		return freezer;
	}

	public void setFreezer(boolean freezer) {
		this.freezer = freezer;
	}

	@Override
	public String toString() {
		return super.toString() + "Refrigerator : " + "getCategory()=" + getCategory() + ", getLiter()=" + getLiter() + ", getYear()="
				+ getYear() + ", isFreezer()=" + isFreezer() + ", toString()=" + "]";
	}
}

