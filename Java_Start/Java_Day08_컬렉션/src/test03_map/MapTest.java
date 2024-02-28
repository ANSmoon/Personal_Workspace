package test03_map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        // Map
    	// - 사전과 같은 자료구조
    	// - key & value 쌍으로 저장
    	// - key로 구별(중복 x), value(중복 o), 순서 보장 x
    	
    	Map<String, String> map = new HashMap<>();
    	// key나 value를 여러개 넣고 싶으면 list로 구현함
        
    	map.put("서울지사","이재용");
    	map.put("대전지사","성심당");
    	map.put("대구지사","사과");
    	map.put("부산지사","광어");
    	map.put("광주지사","유스퀘어");
    	map.put("구미지사","삼성전자");
    	
        System.out.println(map);
        
        System.out.println(map.get("대구지사"));
        map.put("구미지사", "전자");
        
        System.out.println(map);
        
        System.out.println(map.containsKey("대전지사"));
        System.out.println(map.containsValue("광어"));
        
        // map의 순회
        // 1. keySet()
        for(String key : map.keySet()) {
        	System.out.printf("%s : %s \n", key, map.get(key));
        }
        
        // 2. entrySet()
        for(Map.Entry<String, String> entry : map.entrySet()) {
        	System.out.println(entry.getKey() + " : " + entry.getValue());;
        }
        
    }
}
