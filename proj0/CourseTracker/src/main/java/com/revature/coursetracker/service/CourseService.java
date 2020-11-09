package com.revature.coursetracker.service;

import com.revature.coursetracker.pojo.Assignment;
import com.revature.coursetracker.pojo.Student;

public interface CourseService {
	
	public void addStudent(Student student);
	
	public void removeStudent(int studentId);
	
	public void printStudentListById();
	
	public void addAssignment(Assignment assignment);
	
	public void removeAssignmentById(int assignmentId);
	
	public void printAssignmentListById();
	
	public void setStudentGrade();

}
