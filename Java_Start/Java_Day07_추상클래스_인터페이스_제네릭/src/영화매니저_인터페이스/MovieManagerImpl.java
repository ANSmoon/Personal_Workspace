// Author : 문범수
// Date : 2024-01-23
// duration : 60m
// name : 영화매니저 인터페이스
// subject : 추상클래스 & 인터페이스 & 제네릭

package 영화매니저_인터페이스;


//import java.util.Arrays;

public class MovieManagerImpl implements IMovieManager {

	private final int MAX_SIZE = 100;
	private int size = 0;
	Movie[] movieList = new Movie[MAX_SIZE];
	
	private static IMovieManager instance = new MovieManagerImpl();
	
	// 1. 생성자를 private으로 막아서 외부에서 생성하지 못하도록 차단
	private MovieManagerImpl() {
	}

	// 2. 객체를 단 한번만 생성해서 갖고 있는다.[static으로 만들어야 static으로 접근 가능]
	public static IMovieManager getinstance() {
		return instance;
	}

	@Override // 영화 추가 메소드
	public void add(Movie m) {
			if (size < MAX_SIZE) {
				movieList[size++] = m;
			} else
				System.out.println("그 그만 괴롭혀");	
	}

	@Override // 모든 영화 출력 메소드
	public Movie[] getList() {
		
//		if(size == 0) return null; // 확인 디버깅
		Movie[] result = new Movie[size];
		System.arraycopy(movieList, 0, result, 0, size);
		return result;
		// return Arrays.copyOfRange(movieList, 0, size)
		// => 총 길이만큼만 복사한 배열 반환
	}

	@Override // 일반 영화 반환 메소드
	public Movie[] getMovies() {
		int cnt = 0;

		Movie[] temp = new Movie[size];
		for (int i = 0; i < size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) {
				temp[cnt++] = movieList[i];
			}
		}
		if(cnt == 0) return null;
		
		Movie[] result = new Movie[cnt];
		System.arraycopy(temp, 0, result, 0, cnt);

		return result;
	}

	@Override // 시리즈 영화 추가 메소드
	public SeriesMovie[] getSeriesMovies() {
		int cnt = 0;

		SeriesMovie[] temp = new SeriesMovie[size];
		for (int i = 0; i < size; i++) {
			if ((movieList[i] instanceof SeriesMovie)) {
				temp[cnt++] = (SeriesMovie) movieList[i];
			}
		}
		
		if(cnt == 0) return null;
		SeriesMovie[] result = new SeriesMovie[cnt];
		System.arraycopy(temp, 0, result, 0, cnt);

		return result;
	}

	@Override // 영화 제목 찾기 메소드 : 일부 및 전체 탐색
	public Movie[] searchByTitle(String title) {
		int cnt = 0;
		Movie[] temp = new Movie[size];
		for (int i = 0; i < size; i++) {
			if (movieList[i].getTitle().contains(title)) {
				temp[cnt++] = movieList[i];
			}
		}
		if (cnt == 0)
			System.out.println("그딴 영화 없슴다.");

		Movie[] result = new Movie[cnt];
		System.arraycopy(temp, 0, result, 0, cnt);

		return result;
	}

	@Override // 전체 영화 평균 시간 반환 메소드
	public double getRunningTimeAvg() {
		double sum = 0;
		Movie[] result = new Movie[size];
		for (int i = 0; i < size; i++) {
			sum += result[i].getRunningTime();
		}
		return sum / size;
	}

}
