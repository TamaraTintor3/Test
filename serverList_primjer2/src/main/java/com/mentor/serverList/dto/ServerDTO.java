package com.mentor.serverList.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mentor.serverList.model.Warehouse;

public class ServerDTO {
	public String name;
	
	public int numberOfCores;
	
	public int ramMemoryInMB;
	
	public String ipAddr;
	
	public Warehouse warehouse;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfCores() {
		return numberOfCores;
	}

	public void setNumberOfCores(int numberOfCores) {
		this.numberOfCores = numberOfCores;
	}

	public int getRamMemoryInMB() {
		return ramMemoryInMB;
	}

	public void setRamMemoryInMB(int ramMemoryInMB) {
		this.ramMemoryInMB = ramMemoryInMB;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public ServerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServerDTO(String name, int numberOfCores, int ramMemoryInMB, String ipAddr, Warehouse warehouse) {
		super();
		this.name = name;
		this.numberOfCores = numberOfCores;
		this.ramMemoryInMB = ramMemoryInMB;
		this.ipAddr = ipAddr;
		this.warehouse = warehouse;
	}
	
	
	
}
