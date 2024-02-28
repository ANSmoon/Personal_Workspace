// Author : 문범수
// Date : 2024-01-23
// duration : 60m
// name : 사용자매니저 인터페이스
// subject : 추상클래스 & 인터페이스 & 제네릭

package 사용자매니저_인터페이스;

public interface IUserManager {
	void add(User user);
	
	User[] getList();
	
	User[] getUsers();
	
	VipUser[] getVipUsers();
	
	User[] searchByName(String name);
	
	double getAgeAvg();
}
