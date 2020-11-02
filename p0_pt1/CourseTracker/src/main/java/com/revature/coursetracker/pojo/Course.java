package com.revature.coursetracker.pojo;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Course {
	
	private UUID id;
	
	private String courseName;
	
	private Teacher teacher;
	
	private Set<Student> students = new HashSet<Student>();
	
	private Set<Assignment> assignments = new HashSet<Assignment>();
		
	public Course() {
		super();
	}

	public Course(String courseName, Teacher teacher) {
		this();
		this.courseName = courseName;
		this.teacher = teacher;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public UUID getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignments == null) ? 0 : assignments.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (assignments == null) {
			if (other.assignments != null)
				return false;
		} else if (!assignments.equals(other.assignments))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}
	
	/*
	 * Adds student to students set
	 * @param student
	 * @return boolean	
	 */
	public boolean addStudent(Student student) {
		if(students.add(student))
			return true;
		return false;
	}
	
	/*
	 * Adds assignment to assignment set
	 * @param assignment
	 * @return boolean	
	 */
	public boolean addAssignment(Assignment assignment) {
		if(assignments.add(assignment))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", teacher=" + teacher + ", students=" + students
				+ ", assignments=" + assignments + "]";
	}
	
	

}
