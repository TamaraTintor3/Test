package com.mentor.serverList.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.serverList.dao.ServerAccessDAO;
import com.mentor.serverList.dao.ServerDAO;
import com.mentor.serverList.dao.UserDAO;
import com.mentor.serverList.dto.ServerAccessDTO;
import com.mentor.serverList.model.ServerAccess;
import com.mentor.serverList.service.ServerAccessService;

@RestController
@RequestMapping("/api/access")
public class ServerAccessController {

	@Autowired
	ServerDAO serverDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ServerAccessDAO serverAccessDAO;
	
	@Autowired
	ServerAccessService service;

	@GetMapping(produces = "application/json")
	public ResponseEntity<ArrayList<ServerAccess>> getAll(HttpServletRequest request) {
		return new ResponseEntity<ArrayList<ServerAccess>>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/byServer/{name}", produces = "application/json")
	public ResponseEntity<ArrayList<ServerAccess>> getAllByServer(@PathVariable("name") String name, HttpServletRequest request) {
		return new ResponseEntity<ArrayList<ServerAccess>>(service.getAllByServer(name), HttpStatus.OK);
	}
	
	@GetMapping(value = "/byUser/{name}", produces = "application/json")
	public ResponseEntity<ArrayList<ServerAccess>> getAllByUser(@PathVariable("name") String name, HttpServletRequest request) {
		return new ResponseEntity<ArrayList<ServerAccess>>(service.getAllByUser(name), HttpStatus.OK);
	}
	
	@PostMapping(headers = { "content-type=application/json" })
	public ResponseEntity<String> save(@RequestBody  ServerAccessDTO recServAccessDTO, HttpServletRequest request) {
		String recStr = service.save(recServAccessDTO);
		if (recStr.contains("Fail")) {
			return new ResponseEntity<String>(recStr, HttpStatus.BAD_REQUEST);
		} else if (recStr.contains("Exception")) {
			return new ResponseEntity<String>(recStr, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<String>(recStr, HttpStatus.ACCEPTED);
		}
	}
}
