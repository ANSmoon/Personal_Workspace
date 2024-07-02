// Author : 문범수
// Date : 2024-01-18
// duration : 15m
// name : 상품, 리뷰객체 생성
// subject : 클래스와 객체

package homework;

public class ProductTest {
	public static void main(String[] args) {
		Product pr1 = new Product("N100","Galaxy S 24",1000000, 20,"Samsung","God Samsung");
		Product pr2 = new Product("A100","Apple 15 Ultra",1500000, 40,"Apple","God Apple");
		ReviewProduct rv = new ReviewProduct(10, "H100","Mun","둘다 좋다");
		String star = "*";
		
		System.out.println(star.repeat(35) + "제품목록" + star.repeat(35));
		System.out.println(pr1.toString());
		System.out.println(pr2.toString());
		System.out.println(star.repeat(35) + "리뷰내용" + star.repeat(35));
		System.out.println(rv.toString());
	}
}
