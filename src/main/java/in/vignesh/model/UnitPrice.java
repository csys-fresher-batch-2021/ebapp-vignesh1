package in.vignesh.model;

public class UnitPrice {

	private  int minUnit;
	private int maxUnit;
	private  double price;

	public int getMinUnit() {
		return minUnit;
	}

	public int getMaxUnit() {
		return maxUnit;
	}

	public double getPrice() {
		return price;
	}



	// Used for initializing values
	public UnitPrice(int minUnit, int maxUnit, double price) {
		this.minUnit = minUnit;
		this.maxUnit = maxUnit;
		this.price = price;
	}

	@Override
	public String toString() {
		return "UnitPrice [ minUnit=" + minUnit + ", maxUnit=" + maxUnit + ", price=" + price + "]";
	}
}