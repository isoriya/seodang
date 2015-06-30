package com.dog.seodang.contents.vo;

public class ContentsVo {

	private int contentsSeq;
	private long userSeq;
	private String title;
//	private String contents;
	private String contentsKor;
	private String contentsEng;

	public int getContentsSeq() {
		return contentsSeq;
	}

	public void setContentsSeq(int contentsSeq) {
		this.contentsSeq = contentsSeq;
	}

	public long getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(long userSeq) {
		this.userSeq = userSeq;
	}

//	public String getContents() {
//		return contents;
//	}
//
//	public void setContents(String contents) {
//		this.contents = contents;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentsKor() {
		return contentsKor;
	}

	public void setContentsKor(String contentsKor) {
		this.contentsKor = contentsKor;
	}

	public String getContentsEng() {
		return contentsEng;
	}

	public void setContentsEng(String contentsEng) {
		this.contentsEng = contentsEng;
	}

}
