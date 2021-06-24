package in.vignesh.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import in.vignesh.dao.PriceListDAO;
import in.vignesh.model.Unit;

public class BillManager {
	private BillManager() {

	}

	public static Map<String, List<Unit>> getList() {
		Map<String, List<Unit>> map = new LinkedHashMap<>();
		List<Unit> allList = PriceListDAO.getAllList();
		for (Unit unit : allList) {

			String type = unit.getType();
			List<Unit> priceList = map.containsKey(type) ? map.get(type) : new ArrayList<>();
			Unit unitPrice = new Unit(unit.getMinUnit(), unit.getMaxUnit(), unit.getPrice());
			priceList.add(unitPrice);
			map.put(type, priceList);
		}

		return map;
	}

	/**
	 * This Function is Used to Calculate Per Unit Price
	 * 
	 * @param type
	 * @param units
	 * @return
	 */

	public static double getPerUnitPrice(String type, double units) {
		Map<String, List<Unit>> map = getList();
		if ((units < 0 || units > 1000)) {
			throw new IllegalArgumentException("Invalid Unit");
		}
		if (!(type != null && map.containsKey(type.toUpperCase()))) {
			throw new IllegalArgumentException("Invalid Type");

		}
		double perUnitPrice = 0;
		for (Map.Entry<String, List<Unit>> entry : map.entrySet()) {
			String key = entry.getKey();
			List<Unit> unitPrice = entry.getValue();
			for (Unit up : unitPrice) {
				if (key.equalsIgnoreCase(type) && units >= up.getMinUnit() && units <= up.getMaxUnit()) {
					perUnitPrice = up.getPrice();
					break;
				}

			}
		}
		return perUnitPrice;

	}
}