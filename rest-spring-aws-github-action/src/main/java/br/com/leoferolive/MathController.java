package br.com.leoferolive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.leoferolive.excepetions.UnsuportedMathOperationExcepetion;

@RestController
public class MathController {
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationExcepetion("Por favor, escolha um valor numérico.");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String stringNumber) {
		if (stringNumber == null) {
			return 0D;
		}
		String number = stringNumber.replace(",", ".");
		if (isNumeric(number)) {
			return Double.parseDouble(number);
		}
		return 0D;
	}

	private boolean isNumeric(String stringNumber) {
		if (stringNumber == null) {
			return false;
		}
		String number = stringNumber.replace(",", ".");
		return number.matches("[-+]?[\\d]*\\.?[\\d]+");
	}
}
