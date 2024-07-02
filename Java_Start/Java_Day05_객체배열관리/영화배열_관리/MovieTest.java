package 영화배열_관리;

import java.util.Arrays;
import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Movie m1 = new Movie(10, "아이언맨", "장원영", "로맨스",12);
		Movie m2 = new Movie(20, "어벤져스", "아이유", "스릴러",23);
		
		MovieManager mv = new MovieManager();
		
		mv.add(m1);
		mv.add(m2);
		
		int count;
		do {
			System.out.println("번호 입력");
			System.out.println("1. 영화 추가");
			System.out.println("2. 영화 조회[제목 입력]");
			System.out.println("3. 추가된 영화 목록 출력스");
			System.out.println("4. 종료");
			
			count = sc.nextInt();
			if(count == 1) {
				System.out.println("영화를 추가하빈다.");
				System.out.println("너의 ID는? : ");
				int id = sc.nextInt();
				System.out.println("영화 제목은? :");
				String title = sc.next();
				System.out.println("영화 감독은? :");
				String director = sc.next();
				System.out.println("영화 장르는? :");
				String genre = sc.next();
				System.out.println("영화 시간은? :");
				int runningTime = sc.nextInt();
				Movie content = new Movie(id,title,director,genre,runningTime);
				mv.add(content);
			}
			else if(count == 2) {
				System.out.println("영화를 조회합니당");
				System.out.println("영화 제목 : ");
				String title = sc.next();
				Movie content = mv.searchByTitle(title);
				if(content == null) {
					System.out.println("그딴 영화 없음");
				}
				else {
					System.out.println("조회 영화 정보 출력");
					System.out.println("ID : " + content.getId());
					System.out.println("Title : " + content.getTitle());
					System.out.println("Director : " + content.getDirector());
					System.out.println("Genre : " + content.getGenre());
					System.out.println("RunningTime : " + content.getRunningTime());
				}
			}
//			else if(count == 3)	System.out.println(Arrays.toString(mv.getList()));
			
			// 중간에 엔터 넣는 방식
			else if(count == 3) 
				for(int i = 0; i < mv.size; i++)
					System.out.println(mv.getList()[i]);
			
			else if(count == 4) System.out.println("종료합니당");
			
			else System.out.println("1 ~ 3번으로만 입력하세요");
			
		}while(count != 4);
		sc.close();
	}
}
