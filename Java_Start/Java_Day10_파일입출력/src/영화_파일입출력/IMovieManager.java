// Author : 문범수
// Date : 2024-01-25
// duration : 20m
// name : 영화 예외처리
// subject : throws

package 영화_파일입출력;

public interface IMovieManager {
	
	void add(Movie movie);
	
	Movie[] getList();
	
	Movie[] searchByTitle(String title) throws TitleNotFoundException;
	
	Movie[] getMovies();
	
	SeriesMovie[] getSeriesMovies();
	
	double getRunningTimeAvg();
	
	void saveData();
}
