package com.revature.coursetracker.main;

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
		
		String userInput = null;
		
		// start user input loop
		do {
			// ask user to log in
			System.out.println("Welcome to the Course Tracker 9000!");
			System.out.println("Please log in or create an account.");
			System.out.println("[1] Create Account");
			System.out.println("[2] Login");
			System.out.println("[0] Exit Program");
			
			userInput = scan.nextLine();
			
			switch(userInput) {
			case "1":
				System.out.println("Alright, lets create an account");
				//TODO CreateAccount();
			}
			
			
		} while(userInput.equals("0"));

	}
	
public static boolean CreateAccount

	
}
