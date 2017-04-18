package com.ankur.Service;

import java.sql.SQLException;

import com.ankur.Entity.User;

public interface UserService {
	
	public void CreateUser(User user, int PlaceId);
	public boolean CheckAddress(String[] address) throws SQLException, Exception;
	public int getPlaceID() throws Exception;
	public void storeAddress(String[] address);
	
}
