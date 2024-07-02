// Author : 문범수
// Date : 2024-01-24
// duration : 20m
// name : 영화 ArrayList
// subject : ArrayList

package 영화_ArrayList실습;

public interface IMovieManager {
	
	void add(Movie movie);
	
	Movie[] getList();
	
	Movie[] searchByTitle(String title);
	
	Movie[] getMovies();
	
	SeriesMovie[] getSeriesMovies();
	
	double getRunningTimeAvg();
}
