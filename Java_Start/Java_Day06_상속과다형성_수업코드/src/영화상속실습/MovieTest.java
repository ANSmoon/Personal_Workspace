// Author : 문범수
// Date : 2024-01-22
// duration : 60m
// name : 영화 상속 실습
// subject : 상속과 다형성

package 영화상속실습;

import java.util.Arrays;

public class MovieTest {
 public static void main(String[] args) {
	 Movie mv1 = new Movie();
	 mv1.setId(10);
	 mv1.setTitle("하울의 움직이는 성");
	 mv1.setDirector("니혼진");
	 mv1.setGenre("지브리");
	 mv1.setRunningTime(120);
	 
	 Movie mv2 = new Movie(20, "서울의 봄","코리안","war",160);
	 
	 SeriesMovie sv = new SeriesMovie(30, "해리포터","외국인","fantasy",140, 3, "해리포터 죽음의 성물");
	 
	 MovieManager mm = new MovieManager();
	 
	 mm.add(mv1);
	 mm.add(mv2);
	 mm.add(sv);
	 
	 System.out.println(Arrays.toString(mm.searchByTitle("서울")));
	 System.out.println(Arrays.toString(mm.getList()));
	 System.out.println(mm.getRunningTimeAvg());
	 System.out.println(Arrays.toString(mm.getSeriesMovies()));
	 System.out.println(Arrays.toString(mm.getMovies()));
 }
}
