package com.revature.coursetracker.main;

import io.javalin.Javalin;

public class ServerDriver {

	public static void main(String[] args) {
		Javalin app = Javalin.create().start(9090); // sets up and starts out server
		app.get("/hello", ctx -> ctx.html("Hello World"));
		app.get("/hello2", ctx -> ctx.result("Go Beaves"));
//		app.post("/createStudent", ctx -> class.method(thing));
	}

}
