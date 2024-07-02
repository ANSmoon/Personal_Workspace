// Author : 문범수
// Date : 2024-01-24
// duration : 10m
// name : 사용자 ArrayList실습
// subject : ArrayList

package 사용자_ArrayList실습;

public interface IUserManager {
	void add(User user);
	
	User[] getList();
	
	User[] getUsers();
	
	VipUser[] getVipUsers();
	
	User[] searchByName(String name);
	
	double getAgeAvg();
}
