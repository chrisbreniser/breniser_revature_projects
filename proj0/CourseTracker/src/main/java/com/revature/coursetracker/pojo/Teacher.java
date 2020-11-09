package com.revature.coursetracker.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Teacher {

	private String firstName;
	
	private String lastName;
	
	private String prefixName;
	
	private List<Course> courses = new ArrayList<Course>();
	
	private Login login = new Login();

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
