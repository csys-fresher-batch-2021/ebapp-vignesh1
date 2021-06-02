package in.vignesh.test;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import in.vignesh.service.BillManager;
import in.vignesh.model.UnitPrice;

public class DisplayTestCase {
	@Test
	public void test() {
		Map<String, List<UnitPrice>> numberOfList = BillManager.getList();
		assertEquals(3, numberOfList.size());
	}
}
