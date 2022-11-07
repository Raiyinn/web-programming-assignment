package com.packt.webinfo.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webinfo.dao.NewsDao;
import com.packt.webinfo.domain.News;
import com.packt.webinfo.domain.repository.NewsRepository;
import com.packt.webinfo.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsDao newsRepository;

	@Override
	public List<News> getAllNews() {
		return newsRepository.getAllNews();
	}
	
	@Override
	public List<News> getNewNews() {
		return newsRepository.getNewNews();
	}

	@Override
	public News getNewsById(String newsID) {
		return newsRepository.getNewsById(newsID);
	}

	public List<News> getNewsByType(String type) {
		return newsRepository.getNewsByType(type);
	}
	
	public void addNews(News news) {
		 newsRepository.addNews(news);
		}

	@Override
	public void update(News news) {
		newsRepository.update(news);
		
	}

	@Override
	public void delete(String id) {
		newsRepository.delete(id);
		
	}



}
