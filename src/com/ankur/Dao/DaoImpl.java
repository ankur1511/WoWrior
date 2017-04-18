package com.ankur.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoImpl extends DBAccess {

	public void insertQuery(String sqlQuery) {

		DBAccess db = new DBAccess();
		try {
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
	}

	public ResultSet getResultSet(String query) {

		DBAccess db = new DBAccess();
		ResultSet rs = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return rs;
	}

}
