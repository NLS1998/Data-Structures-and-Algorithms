package main;

public enum EnumClothesRemoval {
	True("TRUE"),
	False("FALSE"),
	Blank("");
	private final String str;
	private EnumClothesRemoval(String aStr) {
	this.str = aStr;
	}
	public String toString() {
	return this.str;
	}
	
	public static EnumClothesRemoval getFrom(String aStr) {
		for (EnumClothesRemoval r : EnumClothesRemoval.values())
		if (r.str.equals(aStr))
		return r;
		throw new IllegalArgumentException("No Outcome");
	}
}