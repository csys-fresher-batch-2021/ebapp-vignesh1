package in.vignesh.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vignesh.validator.UserValidation;

public class CustomerIdTestCase {

	@Test
	public void test1() {

		String customerId = "vig03324";
		boolean value = UserValidation.isValidCustomerId(customerId);
		assertTrue(value);
	}

	@Test
	public void test2() {

		String customerId = "vig0";
		boolean value = UserValidation.isValidCustomerId(customerId);
		assertFalse(value);
	}

	@Test
	public void test3() {

		String customerId = "Vign12";
		boolean value = UserValidation.isValidCustomerId(customerId);
		assertTrue(value);
	}

	@Test
	public void test4() {

		String customerId = "vigneshk";
		boolean value = UserValidation.isValidCustomerId(customerId);
		assertTrue(value);
	}

	@Test
	public void test5() {

		String customerId = "12345678";
		boolean value = UserValidation.isValidCustomerId(customerId);
		assertFalse(value);
	}

	@Test
	public void test6() {

		String customerId = "Vign_12";
		boolean value = UserValidation.isValidCustomerId(customerId);
		assertTrue(value);
	}
	@Test
	public void test7() {

		String customerId = "Vign.12";
		boolean value = UserValidation.isValidCustomerId(customerId);
		assertTrue(value);
	}
	@Test
	public void test8() {

		String customerId = "vign_esh";
		boolean value = UserValidation.isValidCustomerId(customerId);
		assertTrue(value);
	}
	@Test
	public void test9() {

		String customerId = "vign@12";
		boolean value = UserValidation.isValidCustomerId(customerId);
		assertFalse(value);
	}
	@Test
	public void test10() {

		String customerId = "";
		boolean value = UserValidation.isValidCustomerId(customerId);
		assertFalse(value);
	}
	@Test
	public void test11() {

		String customerId = "-vign12";
		boolean value = UserValidation.isValidCustomerId(customerId);
		assertFalse(value);
	}




}
