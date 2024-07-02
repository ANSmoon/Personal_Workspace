// Author : 문범수
// Date : 2024-01-25
// duration : 10m
// name : 사용자 예외처리
// subject : throws

package 사용자예외처리;

public interface IUserManager {
	void add(User user);
	
	User[] getList();
	
	User[] getUsers();
	
	VipUser[] getVipUsers();
	
	User[] searchByName(String name) throws NameNotFoundException;
	
	double getAgeAvg();
}
