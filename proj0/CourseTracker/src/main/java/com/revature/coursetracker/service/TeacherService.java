package com.revature.coursetracker.service;

import com.revature.coursetracker.pojo.Assignment;
import com.revature.coursetracker.pojo.Course;
import com.revature.coursetracker.pojo.Student;
import com.revature.coursetracker.pojo.Teacher;

public interface TeacherService {
	
	public Teacher createTeacher(Teacher teacher);
	
	public Teacher getTeacherById(int teacherId);
	
	public void addCourse(int teacherId, Course course);
	
	public void removeCourse(int courseId);
	
	public void printCourseListById();
	
	public void getCourseById(int courseId);
	
	public void addStudentToCourseById(int teacherId, int courseId, Student student);
	
	public void removeStudentFromCourseById(int teacherId, int courseId, int studentId);
	
	public void addAssignmentToCourseById(int teacherId, int courseId, Assignment assignment);
	
	public void removeAssignmentFromCourse(int teacherId, int courseId, int assignmentId);

}