// Author : 문범수
// Date : 2024-01-23
// duration : 60m
// name : 영화매니저 인터페이스
// subject : 추상클래스 & 인터페이스 & 제네릭

package 영화매니저_인터페이스;

public class SeriesMovie extends Movie {
	private int seriesNum;
	private String episode;

	SeriesMovie() {
	}

	SeriesMovie(int id, String title, String director, String genre, int runningTime, int seriesNum, String episode) {
		super(id, title, director, genre, runningTime);
		this.seriesNum = seriesNum;
		this.episode = episode;
	}

	public int getSeriesNum() {
		return seriesNum;
	}

	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	@Override
	public String toString() {
		return "SeriesMovie : " + super.toString() + "seriesNum=" + getSeriesNum() + ", episode=" + getEpisode();
	}
}
