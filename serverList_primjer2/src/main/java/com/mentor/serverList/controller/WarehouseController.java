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
import com.mentor.serverList.model.Warehouse;
import com.mentor.serverList.service.WarehouseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/warehouse")
@Slf4j
public class WarehouseController {

	@Autowired
	ServerDAO serverDAO;
	@Autowired
	WarehouseDAO warehouseDAO;

	@Autowired
	WarehouseService service;

	@GetMapping(produces = "application/json")
	public ResponseEntity<ArrayList<Warehouse>> getAll(HttpServletRequest request) {
		return new ResponseEntity<ArrayList<Warehouse>>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{name}", produces = "application/json")
	public ResponseEntity<Warehouse> getOne(@PathVariable("name") String name, HttpServletRequest request) {
		return new ResponseEntity<Warehouse>(service.getOne(name), HttpStatus.OK);
	}

	@PostMapping(headers = { "content-type=application/json" })
	public ResponseEntity<String> save(@RequestBody Warehouse recWarehouse, HttpServletRequest request) {
		String recStr = service.save(recWarehouse);
		if (recStr.contains("Fail")) {
			return new ResponseEntity<String>(recStr, HttpStatus.BAD_REQUEST);
		} else if (recStr.contains("Exception")) {
			return new ResponseEntity<String>(recStr, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<String>(recStr, HttpStatus.ACCEPTED);
		}
	}

	/**
	 * only location can be changed!
	 * 
	 * @param recServer
	 * @param request
	 * @return
	 */
	@PutMapping(headers = { "content-type=application/json" })
	public ResponseEntity<String> edit(@RequestBody Warehouse recWarehouse, HttpServletRequest request) {
		String recStr = service.edit(recWarehouse);
		if (recStr.contains("Fail")) {
			return new ResponseEntity<String>(recStr, HttpStatus.BAD_REQUEST);
		} else if (recStr.contains("Exception")) {
			return new ResponseEntity<String>(recStr, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<String>(recStr, HttpStatus.ACCEPTED);
		}
	}

}
