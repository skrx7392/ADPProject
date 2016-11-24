package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import javax.swing.*;
import gradeCalculation.*;

public class Home {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				fileInputGUI();
			}
		});
	}
	
	public static void fileInputGUI() {
		JFrame frame = new JFrame("ADP Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDialog.setDefaultLookAndFeelDecorated(true);
		frame.setLayout(new FlowLayout());
		
		JButton button = new JButton("Select Input File");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if(returnValue==JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					frame.setVisible(false);
					createAndShowGUI(selectedFile);
				}
			}
		});
		frame.add(button);
		frame.pack();
		frame.setVisible(true);
	}

	private static void createAndShowGUI(File selectedFile) {
		JFrame frame = new JFrame("ADP Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GradeCalculator calculator = new GradeCalculator();
		ArrayList<Student> students = calculator.calculateAllGrades(selectedFile);
		
		String columnNames[] = {"Name","Grade"};
		Object data[][] = studentGrades(students);
		
		JTable table = new JTable(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		String gradesCountColumnNames[] = {"Grade", "Total Students"};
		Object gradesData[][] = gradesCount(students);
		
		JTable gradesTable = new JTable(gradesData, gradesCountColumnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		gradesTable.setFillsViewportHeight(true);
		JScrollPane gradesScrollPane = new JScrollPane(gradesTable);
		
		frame.add(scrollPane);
		frame.add(gradesScrollPane, BorderLayout.AFTER_LAST_LINE);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static Object[][] studentGrades(ArrayList<Student> students) {
		Object data[][] = new Object[students.size()][];
		int i=0;
		for(Student student : students) {
			data[i] = new String[] {student.Name, student.getGrade().asString()};
			i++;
		}
		return data;
	}
	
	private static Object[][] gradesCount(ArrayList<Student> students) {
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		for(Student student : students) {
			if(countMap.containsKey(student.Grade.asString())) {
				int val = countMap.get(student.Grade.asString()) + 1;
				countMap.put(student.Grade.asString(), val);
			}
			else
				countMap.put(student.Grade.asString(), 1);
		}
		Object data[][] = new Object[countMap.keySet().size()][];
		int i=0;
		for(String key:countMap.keySet()) {
			data[i] = new String[] {key, countMap.get(key).toString()};
			i++;
		}
		return data;
	}

}