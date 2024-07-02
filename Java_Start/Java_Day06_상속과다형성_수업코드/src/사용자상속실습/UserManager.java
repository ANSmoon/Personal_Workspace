// Author : 문범수
// Date : 2024-01-22
// duration : 60m
// name : 영화 상속 실습
// subject : 상속과 다형성

package 사용자상속실습;

public class UserManager {
	private static int MAX_SIZE = 100;
	private int size = 0;
	User[] userList = new User[MAX_SIZE];
	
	//1. 생성자를 private으로 막아서 외부에서 생성하지 못하도록 차단
	private UserManager() {}
	
	//2. 객체를 단 한번만 생성해서 갖고 있는다.[static으로 만들어야 static으로 접근 가능]
	private static UserManager instance = new UserManager();
	
	public static UserManager getInstance() {
		return instance;
	}
	
	
	public void add(User user) {
		if(size < MAX_SIZE) {
			userList[size++] = user;
		}
		else {
			System.out.println("그.. 그만 좀 해");
		}
	}
	
	public User[] getList() {
		User[] result = new User[size];
		for(int i = 0; i < size; i++) {
			System.arraycopy(userList, 0, result, 0, size);
		}
		return result;
	}
	
	public User[] getUsers() {
		int cnt = 0;
		for(int i = 0; i < this.size; i++) {
			if(!(userList[i] instanceof VipUser)) {
				cnt++;
			}
		}
		if(cnt == 0) return null;
		
		User[] result = new User[cnt];
		
		for(int i = 0, index = 0; i < this.size; i ++) {
			if(!(userList[i] instanceof VipUser)) {
				result[index++] = userList[i];
			}
		}
		return result;
	}
	
	public VipUser[] getVipUser() {
		int cnt = 0;
		
		for(int i = 0; i < this.size; i++) {
			if(userList[i] instanceof VipUser) {
				cnt++;
			}
		}
		
		if(cnt == 0) return null;
		
		VipUser[] result = new VipUser[cnt];
		
		for(int i = 0, index = 0; i < this.size; i++) {
			if(userList[i] instanceof VipUser) {
				result[index++] = (VipUser)userList[i];
			}
		}
		return result;
	}
	
	public User[] searchByName(String name) {
		int cnt = 0;
		
		for(int i = 0; i < this.size; i++) {
			if(userList[i].getName().contains(name)) {
				cnt++;
			}
		}
		
		User[] result = new User[cnt];
		
		for(int i = 0, index = 0; i < this.size; i++) {
			if(userList[i].getName().contains(name)) {
				result[index++] = userList[i];
			}
		}
		
		return result;
	}
	
	public double getAgeAvg() {
		int sum = 0;
		for(int i = 0; i < this.size; i++) {
			sum += userList[i].getAge();
		}
		return sum / size;
	}
	
}
