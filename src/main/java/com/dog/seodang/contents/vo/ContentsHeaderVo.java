package com.dog.seodang.contents.vo;

public class ContentsHeaderVo {
	private int contentsSeq;
	private long userSeq;
	private String title;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
