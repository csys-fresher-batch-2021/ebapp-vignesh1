package in.vignesh.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import in.vignesh.service.BillManager;

public class PerUnitTestCase {

	@Test
	public void test1() {
		double units = 25;
		String type = "Home";
		double perUnitPrice = BillManager.getPerUnitPrice(type, units);
		assertEquals(0.0f, perUnitPrice, 0);
	}

	@Test
	public void test2() {
		double units = 50;
		String type = "Commercial";
		double perUnitPrice = BillManager.getPerUnitPrice(type, units);
		assertEquals(10.0f, perUnitPrice, 0);
	}

	@Test
	public void test3() {
		double units = 100;
		String type = "AGRICULTURE";
		double perUnitPrice = BillManager.getPerUnitPrice(type, units);
		assertEquals(5.0f, perUnitPrice, 0);
	}

	@Test
	public void test4() {
		double units = 200;
		String type = "Home";
		double perUnitPrice = BillManager.getPerUnitPrice(type, units);
		assertEquals(20.0f, perUnitPrice, 0);
	}

	@Test
	public void test5() {
		double units = 300;
		String type = "Commercial";
		double perUnitPrice = BillManager.getPerUnitPrice(type, units);
		assertEquals(40.0f, perUnitPrice, 0);
	}

	@Test
	public void test6() {
		double units = 400;
		String type = "Agriculture";
		double perUnitPrice = BillManager.getPerUnitPrice(type, units);
		assertEquals(10.0f, perUnitPrice, 0);
	}

	@Test
	public void test7() {
		double units = 500;
		String type = "Home";
		double perUnitPrice = BillManager.getPerUnitPrice(type, units);
		assertEquals(30.0f, perUnitPrice, 0);
	}

	@Test
	public void test8() {
		double units = 800;
		String type = "Commercial";
		double perUnitPrice = BillManager.getPerUnitPrice(type, units);
		assertEquals(60.0f, perUnitPrice, 0);
	}

	@Test
	public void test9() {
		double units = 1000;
		String type = "Agriculture";
		double perUnitPrice = BillManager.getPerUnitPrice(type, units);
		assertEquals(20.0f, perUnitPrice, 0);
	}

}
