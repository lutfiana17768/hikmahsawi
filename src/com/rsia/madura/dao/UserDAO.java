package com.rsia.madura.dao;

import java.util.List;

import com.rsia.madura.entity.s_User;

public interface UserDAO {
	public List<s_User> getUsers();
	public s_User getUser(int userId);
	
	public int userStore(s_User userModel);
	public int userUpdate(s_User userModel);
	public int userDelete(s_User userModel);
}
