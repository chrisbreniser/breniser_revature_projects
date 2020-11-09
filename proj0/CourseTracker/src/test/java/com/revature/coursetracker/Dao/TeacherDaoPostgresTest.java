package com.revature.coursetracker.Dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.coursetracker.util.ConnectionUtil;
import com.revature.coursetracker.pojo.Teacher;

@RunWith(MockitoJUnitRunner.class)
public class TeacherDaoPostgresTest {
	
	public TeacherDaoPostgres teacherDao = new TeacherDaoPostgres();
	
	@Mock
	private ConnectionUtil connUtil;
	
	@Mock
	private Connection connection;
	
	private PreparedStatement prepStmt;
	
	private PreparedStatement spy;
	
	private Connection realConnection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		realConnection = new ConnectionUtil().createConnection();
		
		//creating a real perpared stmt from a connection
		prepStmt = realConnection.prepareStatement("");
		
		//spying on that real stmt
		spy = Mockito.spy(prepStmt);
		
		//mock our connection and util, so we will only use the prepStmt we are spying on
		when(connection.prepareStatement(any(String.class))).thenReturn(spy);
		when(connUtil.createConnection()).thenReturn(connection);
		
		//set up Dao to use the mocked object
		teacherDao.setConnUtil(connUtil);
		
	}

	@After
	public void tearDown() throws Exception {
		
		prepStmt.executeUpdate("delete from teacher where firstname = 'chris' and lastname = 'breniser'");
		
		realConnection.close();
		
	}

	@Test
	public void createTeacherTest() throws SQLException{
		
		// create teacher to use in test
		Teacher teacher = new Teacher("chris", "breniser", "brenisec", "hunter2", "brenisec@hotmail.io");
		
		// call dao to create teacher
		teacherDao.createTeacher(teacher);
		
		// setup query string to compare against
		String sql = "insert into teacher (firstname, lastname, \"user\", pass, email) "
				+ "values ('chris', 'breniser', 'brenisec', 'hunter2', 'brenisec@hotmail.io');";
		
		// verify that Dao ran update equal to out sql query string
		verify(spy).executeUpdate(sql);
		
		// check that the teacher was added by selecting it
		ResultSet rs = prepStmt.executeQuery("select * from teachers where firstname = 'chris' and lastname = 'breniser';");
		
		// check that the result set has content in it by moving curser forward once. Would return false if empty.
		assertTrue(rs.next());
	}

}
