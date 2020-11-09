package com.revature.coursetracker.pojo;

public class Login {
	
	private String email;
	
	private String user;
	
	private String pass;

	public Login() {
	}

	public Login(String email, String user, String pass) {
		super();
		// TODO check emails using regex: \b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}\b
		this.email = email.toUpperCase();
		this.user = user;
		this.pass = pass;
	}

}
