package me.light.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import me.light.controller.NotMathUserIdException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotMathUserIdException.class)
	public String notMathUserId() {
		System.out.println("NotMathUserIdException 예외 발생");
		return "member/myPage_error";
	}
}
