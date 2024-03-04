package homework;
/*
 * Author : 문범수
 * Date : 2024-02-11
 * subject : Selection sort 구현
 * main : Map 구현
 * issue : Map은 순서 정렬 기능 없음 => SortedMap 사용
 * 		   따로 정렬 필요 없음, 사람 수 대비 붕어빵 개수 차이 계산 구현
 * name : fish.java
 * duration : 300m
 * CodeNo : 1860
 */
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
 
public class fish {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Map 사용
 
         
        int total = Integer.parseInt(reader.readLine());
        int index = 1;
        int sum = 0; // 붕어빵 개수 저장
        String pass = "Possible";
 
        while (index <= total) {
            // 정렬된 Map 구현
            SortedMap<Integer, Integer> data = new TreeMap<>();
             
            // N, M, K 입력
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(token.nextToken()); // 사람수
            int M = Integer.parseInt(token.nextToken()); // 붕어빵 만드는데 걸리는 시간
            int K = Integer.parseInt(token.nextToken()); // 시간당 만드는 붕어빵 개수
 
            // 손님 도착 시간 삽입
            int[] arr = new int[N];
            int x = 0;
            token = new StringTokenizer(reader.readLine());
            while(token.hasMoreTokens()) {
                arr[x++] = Integer.parseInt(token.nextToken());
            }
             
            // 손님 도착 시간 정렬 [Insertion Sort] => 시간복잡도 O(N^2)이기 때문에 정렬된 MAP으로 구현
            // 정렬되지 않은 집합 순회
//          for (int i = 0; i < arr.length; i++) {
//              int key = arr[i];
//              int j;
//              for (j = i - 1; j >= 0 && key < arr[j]; j--) { // 정렬된 배열 순회
//                  arr[j + 1] = arr[j];
//              }
//              arr[j + 1] = key; // j가 한번 감소했기 때문에 1+ 필수
//          }
             
            // main
            // 각 시간대별로 오는 손님수 계산
            for(int i = 0; i < arr.length; i++) {
            int count = 1; // 해당 시간에 오는 손님 수
                if(data.containsKey(arr[i])) {
                    count = data.get(arr[i]) + 1;
                    data.put(arr[i], count);
                }
                data.put(arr[i], count);
            }
//          System.out.println(Arrays.toString(arr));
//          System.out.println(data);
             
            // 저장된 Map을 토대로 도착시간대 별로 남아있는 붕어빵 갯수 계산
            Iterator<Integer> keys = data.keySet().iterator();
            int person = 0;
            boolean con = true;
            while(con) {
                int key = keys.next(); // key값 받아오기
                person += data.get(key); // 해당 시간까지의 사람 수
                sum = ((int)(key / M)) * K; // 해당 시간까지 만들어진 붕어빵 수
                 
                if(sum - person < 0) {
                    pass = "Impossible";
                    con = false;
                    break;
                }
                 
                if(!keys.hasNext()) {
                    pass = "Possible";
                    con = false;
                    break;
                }
            }
             
            System.out.println("#" + index + " " + pass);
            index++;
        }
 
    }
}