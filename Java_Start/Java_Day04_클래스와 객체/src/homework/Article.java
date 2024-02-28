// Author : 문범수
// Date : 2024-01-18
// duration : 20m
// name : 게시판 객체 생성실습
// subject : 클래스와 객체

package homework;

import java.util.Date;

public class Article {
	int articleid;
	String title, content;
	int userSeq, viewCnt;
	Date regDate = new Date();
	
	
	Article(){}
	Article(int articleid, String title, String content, int userSeq, int viewCnt){
		this.articleid = articleid;
		this.title = title;
		this.content = content;
		this.userSeq = userSeq;
		this.viewCnt = viewCnt;
	}
	@Override // 자동완성
	public String toString() {
		return "Article [articleid=" + articleid + ", title=" + title + ", content=" + content + ", userSeq=" + userSeq
				+ ", viewCnt=" + viewCnt + ", regDate=" + regDate + "]";
	}
}
