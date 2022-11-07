package com.packt.webinfo.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webinfo.domain.News;

public interface NewsRepository {
	
	List <News> getAllNews();
	
	News getNewsById(String newsId);
	
	List<News> getNewsByCategory(String category);
	
	Set<News> getNewsByFilter(Map<String, List<String>>
	filterParams);
	
	void addNews(News news);
}
