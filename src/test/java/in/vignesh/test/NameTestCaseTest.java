package in.vignesh.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vignesh.validator.UserValidation;

class NameTestCaseTest {

	@Order(1)
	@ParameterizedTest
	@CsvSource({ "'', vignesh@, 1234, vignes1" })
	void invalidTestCase(String name) {
		boolean isValid = UserValidation.isValidName(name);
		assertFalse(isValid);
	}

	@Order(2)
	@ParameterizedTest
	@CsvSource({ "vignesh,VIGNESH kannan" })

	void validTestCase(String name) {
		boolean valid = UserValidation.isValidName(name);
		assertTrue(valid);
	}
}
