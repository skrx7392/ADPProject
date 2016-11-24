package gradeCalculation;

import java.io.File;
import java.util.*;

public class GradeCalculator {
	
	public ArrayList<Student> calculateAllGrades(File selectedFile) {
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			Scanner sc = new Scanner(selectedFile);
			while(sc.hasNextLine()) {
				String[] line = sc.nextLine().split(",");
				generateStudentGrade(students, line);
			}
			sc.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return students;
	}
	
	private void generateStudentGrade(ArrayList<Student> students, String[] line) {
		if(!line[1].equalsIgnoreCase("HW1")) {
			Student student = new Student();
			student.Name = line[0];
			student.setHW1(Integer.parseInt(line[1]));
			student.setHW2(Integer.parseInt(line[2]));
			student.setHW3(Integer.parseInt(line[3]));
			student.setMidterm(Integer.parseInt(line[4]));
			student.setProject(Integer.parseInt(line[5]));
			student.setFinal(Integer.parseInt(line[6]));
			student.setGrade();
			students.add(student);
		}
	}

}
