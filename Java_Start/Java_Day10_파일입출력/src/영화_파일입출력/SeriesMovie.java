// Author : 문범수
// Date : 2024-01-25
// duration : 20m
// name : 영화 예외처리
// subject : throws

package 영화_파일입출력;

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
