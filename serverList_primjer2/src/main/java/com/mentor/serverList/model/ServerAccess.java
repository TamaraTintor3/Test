package com.mentor.serverList.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServerAccess {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="user", referencedColumnName="id", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="server", referencedColumnName="id", nullable=false)
	private Server server;

	public ServerAccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public ServerAccess(User user, Server server) {
		super();
		this.user = user;
		this.server = server;
	}
	
	
	
}
