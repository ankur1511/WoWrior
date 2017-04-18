package com.ankur.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccess {

	String databaseUrl;
	String mySqlhost;
	String mySqlPort;
	String mySqlDB;
	String mySQLDBUser;
	String mySQLDBPwd;
	public Connection connection;
	public DBAccess instance;

	private void setUpConnection() throws Exception {
		databaseUrl = "jdbc:mysql://" + mySqlhost + ":" + mySqlPort + '/' + mySqlDB;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(databaseUrl, mySQLDBUser, mySQLDBPwd);
		connection.setAutoCommit(true);
	}

	public DBAccess() {

		try {

			mySqlhost = "HostAddress";
			mySqlPort = "3306";
			mySqlDB = "TestDB";
			mySQLDBUser = "DBUsername";
			mySQLDBPwd = "DBpassword";

			setUpConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBAccess getInstance() {
		DBAccess instance = new DBAccess();
		return instance;
	}

}
