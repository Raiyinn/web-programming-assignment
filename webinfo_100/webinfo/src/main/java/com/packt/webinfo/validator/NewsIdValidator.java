package com.packt.webinfo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.packt.webinfo.domain.News;
import com.packt.webinfo.exception.NewsNotFoundException;
import com.packt.webinfo.service.NewsService;

public class NewsIdValidator implements ConstraintValidator<NewsId, String> {
	@Autowired
	private NewsService newsService;

	public void initialize(NewsId constraintAnnotation) {
		// intentionally left blank; this is the place to initialize the constraint
		// annotation for any sensible default values.
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		News news;
		try {
			news = newsService.getNewsById(value);
		} catch (NewsNotFoundException e) {
			return true;
		}
		if (news != null) {
			return false;
		}
		return true;
	}
}
