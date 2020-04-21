package uebung4;

public abstract class Article implements HasPrice{
	protected double price;
	protected String designation;

	@Override
	public double getPrice() {
		return this.price;
	}
	
	public String toString() {
		return this.designation;
	}
}
