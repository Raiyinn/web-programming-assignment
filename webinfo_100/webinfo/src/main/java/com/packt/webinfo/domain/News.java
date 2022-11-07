package com.packt.webinfo.domain;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.packt.webinfo.validator.NewsId;

public class News {
	private String newsId;
	private String type;
	@NotEmpty(message= "{NotEmpty.News.type.validation}")
	private String headline;
	@NotEmpty(message= "{NotEmpty.News.headline.validation}")
	private String description;
	private MultipartFile newsImage;

	public MultipartFile getNewsImage() {
		return newsImage;
	}

	public void setNewsImage(MultipartFile newsImage) {
		this.newsImage = newsImage;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public News() {
		super();
	}

	public News(String newsId, String type, String headline) {
		this.newsId = newsId;
		this.type = type;
		this.headline = headline;
	}

	// add setters and getters for all the fields here
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (newsId == null) {
			if (other.newsId != null)
				return false;
		} else if (!newsId.equals(other.newsId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((newsId == null) ? 0 : newsId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", type=" + type + "]";
	}
}
