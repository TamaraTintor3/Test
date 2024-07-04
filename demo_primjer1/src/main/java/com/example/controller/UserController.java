package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDTO;
import com.example.exception.ResourceNotFoundException;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(path = "/CSRData", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> saveRequestForCA(@RequestBody UserDTO user)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(userService.saveRequest(user));

	}

}
