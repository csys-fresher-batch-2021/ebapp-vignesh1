package in.vignesh.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vignesh.validator.UserValidation;

public class ConsumerNoTestCase {

	@Test
	public void test1() {
       String consumerNo="033490033324";
       boolean actual=UserValidation.isValidConsumerNo(consumerNo);
       assertTrue(actual);
	}

	@Test
	public void test2() {
       String consumerNo="123490033324";
       boolean actual=UserValidation.isValidConsumerNo(consumerNo);
       assertFalse(actual);
	}
	@Test
	public void test3() {
       String consumerNo="0334900333";
       boolean actual=UserValidation.isValidConsumerNo(consumerNo);
       assertFalse(actual);
	}
	@Test
	public void test4() {
       String consumerNo="vignesh";
       boolean actual=UserValidation.isValidConsumerNo(consumerNo);
       assertFalse(actual);
	}


}
