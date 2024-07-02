package com.mentor.serverList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@Column(nullable=false)
	private String location;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Warehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Warehouse(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	
	
}
