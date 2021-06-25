package in.vignesh.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vignesh.validator.UserValidation;

class MobileNoTestCase {
	@Order(1)
	@ParameterizedTest
	@CsvSource({ "753004199,4753004199,vignesh,''" })
	void invalidTestCase(String mobileNo) {
		boolean isValid = UserValidation.isValidMobile(mobileNo);
		assertFalse(isValid);
	}

	@Order(2)
	@ParameterizedTest
	@CsvSource({ "7530041990,9095650055,8524046422,6524036322" })

	void validTestCase(String mobileNo) {
		boolean valid = UserValidation.isValidMobile(mobileNo);
		assertTrue(valid);
	}
}
