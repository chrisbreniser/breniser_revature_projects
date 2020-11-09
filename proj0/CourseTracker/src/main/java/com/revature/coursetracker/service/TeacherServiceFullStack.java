package com.revature.coursetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.coursetracker.Dao.TeacherDao;
import com.revature.coursetracker.Dao.TeacherDaoPostgres;
import com.revature.coursetracker.pojo.Assignment;
import com.revature.coursetracker.pojo.Course;
import com.revature.coursetracker.pojo.Student;
import com.revature.coursetracker.pojo.Teacher;

public class TeacherServiceFullStack implements TeacherService {
	
	private static Logger log = Logger.getRootLogger();

	TeacherDao teacherDao = new TeacherDaoPostgres(); 
	
	@Override
	public Teacher createTeacher(Teacher teacher) {
		log.info("TeacherService.createTeacher[received " + teacher.toString() + " and is sending to Dao]");
		teacherDao.createTeacher(teacher);
		return teacher;
	}
	
	@Override
	public Teacher getTeacherById(int teacherId) {
		Teacher teacher = teacherDao.getTeacherById(teacherId);
		return teacher;
	}
	
	@Override
	public List<Teacher> getTeacherList() {
		
		List<Teacher> teacherList = teacherDao.getTeacherList();
				
		return teacherList;
	}

	@Override
	public void addCourse(int teacherId, Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCourse(int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printCourseListById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCourseById(int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStudentToCourseById(int teacherId, int courseId, Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStudentFromCourseById(int teacherId, int courseId, int studentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAssignmentToCourseById(int teacherId, int courseId, Assignment assignment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAssignmentFromCourse(int teacherId, int courseId, int assignmentId) {
		// TODO Auto-generated method stub
		
	}
	
	
}
