package in.vignesh.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vignesh.service.TotalBill;

public class TotalBillTestCase {

	@Test
	public void test1() {
		double units = 25;
		String type = "Home";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(0.0f, totalPrice, 0);
	}

	@Test
	public void test2() {
		double units = 50.5;
		String type = "Commercial";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(505.0f, totalPrice, 0);
	}

	@Test
	public void test3() {
		double units = 100;
		String type = "AGRICULTURE";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(500.0f, totalPrice, 0);
	}

	@Test
	public void test4() {
		double units = 200;
		String type = "Home";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(4000.0f, totalPrice, 0);
	}

	@Test
	public void test5() {
		double units = 300;
		String type = "Commercial";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(12000.0f, totalPrice, 0);
	}

	@Test
	public void test6() {
		double units = 400;
		String type = "Agriculture";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(4000.0f, totalPrice, 0);
	}

	@Test
	public void test7() {
		double units = 500;
		String type = "Home";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(15000.0f, totalPrice, 0);
	}

	@Test
	public void test8() {
		double units = 800;
		String type = "Commercial";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(48000.0f, totalPrice, 0);
	}

	@Test
	public void test9() {
		double units = 1000;
		String type = "Agriculture";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(20000.0f, totalPrice, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test10() {
		double units = 2000;
		String type = "Agriculture";
		TotalBill.getTotalBill(type, units);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test11() {
		double units = 200;
		String type = "Agri";
		TotalBill.getTotalBill(type, units);
	}

}
