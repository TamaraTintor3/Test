package com.mentor.serverList.service;


import com.mentor.serverList.model.User;

public interface UserService extends GenericServiceInterface<User>{

	public String flagNotActive(String name);
	
}
