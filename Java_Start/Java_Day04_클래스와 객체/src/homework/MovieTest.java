// Author : 문범수
// Date : 2024-01-18
// duration : 10m
// name : 영화객체 생성
// subject : 클래스와 method

package homework;

public class MovieTest {
	public static void main(String[] args) {
		Movie x = new Movie(2024, "Titanic","Junho Park","Romance",120);
		
		System.out.printf("이 영화 아이디는 %d이고, 제목은 %s이며, 감독이름은 %s이다.\n장르는 %s이고, 총 길이는 %d분이다.",x.id,x.title,x.director,x.genre,x.runningTime);
	}
}
