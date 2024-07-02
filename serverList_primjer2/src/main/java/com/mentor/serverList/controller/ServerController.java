package com.mentor.serverList.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.serverList.dao.ServerDAO;
import com.mentor.serverList.dao.WarehouseDAO;
import com.mentor.serverList.model.Server;
import com.mentor.serverList.service.ServerService;

@RestController
@RequestMapping("/api/server")
public class ServerController {

	@Autowired
	ServerDAO serverDAO;
	@Autowired
	WarehouseDAO warehouseDAO;
	
	@Autowired
	ServerService service;

	@GetMapping(produces = "application/json")
	public ResponseEntity<ArrayList<Server>> getAll(HttpServletRequest request) {
		return new ResponseEntity<ArrayList<Server>>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{name}", produces = "application/json")
	public ResponseEntity<Server> getOne(@PathVariable("name") String name, HttpServletRequest request) {
		return new ResponseEntity<Server>(service.getOne(name), HttpStatus.OK);
	}

	@PostMapping(headers = { "content-type=application/json" })
	public ResponseEntity<String> save(@RequestBody Server recServer, HttpServletRequest request) {
		
		
		String recStr = service.save(recServer);
		if (recStr.contains("Fail")) {
			return new ResponseEntity<String>(recStr, HttpStatus.BAD_REQUEST);
		} else if (recStr.contains("Exception")) {
			return new ResponseEntity<String>(recStr, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<String>(recStr, HttpStatus.ACCEPTED);
		}
	}

	/**
	 * Server name and id can not be changed!
	 * 
	 * @param recServer
	 * @param request
	 * @return
	 */
	@PutMapping(headers = { "content-type=application/json" })
	public ResponseEntity<String> edit(@RequestBody Server recServer, HttpServletRequest request) {
		
		
		String recStr = service.edit(recServer);
		if (recStr.contains("Fail")) {
			return new ResponseEntity<String>(recStr, HttpStatus.BAD_REQUEST);
		} else if (recStr.contains("Exception")) {
			return new ResponseEntity<String>(recStr, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<String>(recStr, HttpStatus.ACCEPTED);
		}
	}

}
