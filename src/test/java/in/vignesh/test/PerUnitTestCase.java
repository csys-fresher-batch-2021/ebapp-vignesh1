package in.vignesh.test;

import static org.junit.Assert.*;
import org.junit.Test;

import in.vignesh.service.BillManager;

public class PerUnitTestCase {

	@Test
	public void test() {
		
		
		double units=100;
		String type="Home";
	    double per=BillManager.getPerUnitPrice(type, units);
	    System.out.println(per);;
	    assertEquals(0.0f,per,0);

	}

}
