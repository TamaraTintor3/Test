package com.mentor.serverList.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.serverList.dao.UserDAO;
import com.mentor.serverList.model.User;
import com.mentor.serverList.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserService userService;

	@GetMapping(produces = "application/json")
	public ResponseEntity<ArrayList<User>> getAll(HttpServletRequest request) {
		return new ResponseEntity<ArrayList<User>>(userService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{name}", produces = "application/json")
	public ResponseEntity<User> getOne(@PathVariable("name") String name, HttpServletRequest request) {
		return new ResponseEntity<User>(userService.getOne(name), HttpStatus.OK);
	}

	@PostMapping(headers = { "content-type=application/json" })
	public ResponseEntity<String> save(@RequestBody User recUser, HttpServletRequest request) {
		String recStr = userService.save(recUser);
		if (recStr.contains("Fail")) {
			return new ResponseEntity<String>(recStr, HttpStatus.BAD_REQUEST);
		} else if (recStr.contains("Exception")) {
			return new ResponseEntity<String>(recStr, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<String>(recStr, HttpStatus.ACCEPTED);
		}
	}

	/**
	 * only password can be changed!
	 *
	 * @param recServer
	 * @param request
	 * @return
	 */
	@PutMapping(headers = { "content-type=application/json" })
	public ResponseEntity<String> edit(@RequestBody User recUser, HttpServletRequest request) {
		String recStr = userService.edit(recUser);
		if (recStr.contains("Fail")) {
			return new ResponseEntity<String>(recStr, HttpStatus.BAD_REQUEST);
		} else if (recStr.contains("Exception")) {
			return new ResponseEntity<String>(recStr, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<String>(recStr, HttpStatus.ACCEPTED);
		}
	}

	@DeleteMapping(value = "/{name}", headers = { "content-type=application/json" })
	public ResponseEntity<String> flagNotActive(@PathVariable("name") String name, HttpServletRequest request) {
		String recStr = userService.flagNotActive(name);
		if (recStr.contains("Fail")) {
			return new ResponseEntity<String>(recStr, HttpStatus.BAD_REQUEST);
		} else if (recStr.contains("Exception")) {
			return new ResponseEntity<String>(recStr, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<String>(recStr, HttpStatus.ACCEPTED);
		}
	}

}
