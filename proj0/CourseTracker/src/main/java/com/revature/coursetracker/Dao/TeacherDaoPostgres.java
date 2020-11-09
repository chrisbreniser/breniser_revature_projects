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
			
			log.info("TeacherDaoPostgres.createTeacher[In try block: Attempting to execute:\n" + preparedStatement + "]"); 
			
			int rowsAffected = preparedStatement.executeUpdate();
			conn.commit();
			log.info("TeacherDaoPostgres.createTeacher[In try block: Effected: " + rowsAffected + " line(s)]"); 
		} catch (SQLException e) {
			log.error("TeacherDaoPostgres.createTeacher[In catch block: SQLException: " + e.getMessage() + "]");
		}
	}

	@Override
	public Teacher getTeacherById(int teacherId) {
		log.info("TeacherDaoPostgres.getTeacherById[Received " + teacherId + " in Dao. Creating select Statement]");
		
		Teacher teacher = null;
		
		String sql = "select teacherid, firstname, lastname, user, email  from teacher where teacherid = ?;";
		
		try (Connection conn = connUtil.createConnection()) {
			preparedStatement = conn.prepareStatement(sql);
			
			log.info("TeacherDaoPostgres.getTeacherById[Got passed the prepared statement instantiation: " + preparedStatement + "]");
			
			preparedStatement.setInt(1, teacherId);
			
			log.info("TeacherDaoPostgres.getTeacherById[In try block: Attempting to execute:\n" + preparedStatement + "]"); 
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				teacher = new Teacher(rs.getString("firstname"), rs.getString("lastname"), rs.getString("user"), "", rs.getString("email"));
				
			}
			
			log.info("TeacherDaoPostgres.getTeacherById[In try block: Result of query as a teacher object:" + teacher.toString());
			
		} catch (SQLException e) {
			log.error("TeacherDaoPostgres.getTeacherById[In catch block: SQLException: " + e.getMessage() + "]");
		}
		
		return teacher;

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
