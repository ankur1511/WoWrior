package com.ankur.Service;

import java.sql.ResultSet;

import com.ankur.Dao.DaoImpl;
import com.ankur.Entity.User;

public class UserServiceImpl implements UserService {

	DaoImpl dao = new DaoImpl();

	@Override
	public void CreateUser(User user, int PlaceID) {

		String query;
		query = "insert into User values('" + user.getName() + "','" + user.getAge() + "','" + user.getGender() + "','"
				+ PlaceID + "');";
		dao.insertQuery(query);

	}

	@Override
	public boolean CheckAddress(String[] address) throws Exception {

		ResultSet result;
		String query;
		query = "select * from Location where locality='" + address[0] + "' " + "AND " + "city='" + address[1] + "' "
				+ "AND " + "state='" + address[2] + "' " + "AND " + "country='" + address[3] + "';";

		result = dao.getResultSet(query);
		boolean addresspresent = false;
		while (result.next()) {

			addresspresent = true;
		}
		return addresspresent;
	}

	@Override
	public void storeAddress(String[] address) {

		String query;
		query = "insert into Location values('" + address[0] + "','" + address[1] + "','" + address[2] + "','"
				+ address[3] + "');";
		dao.insertQuery(query);

	}

	@Override
	public int getPlaceID() throws Exception {

		ResultSet result;
		String query;
		query = "select PlaceID from User limit 1;";
		result = dao.getResultSet(query);
		return result.getInt("PlaceID");
	}
}
