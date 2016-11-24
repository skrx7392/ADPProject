package gradeCalculation;

public class Student {
	
	public String Name;
	private int HW1;
	private int HW2;
	private int HW3;
	private int Midterm;
	private int Project;
	private int Final;
	public Grades Grade;
	
	public void setHW1(int score) {
		this.HW1 = score;
	}
	
	public void setHW2(int score) {
		this.HW2 = score;
	}
	
	public void setHW3(int score) {
		this.HW3 = score;
	}
	
	public void setMidterm(int score) {
		this.Midterm = score;
	}
	
	public void setProject(int score) {
		this.Project = score;
	}
	
	public void setFinal(int score) {
		this.Final = score;
	}
	
	public Grades getGrade() {
		return Grade;
	}
	
	public void setGrade() {
		double finalScore = 0.45*((this.HW1 + this.HW2 + this.HW3)/3) + 0.25*this.Project + 0.30*((this.Midterm + this.Final)/2);
		if(finalScore>89)
			this.Grade = Grades.A;
		else if(finalScore>79)
			this.Grade = Grades.B;
		else if(finalScore>69)
			this.Grade = Grades.C;
		else if(finalScore>59)
			this.Grade = Grades.D;
		else
			this.Grade = Grades.F;
	}

}
