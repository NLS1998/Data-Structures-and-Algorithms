package main;

public enum EnumGender {
	MALE("Male"),
	FEMALE("Female"),
	OTHER("Other"); // Fail-Safe
	private final String str;
	private EnumGender(String aStr) {
	this.str = aStr;
	}
	public String toString() {
	return this.str;
	}
	
	public static EnumGender getFrom(String aStr) {
		for (EnumGender r : EnumGender.values())
		if (r.str.equals(aStr))
		return r;
		throw new IllegalArgumentException("No Specified Gender");
	}
}
