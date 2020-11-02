package com.revature.coursetracker.pojo;
import java.util.UUID;

public class Student {
	
	
	private UUID id;
	
	private String firstName;
	
	private String lastName;
	
	private double gpa;

	public Student() {
		super();
		this.id = UUID.randomUUID();
	}

	public Student(String firstName, String lastName, double gpa) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
	}

	public UUID getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(long gpa) {
		this.gpa = gpa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Student other = (Student) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gpa=" + gpa + "]";
	}
	
	

}
	