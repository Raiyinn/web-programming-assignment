package com.packt.webinfo.validator;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.packt.webinfo.domain.News;
@Component
public class HeadlineValidator implements Validator{
 public boolean supports(Class<?> clazz) {
 return News.class.isAssignableFrom(clazz);
 }
 public void validate(Object target, Errors errors) {
 News news = (News) target;
 if(news.getHeadline() == null) {

errors.rejectValue("headline","com.packt.webstore.validator.UnitsInStockValidator.message");
 }
 }
}