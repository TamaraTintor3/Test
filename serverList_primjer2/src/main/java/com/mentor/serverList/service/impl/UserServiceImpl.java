package com.mentor.serverList.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.serverList.dao.UserDAO;
import com.mentor.serverList.model.User;
import com.mentor.serverList.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public ArrayList<User> getAll() {
		return (ArrayList<User>) userDAO.findAll();
	}

	@Override
	public User getOne(String name) {
		return userDAO.findOneByName(name);
	}

	// @formatter:off



	@Override
	public String save(User recObj) {
		if (recObj.getName() == null || recObj.getName().equals("") || recObj.getPassword() == null
				|| recObj.getPassword().equals("")) {
			return "Fail, data missing";
		}
		User user = userDAO.findOneByName(recObj.getName());
		if (user != null) {
			return "Fail, user with provided name already exists but name must be unique!";
		}

		user = new User(recObj.getName(), recObj.getPassword(), true);

		try {
			userDAO.save(user);
		} catch (IllegalArgumentException ex1) {
			log.error("[User Controller exception in POST: ]", ex1);
			return "Exception in User Controller POST (ex1), contact admins!";
		} catch (Exception ex2) {
			log.error("[User Controller exception in POST: ]", ex2);
			return "Exception in User Controller POST (ex2), contact admins!";
		}
		return "OK, user saved!";
	}

	// @formatter:on

	@Override
	public String edit(User recObj) {
		if (recObj.getName() == null || recObj.getName().equals("") || recObj.getPassword() == null
				|| recObj.getPassword().equals("")) {
			return "Fail, data missing!";
		}
		User user = userDAO.findOneByName(recObj.getName());
		if (user == null) {
			return "Fail, user with provided name not found!";
		}
		user.setPassword(recObj.getPassword());

		try {
			userDAO.save(user);
		} catch (IllegalArgumentException ex1) {
			log.error("[User Controller exception in PUT: ]", ex1);
			return "Exception in User Controller PUT (ex1), contact admins!";
		} catch (Exception ex2) {
			log.error("[User Controller exception in PUT: ]", ex2);
			return "Exception in User Controller PUT (ex2), contact admins!";
		}
		return "OK, User edited!";
	}

	@Override
	public String flagNotActive(String name) {
		User user = userDAO.findOneByName(name);
		if (name == null || name.equals("")) {
			return "Fail, data missing!";
		}
		if (user == null) {
			return "Fail, user with provided name not found!";
		}
		user.setActive(false);

		try {
			userDAO.save(user);
		} catch (IllegalArgumentException ex1) {
			log.error("[User Controller exception in DELETE: ]", ex1);
			return "Exception in User Controller DELETE (ex1), contact admins!";
		} catch (Exception ex2) {
			log.error("[User Controller exception in DELETE: ]", ex2);
			return "Exception in User Controller DELETE (ex2), contact admins!";
		}

		return "OK, User deleted!";
	}

}
