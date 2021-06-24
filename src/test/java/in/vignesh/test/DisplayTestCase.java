package in.vignesh.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import in.vignesh.model.Unit;
import in.vignesh.service.BillManager;

public class DisplayTestCase {
	@Test
	public void test() {
		Map<String, List<Unit>> numberOfList = BillManager.getList();
		assertEquals(3, numberOfList.size());

	}
}
