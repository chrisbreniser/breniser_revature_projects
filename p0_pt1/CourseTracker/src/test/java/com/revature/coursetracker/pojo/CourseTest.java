package com.revature.coursetracker.pojo;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CourseTest {
	
	private static Course course;
	
	private static Student student;
	private static Set<Student> students = new HashSet<Student>();
	
	private static Assignment assignment;
	private static Set<Assignment> assignments = new HashSet<Assignment>();

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
				
		course = new Course("CS 123", null);
				
		student = new Student("Hank", "Hill", 2.4);
		students.add(student);
		
		
		String start = "2020-10-10";
		String due = "2020-10-20";
		assignment = new Assignment("Project 1", LocalDate.parse(start), LocalDate.parse(due));
		assignments.add(assignment);
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {		
	}

	@Test
	public void addStudentTest() {
		course.addStudent(student);
		assertEquals(students, course.getStudents());
	}
	
	@Test
	public void addAssignmentTest() {
		course.addAssignment(assignment);
		assertEquals(assignments, course.getAssignments());
	}

}
