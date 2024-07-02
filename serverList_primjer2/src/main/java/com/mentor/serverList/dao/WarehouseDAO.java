package com.mentor.serverList.dao;

import org.springframework.data.repository.CrudRepository;

import com.mentor.serverList.model.Warehouse;

public interface WarehouseDAO extends CrudRepository<Warehouse, Long> {

	public Warehouse findOneByName(String name);

	public Warehouse findOneByLocation(String location);
}
