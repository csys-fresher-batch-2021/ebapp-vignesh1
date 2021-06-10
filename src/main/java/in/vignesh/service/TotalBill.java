package in.vignesh.service;

public class TotalBill {
	private TotalBill() {

	}

	/**
	 * This Function is Used to Calculate Total Bill.
	 * 
	 * @param type
	 * @param units
	 * @return
	 */
	public static double getTotalBill(String type, double units) {
		double perUnitPrice = BillManager.getPerUnitPrice(type, units);
		return perUnitPrice * units;

	}

}
