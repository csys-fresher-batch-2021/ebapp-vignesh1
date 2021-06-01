package in.vignesh.test;

import static org.junit.Assert.*;


import org.junit.Test;

import in.vignesh.validator.UserValidation;

public class MobileNoTestCase {

	@Test
	public void test1() {
       String mobileNo="7530041990";
       boolean actual=UserValidation.isValidMobile(mobileNo);
       assertTrue(actual);
	}
	@Test
	public void test2() {
       String mobileNo="753004199";
       boolean actual=UserValidation.isValidMobile(mobileNo);
       assertFalse(actual);
	}
	
	@Test
	public void test3() {
       String mobileNo="4753004199";
       boolean actual=UserValidation.isValidMobile(mobileNo);
       assertFalse(actual);
	}
	@Test
	public void test4() {
       String mobileNo="vignesh";
       boolean actual=UserValidation.isValidMobile(mobileNo);
       assertFalse(actual);
	}
	@Test
	public void test5() {
       String mobileNo="";
       boolean actual=UserValidation.isValidMobile(mobileNo);
       assertFalse(actual);
	}
	
}
