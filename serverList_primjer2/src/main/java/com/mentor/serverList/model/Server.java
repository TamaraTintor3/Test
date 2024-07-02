package com.mentor.serverList.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Server {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique=true)
	private String name;
	
	@Column(nullable = false)
	private int numberOfCores;
	
	@Column(nullable = false)
	private int ramMemoryInMB;
	
	@Column(nullable = false)
	private String ipAddr;
	
	@ManyToOne
	@JoinColumn(name="warehouse", referencedColumnName="id", nullable=false)
	private Warehouse warehouse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Server(String name, int numberOfCores, int ramMemoryInMB, String ipAddr, Warehouse warehouse) {
		super();
		this.name = name;
		this.numberOfCores = numberOfCores;
		this.ramMemoryInMB = ramMemoryInMB;
		this.ipAddr = ipAddr;
		this.warehouse = warehouse;
	}
	
	
}
