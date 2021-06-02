package in.vignesh.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.vignesh.validator.UserValidation;

class MobileNoTestCase {
		@Order(1)
		@ParameterizedTest
		@CsvSource({
			"753004199,4753004199,vignesh,''"
		})
		void invalidTestCase(String mobileNo) {
			boolean isValid = UserValidation.isValidMobile(mobileNo);
			assertFalse(isValid);
		}
		@Order(2)
		@ParameterizedTest
		@CsvSource({
			"7530041990,9095650055,8524046422,6524036322"
		})
		
		void validTestCase(String mobileNo ) {
			boolean Valid = UserValidation.isValidMobile(mobileNo);
			assertTrue(Valid);
		}

//	@Test
//	public void test1() {
//       String mobileNo="7530041990";
//       boolean actual=UserValidation.isValidMobile(mobileNo);
//       assertTrue(actual);
//	}
//	@Test
//	public void test2() {
//       String mobileNo="753004199";
//       boolean actual=UserValidation.isValidMobile(mobileNo);
//       assertFalse(actual);
//	}
//	
//	@Test
//	public void test3() {
//       String mobileNo="4753004199";
//       boolean actual=UserValidation.isValidMobile(mobileNo);
//       assertFalse(actual);
//	}
//	@Test
//	public void test4() {
//       String mobileNo="vignesh";
//       boolean actual=UserValidation.isValidMobile(mobileNo);
//       assertFalse(actual);
//	}
//	@Test
//	public void test5() {
//       String mobileNo="";
//       boolean actual=UserValidation.isValidMobile(mobileNo);
//       assertFalse(actual);
//	}
//	
}
