package com.packt.webinfo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No news found under this category")
public class NoNewsFoundUnderTypeException extends
RuntimeException{
 private static final long serialVersionUID =3935230281455340039L;
}
