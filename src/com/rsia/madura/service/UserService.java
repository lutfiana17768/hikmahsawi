package com.rsia.madura.service;

import java.util.List;

import com.rsia.madura.entity.s_User;

public interface UserService {
	public List<s_User> getUsers();
	public s_User getUser(int userId);
	
	public int store(s_User userModel);
	public int update(s_User userModel);
	public int delete(s_User userModel);
}
