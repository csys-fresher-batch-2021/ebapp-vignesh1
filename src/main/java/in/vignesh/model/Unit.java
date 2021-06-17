package in.vignesh.model;
public class Unit {
	

	private String type;
	private double minUnit;
	private double maxUnit;
	private double price;
	
     
	public String getType() {
		return type;
	}

	public double getMinUnit() {
		return minUnit;
	}

	public double getMaxUnit() {
		return maxUnit;
	}

	public double getPrice() {
		return price;
	}

	// Used for initializing values
	public Unit(double minUnit, double maxUnit, double price) {
//		this.type=type;
		this.minUnit = minUnit;
		this.maxUnit = maxUnit;
		this.price = price;
	}

	public Unit(String type, double minUnit, double maxUnit, double price) {
		this.type = type;
		this.minUnit = minUnit;
		this.maxUnit = maxUnit;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Unit [type=" + type + ", minUnit=" + minUnit + ", maxUnit=" + maxUnit + ", price=" + price + "]";
	}
	

	
}
