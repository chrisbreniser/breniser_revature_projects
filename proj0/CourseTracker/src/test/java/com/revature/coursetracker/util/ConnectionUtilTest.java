package com.revature.coursetracker.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionUtilTest {
	
	private ConnectionUtil connectionUtil = new ConnectionUtil();

	@Test
	public void createConnectionTest() throws SQLException {
		Connection conn = connectionUtil.createConnection();
		conn.close();
	}

}
