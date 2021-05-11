package in.vignesh.model;

public class UnitPrice {
	public int minUnit;
	public int maxUnit;
	public double price;

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