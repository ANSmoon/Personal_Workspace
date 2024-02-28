// Author : 문범수
// Date : 2024-01-22
// duration : 60m
// name : 영화 상속 실습
// subject : 상속과 다형성

package 사용자상속실습;

import java.util.Arrays;

public class UserTest {
	public static void main(String[] args) {
		User u1 = new User();
		u1.setAge(10);
		u1.setEmail("munbeumsu@hanmail.net");
		u1.setId("munbeumsu");
		u1.setName("ANSMOON");
		u1.setPassword("1234");
		
		
		VipUser u2 = new VipUser("1234","asdlfadf@naver.com","moon","ans",20,"A",100);
		UserManager um = UserManager.getInstance();
		
		um.add(u1);
		um.add(u2);
		
		
		System.out.println(Arrays.toString(um.getList()));
		
		
		
	}
}
