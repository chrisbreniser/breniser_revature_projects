package com.revature.coursetracker.Dao;

import com.revature.coursetracker.pojo.Teacher;

public interface TeacherDao {
	
	public void createTeacher(Teacher teacher);
	
	public void readTeacher(int teacherId);
	
	public void readAllTeachers();
	
	public void updateTeacher(int teacherId, Teacher teacher);
	
	public void deleteTeacher(int teacherid);

}
