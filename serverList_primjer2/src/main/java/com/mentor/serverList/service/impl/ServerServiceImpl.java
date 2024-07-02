package com.mentor.serverList.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.serverList.dao.ServerDAO;
import com.mentor.serverList.dao.WarehouseDAO;
import com.mentor.serverList.model.Server;
import com.mentor.serverList.model.Warehouse;
import com.mentor.serverList.service.ServerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServerServiceImpl implements ServerService {

	@Autowired
	ServerDAO serverDAO;

	@Autowired
	WarehouseDAO warehouseDAO;

	@Override
	public ArrayList<Server> getAll() {
		return (ArrayList<Server>) serverDAO.findAll();
	}

	@Override
	public Server getOne(String name) {
		return serverDAO.findOneByName(name);
	}

	@Override
	public String save(Server recObj) {
		if (recObj.getIpAddr() == null || recObj.getIpAddr().equals("") || recObj.getName() == null
				|| recObj.getName().equals("") || recObj.getWarehouse() == null
				|| recObj.getWarehouse().getName() == null || recObj.getWarehouse().getName().equals("")) {
			return "Fail, data missing";
		}
		Warehouse warehouse = warehouseDAO.findOneByName(recObj.getWarehouse().getName());
		if (warehouse == null) {
			return "Fail, warehouse with provided name not found!";
		}

		Server server = serverDAO.findOneByName(recObj.getName());
		if (server != null) {
			return "Fail, Server name already exists and it has to be unique!";
		}
		server = new Server(recObj.getName(), recObj.getNumberOfCores(), recObj.getRamMemoryInMB(), recObj.getIpAddr(),
				warehouse);

		try {
			serverDAO.save(server);
		} catch (IllegalArgumentException ex1) {
			log.error("[Server Controller exception in POST: ]", ex1);
			return "Exception in Server Controller POST (ex1), contact admins!";
		} catch (Exception ex2) {
			log.error("[Server Controller exception in POST: ]", ex2);
			return "Exception in Server Controller POST (ex2), contact admins!";
		}

		return "OK, Server saved!";
	}

	@Override
	public String edit(Server recObj) {
		if (recObj.getIpAddr() == null || recObj.getIpAddr().equals("") || recObj.getName() == null
				|| recObj.getName().equals("") || recObj.getWarehouse() == null
				|| recObj.getWarehouse().getName() == null || recObj.getWarehouse().getName().equals("")) {
			return "Fail, data missing";
		}
		Warehouse warehouse = warehouseDAO.findOneByName(recObj.getWarehouse().getName());
		if (warehouse == null) {
			return "Fail, warehouse with provided name not found!";
		}

		Server server = serverDAO.findOneByName(recObj.getName());
		if (server == null) {
			return "Fail, Server with this name could not be found!";
		}
		server.setIpAddr(recObj.getIpAddr());
		server.setNumberOfCores(recObj.getNumberOfCores());
		server.setRamMemoryInMB(recObj.getRamMemoryInMB());
		server.setWarehouse(warehouse);

		try {
			serverDAO.save(server);
		} catch (IllegalArgumentException ex1) {
			log.error("[Server Controller exception in PUT: ]", ex1);
			return "Exception in Server Controller PUT (ex1), contact admins!";
		} catch (Exception ex2) {
			log.error("[Server Controller exception in PUT: ]", ex2);
			return "Exception in Server Controller PUT (ex2), contact admins!";
		}
		return "Server edited!";
	}

}
