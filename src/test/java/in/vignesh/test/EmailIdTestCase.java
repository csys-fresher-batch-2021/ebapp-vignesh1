package in.vignesh.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vignesh.validator.UserValidation;

class EmailIdTestCase {
	@Order(1)
	@ParameterizedTest
	@CsvSource({ "emailgmail.com,12334566,vignesh" })
	void invalidTestCase(String email) {
		boolean isValid = UserValidation.isValidEmail(email);
		assertFalse(isValid);
	}

	@Order(2)
	@ParameterizedTest
	@CsvSource({ "email@gmail.com", "email12@gmail.com" })

	void validTestCase(String email) {
		boolean valid = UserValidation.isValidEmail(email);
		assertTrue(valid);
	}

}