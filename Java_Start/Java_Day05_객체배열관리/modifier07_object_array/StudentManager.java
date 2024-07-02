package modifier07_object_array;

public class StudentManager {
	// 빈 배열.
	private Student[] students = new Student[100]; // 학생 정보는 최대 100명까지 저장할 수 있다.
	private int size = 0; // 학생들의 수.
	
	// 학생들의 배열을 갖고 있는 객체.
	// 학생들의 배열을 관리
	// 싱글턴 패턴을 적용해 하나만 생성되도록 만들기
	private static StudentManager instance = new StudentManager();
	
	private StudentManager() {
		
	}
	
	public static StudentManager getInstance() {
		return instance;
	}
	
	public void addStudent(Student st) {
		students[size] = st;
		size++;
	}
	
	public Student getStudent(String name) {
		for(int i=0; i<size; i++) {
			if(name.equals(students[i].getName())) {
				return students[i];
			}
		}
		return null;
	}
	
	public void changeMajor(String name, String major) {
		Student st = getStudent(name);
		if(st != null) { // 이름이 같은 학생이 있다면.
			st.setMajor(major);
		} else {
			System.out.println("학생을 찾을수 없습니다.");
		}
		
	}
	
	
    
    
}
