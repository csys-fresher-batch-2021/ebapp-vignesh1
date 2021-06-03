package in.vignesh.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vignesh.validator.UserValidation;

class PasswordTestCase {
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"viki@75300,vigneshk,75300419,Viki 75300''"
	})
	void invalidTestCase(String password) {
		boolean isValid = UserValidation.isValidPassword(password);
		assertFalse(isValid);
	}
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"Viki@75300"
	})
	
	void validTestCase(String password ) {
		boolean Valid = UserValidation.isValidPassword(password);
		assertTrue(Valid);
	}
}
