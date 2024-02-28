// Author : 문범수
// Date : 2024-01-22
// duration : 60m
// name : 영화 상속 실습
// subject : 상속과 다형성

package 사용자상속실습;

public class VipUser extends User{
	private String grade;
	private int point;
	
	VipUser() {}
	
	VipUser(String id, String password, String name, String email, int age, String grade, int point){
		super(id, password, name, email, age);
		this.grade = grade;
		this.point = point;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "\nVipUser [grade=" + getGrade() + ", point=" + getPoint() + ", toString()=" + super.toString() + "]";
	}
}
