package com.mentor.serverList.dto;

public class ServerAccessDTO {

	
	public String userName;
	
	public String serverName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public ServerAccessDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServerAccessDTO(String userName, String serverName) {
		super();
		this.userName = userName;
		this.serverName = serverName;
	}
	
	
	
}
