package uebung3;

public class Knoten {
	private String name;

	public Knoten(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	// ========== ab hier nur getter/setter ==========

	public String getName() {
		return this.name;
	}
}