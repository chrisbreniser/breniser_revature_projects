package com.revature.coursetracker.controller;

import org.apache.log4j.Logger;

import com.revature.coursetracker.pojo.Teacher;
import com.revature.coursetracker.service.TeacherService;
import com.revature.coursetracker.service.TeacherServiceFullStack;

import io.javalin.http.Context;

public class TeacherController {
	
	private static Logger log = Logger.getRootLogger();
	
	TeacherService teacherService = new TeacherServiceFullStack();
	
	public void createTeacher(Context ctx) {

		log.info("TeacherController.createTeacher[Reseived ctx and begining parsing out teacher data]");
		
		String firstname = ctx.formParam("firstname");
		
		String lastname = ctx.formParam("lastname");
		
		String user = ctx.formParam("user");

		String pass = ctx.formParam("pass");

		String email = ctx.formParam("email");
		
		Teacher teacher = new Teacher(firstname, lastname, user, pass, email);
		
		teacherService.createTeacher(teacher);
				
		ctx.html("Created: " + teacher.toString());
	} 
	
	public void getTeacherById(Context ctx) {
		
		log.info("TeacherController.getTeacherById[Reseived ctx and begining parsing out id]");
		
		String id = ctx.formParam("teacherid");
		
		log.info("TeacherController.getTeacherById[Got '" + id + "' from form data");
		
		Teacher teacher = teacherService.getTeacherById(Integer.parseInt(id));
				
		ctx.html(teacher.toString());
	}
	
}
