package br.com.leoferolive.excepetions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationExcepetion extends RuntimeException {
	
	public UnsuportedMathOperationExcepetion(String ex) {
		super(ex);
	}

	private static final long serialVersionUID = -2688574317752760317L;
}
