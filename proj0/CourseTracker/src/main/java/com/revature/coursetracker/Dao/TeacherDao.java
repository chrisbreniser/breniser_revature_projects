package com.revature.coursetracker.Dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.coursetracker.pojo.Teacher;

public interface TeacherDao {
	
	public void createTeacher(Teacher teacher);
	
	public Teacher getTeacherById(int teacherId);
	
	public List<Teacher> getTeacherList();
	
	public void updateTeacher(int teacherId, Teacher teacher);
	
	public void deleteTeacher(int teacherid);


}
