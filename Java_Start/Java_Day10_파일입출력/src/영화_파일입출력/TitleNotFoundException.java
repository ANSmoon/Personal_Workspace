// Author : 문범수
// Date : 2024-01-25
// duration : 20m
// name : 영화 예외처리
// subject : throws

package 영화_파일입출력;

public class TitleNotFoundException extends Exception{
	private String title;
	
	public TitleNotFoundException(String title) {
		super(title + "이라는 그딴 영화는 없슴다.");
		this.title = title;
	}

	public String getTitle() {
		return title;
	}	
}
