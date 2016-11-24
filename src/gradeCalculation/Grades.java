package gradeCalculation;

public enum Grades {
	A("A"),
	B("B"),
	C("C"),
	D("D"),
	F("F");
	
	public String asString() {
		return asString;
	}
	
	private final String asString;
	
	private Grades(String asString) {
		this.asString = asString;
	}
}
