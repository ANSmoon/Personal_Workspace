// Author : 문범수
// Date : 2024-01-22
// duration : 60m
// name : 영화 상속 실습
// subject : 상속과 다형성

package 영화상속실습;

public class MovieManager {
	int MAX_SIZE = 100;	
	int size = 0;
	Movie[] movieList = new Movie[MAX_SIZE];
	
	
	public void add(Movie movie) {
		if(size < MAX_SIZE) {
			movieList[size++] = movie;
		}
		else System.out.println("그 그만 입력해...");
	}
	
	public SeriesMovie[] getSeriesMovies() {
		int cnt = 0;
		
		for(int i = 0; i < this.size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				cnt++;
			}
		}
		
		if(cnt == 0) return null;
		
		SeriesMovie[] result = new SeriesMovie[cnt];
		
		for(int i = 0, index = 0; i < this.size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				result[index++] = (SeriesMovie)movieList[i];
			}
		}
		return result;
	}
	
	public Movie[] getList() {
		Movie[] result = new Movie[size];
		System.arraycopy(movieList, 0, result, 0, size);
		return result;
	}

	public Movie[] getMovies() {
		int cnt = 0;
		for(int i = 0; i < this.size; i ++) {
			if(!(movieList[i] instanceof SeriesMovie)) {
				cnt++;
			}
		}
		
		if(cnt == 0) return null;
		
		Movie[] result = new Movie[cnt];
		
		for(int i = 0, index = 0; i < this.size; i++) {
			if(!(movieList[i] instanceof SeriesMovie)) {
				result[index++] = movieList[i];
			}
		}
		return result;
	}


	public Movie[] searchByTitle(String title) {
		int cnt = 0;
		
		for(int i = 0; i < this.size; i++) {
			if(movieList[i].getTitle().contains(title)) {
				cnt++;
			}
		}
		if(cnt == 0) return null;
		
		Movie[] result = new Movie[cnt];
		
		for(int i = 0, index = 0; i < this.size; i++) {
			if(movieList[i].getTitle().contains(title)) {
				result[index++] = movieList[i];
			}
		}
		return result;
	}
	
	
	public double getRunningTimeAvg() {
		double sum = 0d;
		for(int i = 0; i < this.size; i++) {
			sum += movieList[i].getRunningTime();
		}
		return sum / this.size;
	}
}
