package in.vignesh.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.vignesh.service.BillManager;

public class PerUnitTestCase {

	@Test
	public void test() {
		
		
		int units=500;
		String type="Home";
	    double per=BillManager.getPerUnitPrice(type, units);
	    System.out.println(per);

	}

}
