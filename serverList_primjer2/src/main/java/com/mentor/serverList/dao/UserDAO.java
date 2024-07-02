package com.mentor.serverList.dao;

import org.springframework.data.repository.CrudRepository;

import com.mentor.serverList.model.User;

public interface UserDAO extends CrudRepository<User, Long> {

	public User findOneByNameAndPassword(String name, String password);

	public User findOneByName(String name);

}
