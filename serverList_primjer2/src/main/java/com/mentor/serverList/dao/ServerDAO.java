package com.mentor.serverList.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.mentor.serverList.model.Server;
import com.mentor.serverList.model.Warehouse;

public interface ServerDAO extends CrudRepository<Server, Long> {

	public Server findOneByName(String name);

	public ArrayList<Server> findAllByWarehouse(Warehouse warehouse);

	public ArrayList<Server> findAllByWarehouse_Name(String warehouseName);

}
