// Author : 문범수
// Date : 2024-01-23
// duration : 60m
// name : 영화매니저 인터페이스
// subject : 추상클래스 & 인터페이스 & 제네릭

package 영화매니저_인터페이스;

public interface IMovieManager {
	
	void add(Movie movie);
	
	Movie[] getList();
	
	Movie[] searchByTitle(String title);
	
	Movie[] getMovies();
	
	SeriesMovie[] getSeriesMovies();
	
	double getRunningTimeAvg();
}
