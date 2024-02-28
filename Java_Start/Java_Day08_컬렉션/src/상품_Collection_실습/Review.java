package 상품_Collection_실습;

public class Review {
	private int reviewid;
	private String pCode, writer, content;
	
	Review() {}
	Review(int reviewid, String pCode, String writer, String content){
		this.reviewid = reviewid;
		this.pCode = pCode;
		this.writer = writer;
		this.content = content;
	}
	public int getReviewid() {
		return reviewid;
	}
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Review [getReviewid()=" + getReviewid() + ", getpCode()=" + getpCode() + ", getWriter()=" + getWriter()
				+ ", getContent()=" + getContent() + "]";
	}
	
	
}
