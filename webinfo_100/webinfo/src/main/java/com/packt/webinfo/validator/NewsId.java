package com.packt.webinfo.validator;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = NewsIdValidator.class)
@Documented
public @interface NewsId {
 String message() default"{com.packt.webstore.validator.NewsId.message}";
 Class<?>[] groups() default {};
 public abstract Class<? extends Payload>[] payload() default{};
}
