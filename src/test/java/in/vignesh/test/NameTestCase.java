package in.vignesh.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vignesh.validator.UserValidation;

public class NameTestCase {

	@Test
	public void test1() {
		String name="vignesh";
		boolean actual=UserValidation.isValidName(name);
		assertTrue(actual);
	}

	@Test
	public void test2() {
		String name="VIGNESH kannan";
		boolean actual=UserValidation.isValidName(name);
		assertTrue(actual);
	}
	

	@Test
	public void test3() {
		String name="vignes1";
		boolean actual=UserValidation.isValidName(name);
		assertFalse(actual);
	}


	@Test
	public void test4() {
		String name="12345";
		boolean actual=UserValidation.isValidName(name);
		assertFalse(actual);
	}
	@Test
	public void test5() {
		String name="vignesh@";
		boolean actual=UserValidation.isValidName(name);
		assertFalse(actual);
	}




}
