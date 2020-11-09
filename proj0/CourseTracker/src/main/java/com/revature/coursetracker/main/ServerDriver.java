package com.revature.coursetracker.main;

import org.apache.log4j.Logger;

import com.revature.coursetracker.controller.TeacherController;

import io.javalin.Javalin;

public class ServerDriver {
	
	private static Logger log = Logger.getRootLogger();
	
	private static TeacherController teacherController = new TeacherController();

	public static void main(String[] args) {
		Javalin app = Javalin.create().start(9090); // sets up and starts out server
		app.get("/hello", ctx -> ctx.html("Hello World"));
		app.get("/hello2", ctx -> ctx.result("Go Beaves"));
		app.post("/teacher/createTeacher", ctx -> teacherController.createTeacher(ctx));
		app.get("/teacher/getTeacherById", ctx -> teacherController.getTeacherById(ctx));
		app.get("/teacher/getTeacherList", ctx -> teacherController.getTeacherList(ctx));
//		app.post("/createStudent", ctx -> studentController.createStudent(ctx));
//		app.post("/createStudent", ctx -> studentController.createStudent(ctx));
//		app.post("/createStudent", ctx -> studentController.createStudent(ctx));
//		app.post("/createStudent", ctx -> studentController.createStudent(ctx));
//		app.post("/createStudent", ctx -> studentController.createStudent(ctx));
	}

}
