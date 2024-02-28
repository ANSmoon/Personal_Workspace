package test01_list;

import java.util.ArrayList;
import java.util.List;

public class ListTest1 {
	public static void main(String[] args) {
		// List
		// 1. 순서 有
		// 2. 중복 허용

		// 뒤 type 지정 String은 생략가능
		List<String> names = new ArrayList<>();

		// 원소 추가
		names.add("MUNBEUMSU");
		names.add("JANGWONYOUNG");
		names.add("ANYUJIN");
		names.add("KIMCHAEWON");
		names.add("ANYUJIN"); // 중복 허용

		System.out.println(names);

		// null 체크
		System.out.println(names.isEmpty());

		// remove
		// 1. index를 이용한 삭제
		names.remove(0);
		System.out.println(names);

		// 2. 값을 이용한 삭제 => 이때 중복된 값중 하나만 삭제 된다.[앞에 내용]
		names.remove("ANYUJIN");
		System.out.println(names);

		// 3. 전부 삭제
		names.clear();

		names.add("Sakura");
		names.add("Karina");
		names.add("Winter");
		names.add("Karina");
		System.out.println(names);

		// 중복 값을 모두 삭제
		// 하지만 삭제 되지 않는다!
		// 이유 : 지우면서 index가 바뀌기 때문에
		// 삭제시, 리스트 크기도 바뀌고, 각 원소들의 index 또한 바뀌게 된다.
//    	for(int i = 0; i < names.size(); i++) {
//    		if(names.get(i).equals("Karina")) {
//    			names.remove(i);
//    		}
//    	}

		// 역순으로 진행하면 가능해진다.
		for (int i = names.size() - 1; i >= 0; i--) {
			if (names.get(i).equals("Karina")) {
				names.remove(i);
			}
		}
		System.out.println(names);

	}
}
