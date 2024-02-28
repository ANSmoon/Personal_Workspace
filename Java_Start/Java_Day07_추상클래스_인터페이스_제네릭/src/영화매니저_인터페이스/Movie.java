// Author : 문범수
// Date : 2024-01-23
// duration : 60m
// name : 영화매니저 인터페이스
// subject : 추상클래스 & 인터페이스 & 제네릭

package 영화매니저_인터페이스;

public class Movie {
	private int id, runningTime;
	private String title, director, genre;

	Movie() {
	}

	Movie(int id, String title, String director, String genre, int runningTime) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	// get으로 받아온다.
	@Override
	public String toString() {
		return "Movie : id=" + getId() + ", runningTime=" + getRunningTime() + ", title=" + getTitle() + ", director="
				+ getDirector() + ", genre=" + getGenre() + "\n";
	}

}
