package main;

public enum EnumAgeRange {
	Minor("10-17"), // 10 - 17
	YOUNGADULT("18-24"), // 18 - 24
	ADULT("25-34"), // 25 - 34
	MIDDLEAGE("over 34"), // 35+
	UNSPECIFIED("");
	private final String st;
	private EnumAgeRange(String aStr) {
	this.st = aStr;
	}
	public String toString() {
	return this.st;
	}
	
	public static EnumAgeRange getFrom(String aStr) {
		for (EnumAgeRange r : EnumAgeRange.values())
		if (r.st.equals(aStr))
		return r;
		throw new IllegalArgumentException();
	}
}// Fail-Safe

