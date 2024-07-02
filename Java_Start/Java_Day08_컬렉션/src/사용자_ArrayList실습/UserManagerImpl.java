// Author : 문범수
// Date : 2024-01-24
// duration : 10m
// name : 사용자 ArrayList실습
// subject : ArrayList

package 사용자_ArrayList실습;

import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements IUserManager {
	private List<User> userList = new ArrayList<User>();
	private final int MAX_SIZE = 100;

	// 싱글톤 패턴을 위한 객체 생성, 알맞은 접근 제어자 설정
	private static UserManagerImpl um = new UserManagerImpl();

	// 싱글톤 패턴의 기본 생성자, 객체 생성을 외부에서 하지 못하게 막음
	private UserManagerImpl() {
	};

	// 외부에서 사용할 수 있도록 UserManagerImpl 인스턴스 반환
	public static UserManagerImpl getInstance() {
		return um;
	}

	public void add(User user) {
		if (userList.size() < MAX_SIZE) {
			userList.add(user);
		} else {
			System.out.println("그만좀 괴롭혀...");
		}
	}

	public User[] getList() {
		User[] result = new User[userList.size()];
		if (userList.size() == 0)
			return null;
		// for문을 이용해 컬렉션으로부터 배열에 전달
//		for (int i = 0; i < userList.size(); i++)
//			result[i] = userList.get(i);
//		
//		return result;
		return this.userList.toArray(result);
	}

	public User[] getUsers() {

		List<User> temp = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				temp.add(userList.get(i));
			}
		}
		User[] result = new User[temp.size()];
		return temp.toArray(result);
	}

	public VipUser[] getVipUsers() {

		List<VipUser> temp = new ArrayList<>();
		
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i) instanceof VipUser) {
				temp.add((VipUser) userList.get(i));
			}
		}
		
		VipUser[] result = new VipUser[temp.size()] ;

		return result;

	}

	public User[] searchByName(String name) {

		List<User> temp = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().contains(name)) {
				temp.add(userList.get(i));
			}
		}
		
		// 주어진 단어를 포함하는 사용자가 없으면 null을 반환한다.
		if(temp.size() == 0)
			return null;
		
		User[] result = new User[temp.size()];

		return temp.toArray(result);
	}

	public double getAgeAvg() {

		int sum = 0;

		for (int i = 0; i < userList.size(); i++) {
			sum += userList.get(i).getAge();
		}

		return sum / userList.size();

	}
}
