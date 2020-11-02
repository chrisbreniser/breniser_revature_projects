package com.revature.coursetracker.main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.coursetracker.pojo.Assignment;
import com.revature.coursetracker.pojo.Course;
import com.revature.coursetracker.pojo.Student;
import com.revature.coursetracker.pojo.Teacher;

public class CourseTrackerDriver {
	
	private static Logger log = Logger.getRootLogger();
	
	private static Course myCourse = new Course();
		
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		log.info("Program has started");
		
		String userInput;
		
		System.out.println("What is the name of this course?");
		userInput = scan.nextLine();
		myCourse.setCourseName(userInput);

		do {
			System.out.println("Please choose one of the following:");
			System.out.println("[1] Set Teacher");
			System.out.println("[2] Add Student");
			System.out.println("[3] Add Assignment");
			System.out.println("[4] Check Course Data");
			System.out.println("[0] exit");
			
			userInput = scan.nextLine();

			switch (userInput) {
			case "1":
				if(setTeacher()) {
					System.out.println("Teacher was set!");
				} else {
					System.out.println("Failed to add teacher.");
				}
				break;
			case "2":
				if (addStudent()) {
					System.out.println("Student was added!");
				} else {
					System.out.println("Failed to add student.");
				}
				break;
			case "3":
				if (addAssignment()) {
					System.out.println("Assignment was added!");
				} else {
					System.out.println("Failed to add assignment.");
				}
				break;
			case "4":
				System.out.println("----------------------------");
				System.out.println(myCourse.getCourseName());
				System.out.println("Teacher: " + myCourse.getTeacher());
				System.out.println("Student List: " + myCourse.getStudents());
				System.out.println("Assignments List: " + myCourse.getAssignments());
				System.out.println("----------------------------");
				break;
			case "0":
				System.out.println("Terminating data and exiting program");
				break;
			default:
				System.out.println("Invalid choice: " + userInput + ", You must choose between 0-4");
				break;
			}

		} while (!"0".equals(userInput));
		
	}
	
	private static boolean setTeacher() {
		
		// get teacher info
		System.out.println("What is the teachers first name?");
		String firstName = scan.nextLine();
		System.out.println("What is the teachers last name?");
		String lastName = scan.nextLine();
		System.out.println("What is the teachers title? (ex: Mr. Mrs. Dr.)");
		String prefixName = scan.nextLine();
		
		Teacher teacher = new Teacher(firstName, lastName, prefixName);
		
		if(myCourse.setTeacher(teacher)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean addStudent() {
		// get student info
		System.out.println("What is the students first name?");
		String firstName = scan.nextLine();
		System.out.println("What is the students last name?");
		String lastName = scan.nextLine();
		double gpa;
		String userInput;
		do {
			System.out.println("What is the students gpa? (ex: 3.4)");
			userInput = scan.nextLine(); // pulled in user input as a string 
			gpa = Double.parseDouble(userInput); // and parse as a double to remove the trailing newline char from system.in
		} while(gpa > 4 || gpa < 0);
		
		Student student = new Student(firstName, lastName, gpa);
		
		if(myCourse.addStudent(student))
			return true;
		
		return false;
	}
	
	private static boolean addAssignment() {
		
		// get student info
			System.out.println("What is the assignment titled?");
			String title = scan.nextLine();
			
			LocalDate startDate = null;
			LocalDate dueDate = null;
			do {
				System.out.println("When is this assignment assigned? Format: yyyy-mm-dd");
				String start = scan.nextLine();
				System.out.println("When is this assignment due? Format: yyyy-mm-dd");
				String due = scan.nextLine();

				try {
					startDate = LocalDate.parse(start);
					dueDate = LocalDate.parse(due);
				} catch (DateTimeParseException e) {
					System.out.println("Could not parse dates. Use format yyyy-mm-dd");
					log.warn("DateTimeParseException caught", e);
				}
			} while(startDate == null || dueDate == null);
			
			Assignment assignment = new Assignment(title, startDate, dueDate);
			
			if(myCourse.addAssignment(assignment))
				return true;
			
			return false;
	}

}
