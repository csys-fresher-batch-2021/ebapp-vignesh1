package in.vignesh.service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import  in.vignesh.model.UnitPrice;
public class BillManager {
	static Map<String, List<UnitPrice>> map = new LinkedHashMap<>();
	static {
		UnitPrice unitPriceHome = new UnitPrice(0, 100, 0.0);
		UnitPrice unitPriceHome1 = new UnitPrice(101, 400, 20.0);
		UnitPrice unitPriceHome2 = new UnitPrice(401, 1000, 30.0);
		List<UnitPrice> homeList = new ArrayList<>();
		homeList.add(unitPriceHome);
		homeList.add(unitPriceHome1);
		homeList.add(unitPriceHome2);
		map.put("HOME", homeList);
		UnitPrice unitPriceCom = new UnitPrice(0, 100, 10.0);
		UnitPrice unitPriceCom1 = new UnitPrice(101, 400, 40.0);
		UnitPrice unitPriceeCom2 = new UnitPrice(401, 1000, 60.0);
		List<UnitPrice> CommericialList = new ArrayList<>();
		CommericialList.add(unitPriceCom);
		CommericialList.add(unitPriceCom1);
		CommericialList.add(unitPriceeCom2);
		map.put("COMMERCIAL", CommericialList);
		UnitPrice unitPriceAgri = new UnitPrice(0, 100, 5.0);
		UnitPrice unitPriceAgri1 = new UnitPrice(101, 400, 10.0);
		UnitPrice unitPriceAgri2 = new UnitPrice(401, 1000, 20.0);
		List<UnitPrice> AgricultureList = new ArrayList<>();
		AgricultureList.add(unitPriceAgri);
		AgricultureList.add(unitPriceAgri1);
		AgricultureList.add(unitPriceAgri2);
		map.put("AGRICULTURE", AgricultureList);
	}
	/**
	 * This function return list of map
	 * @return
	 */
	public static Map<String, List<UnitPrice>> getList() {
		return map;
	}
}