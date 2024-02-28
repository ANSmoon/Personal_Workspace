// Author : 문범수
// Date : 2024-01-22
// duration : 60m
// name : 사용사 상속 실습
// subject : 상속과 다형성

package 사용자상속실습;

public class User {
	private String id, password, name, email;
	private int age;
	
	public User() {}
	
	User(String id, String password, String name, String email, int age){
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [id=" + getId() + ", password=" + getPassword() + ", name=" + getName() + ", email=" + getEmail() + ", age=" + getAge()
				+ "]";
	}
}
