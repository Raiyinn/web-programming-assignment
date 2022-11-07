package com.packt.webinfo.exception;

public class NewsNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -694354952032299587L;
	private String newsId;

	public NewsNotFoundException(String newsId) {
		this.newsId = newsId;
	}

	public String getNewsId() {
		return newsId;
	}
}
