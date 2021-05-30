package in.vignesh.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vignesh.validator.UserValidation;

public class PasswordTestCase {

	@Test
	public void test1() {
		String password = "Viki@75300";
		boolean actual = UserValidation.isValidPassword(password);
		assertTrue(actual);

	}

	@Test
	public void test2() {
		String password = "viki@75300";
		boolean actual = UserValidation.isValidPassword(password);
		assertFalse(actual);

	}

	@Test
	public void test3() {
		String password = "vigneshk";
		boolean actual = UserValidation.isValidPassword(password);
		assertFalse(actual);

	}

	@Test
	public void test4() {
		String password = "75300419";
		boolean actual = UserValidation.isValidPassword(password);
		assertFalse(actual);

	}

	@Test
	public void test5() {
		String password = "Viki 75300";
		boolean actual = UserValidation.isValidPassword(password);
		assertFalse(actual);
	}

	@Test
	public void test6() {
		String password = " ";
		boolean actual = UserValidation.isValidPassword(password);
		assertFalse(actual);
	}

}
