package main;

public enum EnumAgeRange {
	CHILD("under 10"),
	Minor("10-17"), // 10 - 17
	YOUNGADULT("18-24"), // 18 - 24
	ADULT("25-34"), // 25 - 34
	MIDDLEAGE("over 34"), // 35+
	UNSPECIFIED("");
	private final String st;
	private EnumAgeRange(String age) {
	this.st = age;
	}
	public String toString() {
	return this.st;
	}
	
	public static EnumAgeRange getFrom(String age) {
		for (EnumAgeRange r : EnumAgeRange.values())
		if (r.st.equals(age))
		return r;
		throw new IllegalArgumentException();
	}
}// Fail-Safe

