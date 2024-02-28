// Author : 문범수
// Date : 2024-01-25
// duration : 10m
// name : 사용자 예외처리
// subject : throws

package 사용자예외처리;

public class NameNotFoundException extends Exception{
	private String name;
	public NameNotFoundException(String name) {
		super(name + "그딴 이름 없다.");
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
