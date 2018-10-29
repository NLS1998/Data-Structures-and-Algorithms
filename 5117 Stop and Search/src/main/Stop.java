package main;

public enum Stop {
		personsearch("Person search"),
		personvehiclesearch("Person and Vehicle search");
		private final String str;
		private Stop(String aStr) {
		this.str = aStr;
		}
		public String toString() {
		return this.str;
		}
	
		public static Stop getFrom(String aStr) {
			for (Stop r : Stop.values())
			if (r.str.equals(aStr))
			return r;
			throw new IllegalArgumentException ("Could not find a Role :" + aStr);
			}
		}
	

