// Author : 문범수
// Date : 2024-01-25
// duration : 20m
// name : 영화 예외처리
// subject : throws

package 영화_파일입출력;

import java.util.Arrays;

public class MovieTest {
	public static void main(String[] args) throws TitleNotFoundException {
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setTitle("어벤져스");
		m1.setDirector("외국인");
		m1.setGenre("SF");
		m1.setRunningTime(160);
		
		Movie m2 = new Movie(2, "괴물", "봉준호", "SF", 180);

		SeriesMovie m3 = new SeriesMovie(3, "해리포터", "누구더라", "Fantasy", 160, 1, "재밌는 편");

		IMovieManager manage = MovieManagerImpl.getinstance();
		
		manage.add(m1);
		manage.add(m2);
		manage.add(m3);
		manage.saveData();
		
		System.out.println(Arrays.toString(manage.getList()));
		System.out.println(manage.getRunningTimeAvg());
//		System.out.println(Arrays.toString(manage.searchByTitle("앙")));
//		 예외가 발생할수 있는 메소드인 searchByTitle은 처리가 필요.
		try {
			System.out.println(Arrays.toString(manage.searchByTitle("앙")));
		} catch (TitleNotFoundException	 exception) {
			exception.printStackTrace();
		}
		
	}
}
