// Author : 문범수
// Date : 2024-01-22
// duration : 60m
// name : 영화 상속 실습
// subject : 상속과 다형성

package 영화상속실습;

public class SeriesMovie extends Movie{
	private int seriesNum;
	private String episode;
	
	SeriesMovie() {
		super();
	}
	
	SeriesMovie(int id, String title, String director, String genre, int runningTime,int seriesNum, String episode){
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
		return "SeriesMovie [seriesNum=" + seriesNum + ", episode=" + episode + ", id=" + id + ", runningTime="
				+ runningTime + ", title=" + title + ", director=" + director + ", genre=" + genre + "]";
	}

	
}
