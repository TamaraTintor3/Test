package com.mentor.serverList.controller;

import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.serverList.dao.RoleDAO;
import com.mentor.serverList.dao.UserDAO;
import com.mentor.serverList.model.Role;
import com.mentor.serverList.model.User;
import com.mentor.serverList.service.UserService;

@RestController
@RequestMapping(value = "/auth")
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	UserDAO userDAO;

	@Autowired
	RoleDAO roleDAO;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping(value = "/login")
	public ResponseEntity<String> userLogIn(@RequestBody User reqUser, HttpServletRequest request) {
		System.out.println("Uslo vuj");
		if (reqUser == null || reqUser.getEmail() == null || reqUser.getEmail().trim().equals("")
				|| reqUser.getPassword() == null || reqUser.getPassword().trim().equals("")) {
			return new ResponseEntity<String>("Fail, Login Data incomplete", HttpStatus.BAD_REQUEST);
		}
		/*
		 * User user = userDAO.findOneByNameAndPassword(reqUser.getName(),
		 * reqUser.getPassword());
		 *
		 * if (user == null) { return new
		 * ResponseEntity<String>("Fail, Found no user with provided data",
		 * HttpStatus.BAD_REQUEST); }
		 */

		// ovde bi po pravilu trebalo iskoristiti: // request.login(username,password);
		// request.getSession().setAttribute("user", user);

		try {
			request.login(reqUser.getEmail(), reqUser.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Already logged!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

	@PostMapping(value = "/register")
	public ResponseEntity<String> userRegister(@RequestBody User reqUser, HttpServletRequest request) {
		if (reqUser == null || reqUser.getEmail() == null || reqUser.getPassword() == null
				|| reqUser.getName() == null) {
			return new ResponseEntity<String>("Fail, Registration Data incomplete", HttpStatus.BAD_REQUEST);
		}
		User user = new User();
		user.setPassword(bCryptPasswordEncoder.encode(reqUser.getPassword()));
		user.setName(reqUser.getName());
		user.setEmail(reqUser.getEmail());
		user.setActive(true);
		Role userRole = roleDAO.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		try {
			userDAO.save(user);
		} catch (Exception e) {
			return new ResponseEntity<String>("User could not be saved!", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("OK", HttpStatus.OK);

	}

}
