package 상품_Collection_실습;

import java.util.List;

public interface IProductManager {
	public boolean addProduct(Product product);

	public boolean updateProduct(Product product);

	public boolean removdeProduct(String pCode);

	public int sell(String pCode, int cnt);

	public Product[] getProductList();

	public Product searchByCode(String pCode);

	public boolean addReview(Review review);

	public boolean removeReview(String pCode);

	public List<Review> getProductReview(String pCode);

	public Product[] searchByName(String name);

	public long getTotoalPrice();

	public Product[] getProducts();

	public Refrigerator[] getRefrigerators();

	public Refrigerator[] getRefrigeratorsFreezer(boolean freezer);
}
