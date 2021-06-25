package in.vignesh.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vignesh.validator.UserValidation;

class CustomerIdTestCase {
	@Order(1)
	@ParameterizedTest
	@CsvSource({ "vig0,12345678,vign@12,-vign12" })
	void invalidTestCase(String customerId) {
		boolean isValid = UserValidation.isValidCustomerId(customerId);
		assertFalse(isValid);
	}

	@Order(2)
	@ParameterizedTest
	@CsvSource({ "vig03324,Vign12,vigneshk,Vign_12,Vign.12" })

	void validTestCase(String customerId) {
		boolean valid = UserValidation.isValidCustomerId(customerId);
		assertTrue(valid);
	}
}
