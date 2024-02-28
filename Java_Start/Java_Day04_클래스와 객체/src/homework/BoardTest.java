// Author : 문범수
// Date : 2024-01-18
// duration : 20m
// name : 게시판 객체 생성실습
// subject : 클래스와 객체

package homework;

public class BoardTest {
	public static void main(String[] args) {
		String line = "-";
		User1 ur1 = new User1(0,"ssafy","1234","김싸피","김싸피","ssafy@ssafy.com");
		User1 ur2 = new User1(1,"hong","123","홍싸피","ssafy.hong","hong@ssafy.com");
		User1 ur3 = new User1(2,"samsic","samsic","김삼식","삼식이","kim@ssafy.com");
		User1 ur4 = new User1(3,"happy","happy","이싸피","해피바이러스","lee@ssafy.com");
		
		Article art1 = new Article(0, "공지사항", "게시글 내용", 0, 0);
		Article art2 = new Article(1, "코딩테스트란", "게시글 내용", 1, 0);
		Article art3 = new Article(2, "취뽀는 나에게", "게시글 내용", 2, 0);
		Article art4 = new Article(3, "JAVA 완전정복", "게시글 내용", 3, 0);
		
		Comment cm1 = new Comment(0, 1, 5, "잘 봄");
		Comment cm2 = new Comment(1, 1, 4, "Nice sentence");
		
		System.out.println("User 출력");
		System.out.println(line.repeat(40));
		System.out.println(ur1.toString());
		System.out.println(ur2.toString());
		System.out.println(ur3.toString());
		System.out.println(ur4.toString());
		
		System.out.println("게시글 출력");
		System.out.println(line.repeat(40));
		System.out.println(art1.toString());
		System.out.println(art2.toString());
		
		System.out.println("게시글 댓글 출력");
		System.out.println(line.repeat(40));
		System.out.println(cm1.toString());
		System.out.println(cm2.toString());
	}
}
