package com.packt.webinfo.validator;

import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.packt.webinfo.domain.News;

public class NewsValidator implements Validator {
	@Autowired
	private javax.validation.Validator beanValidator;
	private Set<Validator> springValidators;

	public NewsValidator() {
		springValidators = new HashSet<Validator>();
	}

	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	public boolean supports(Class<?> clazz) {
		return News.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(target);
		for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, "", message);
		}
		for (Validator validator : springValidators) {
			validator.validate(target, errors);
		}
	}
}
