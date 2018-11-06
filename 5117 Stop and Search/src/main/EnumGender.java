package main;

public enum EnumGender {
	MALE("Male"),
	FEMALE("Female"),
	Other(""); // Fail-Safe
	private final String sr;
	private EnumGender(String aSr) {
	this.sr = aSr;
	}
	public String toString() {
	return this.sr;
	}
	
	public static EnumGender getFrom(String aSr) {
		for (EnumGender r : EnumGender.values())
		if (r.sr.equals(aSr))
		return r;
		throw new IllegalArgumentException("No Specified Gender");
	}
}
