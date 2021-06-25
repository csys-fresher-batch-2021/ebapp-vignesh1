package in.vignesh.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vignesh.validator.UserValidation;

class ConsumerNoTestCase {

	@Order(1)
	@ParameterizedTest
	@CsvSource({ "123490033324,0334900333,vignesh" })
	void invalidTestCase(String consumerNo) {
		boolean isValid = UserValidation.isValidConsumerNo(consumerNo);
		assertFalse(isValid);
	}

	@Order(2)
	@ParameterizedTest
	@CsvSource({ "033490033324" })

	void validTestCase(String consumerNo) {
		boolean valid = UserValidation.isValidConsumerNo(consumerNo);
		assertTrue(valid);
	}

}
