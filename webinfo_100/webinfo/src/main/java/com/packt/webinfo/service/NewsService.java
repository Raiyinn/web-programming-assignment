package com.packt.webinfo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webinfo.domain.News;

public interface NewsService {
	List <News> getAllNews();
	
	List <News> getNewNews();
	
	News getNewsById(String newsId);
	
	List<News> getNewsByType(String type);
	
	void addNews(News news);
	
	void update(News news);
	
	void delete(String id);
	
	
}
