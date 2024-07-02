package com.mentor.serverList.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.serverList.dao.WarehouseDAO;
import com.mentor.serverList.model.Warehouse;
import com.mentor.serverList.service.WarehouseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	WarehouseDAO warehouseDAO;

	@Override
	public ArrayList<Warehouse> getAll() {
		return (ArrayList<Warehouse>) warehouseDAO.findAll();
	}

	@Override
	public Warehouse getOne(String name) {
		return warehouseDAO.findOneByName(name);
	}

	@Override
	public String save(Warehouse recObj) {
		/*
		 * if (recObj.getName() == null || recObj.getName().equals("") ||
		 * recObj.getLocation() == null || recObj.getLocation().equals("")) { return
		 * "Fail, data missing!"; } Warehouse warehouse =
		 * warehouseDAO.findOneByName(recObj.getName()); if (warehouse != null) { return
		 * "Fail, warehouse with provided name already exists but name must be unique!";
		 * }
		 * 
		 * warehouse = new Warehouse(recObj.getName(), recObj.getLocation());
		 * 
		 * try { warehouseDAO.save(warehouse); } catch (IllegalArgumentException ex1) {
		 * log.error("[Warehouse Controller exception in POST: ]", ex1); return
		 * "Exception in Warehouse Controller POST (ex1), contact admins!"; } catch
		 * (Exception ex2) { log.error("[Warehouse Controller exception in POST: ]",
		 * ex2); return "Exception in Warehouse Controller POST (ex2), contact admins!";
		 * }
		 */
		return "OK, Warehouse saved!";
	}

	@Override
	public String edit(Warehouse recObj) {
		if (recObj.getName() == null || recObj.getName().equals("") || recObj.getLocation() == null
				|| recObj.getLocation().equals("")) {
			return "Fail, data missing";
		}
		Warehouse warehouse = warehouseDAO.findOneByName(recObj.getName());
		if (warehouse == null) {
			return "Fail, warehouse with provided name not found!";
		}
		warehouse.setLocation(recObj.getLocation());

		try {
			warehouseDAO.save(warehouse);
		} catch (IllegalArgumentException ex1) {
			log.error("[Warehouse Controller exception in PUT: ]", ex1);
			return "Exception in Warehouse Controller PUT (ex1), contact admins!";
		} catch (Exception ex2) {
			log.error("[Warehouse Controller exception in PUT: ]", ex2);
			return "Exception in Warehouse Controller PUT (ex2), contact admins!";
		}

		return "Warehouse edited!";
	}

}
