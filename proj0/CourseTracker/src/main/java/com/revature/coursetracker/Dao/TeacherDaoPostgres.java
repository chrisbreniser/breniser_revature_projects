package com.revature.coursetracker.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.revature.coursetracker.pojo.Teacher;
import com.revature.coursetracker.util.ConnectionUtil;

public class TeacherDaoPostgres implements TeacherDao {
	
	private static Logger log = Logger.getRootLogger();
	
	private PreparedStatement preparedStatement;
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public void createTeacher(Teacher teacher) {

		log.info("TeacherDaoPostgres.CreateTeacher\n[Received " + teacher.toString() + " in Dao. Creating insert Statement]");
		
		String sql = 
				"insert into teacher (firstname, lastname, \"user\", pass, email) "
				+ "values (?, ?, ?, ?, ?);";
		
		try (Connection conn = connUtil.createConnection()) {
			conn.setAutoCommit(false);
			preparedStatement = conn.prepareStatement(sql);
			
			log.info("Got passed the prepared statement instatiation: " + preparedStatement);
			
			preparedStatement.setString(1, teacher.getFirstName());
			preparedStatement.setString(2, teacher.getLastName());
			preparedStatement.setString(3, teacher.getUser());
			preparedStatement.setString(4, teacher.getPass());
			preparedStatement.setString(5, teacher.getEmail());
			
			log.info("TeacherDaoPostgres.createTeacher try block[Attempting to execute:\n" + preparedStatement + "]"); 
			
			int rowsAffected = preparedStatement.executeUpdate();
			conn.commit();
			log.info("TeacherDaoPostgres.createTeacher try block[Effected: " + rowsAffected + " line(s)]"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("TeacherDaoPostgres.createTeacher catch block[SQLException: " + e.getMessage() + "]");
		}
	}

	@Override
	public void readTeacher(int teacherId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readAllTeachers() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTeacher(int teacherId, Teacher teacher) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTeacher(int teacherid) {
		// TODO Auto-generated method stub

	}

}
