// Author : 문범수
// Date : 2024-01-18
// duration : 20m
// name : 게시판 객체 생성실습
// subject : 클래스와 객체

package homework;

public class User1 {
	int userSeq;
	String userid, password, userName, nickName, email;
	
	User1(){}
	User1(int userSeq, String userid, String password, String userName, String nickName, String email){
		this.userSeq = userSeq;
		this.userid = userid;
		this.password = password;
		this.userName = userName;
		this.nickName = nickName;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User1 [userSeq=" + userSeq + ", userid=" + userid + ", password=" + password + ", userName=" + userName
				+ ", nickName=" + nickName + ", email=" + email + "]";
	}
}
