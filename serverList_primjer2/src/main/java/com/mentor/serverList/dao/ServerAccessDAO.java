package com.mentor.serverList.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.mentor.serverList.model.Server;
import com.mentor.serverList.model.ServerAccess;
import com.mentor.serverList.model.User;

public interface ServerAccessDAO extends CrudRepository<ServerAccess, Long> {

	public ArrayList<ServerAccess> findAllByUser(User user);
	public ArrayList<ServerAccess> findAllByUser_Name(String name);

	public ArrayList<ServerAccess> findAllByServer(Server server);
	public ArrayList<ServerAccess> findAllByServer_Name(String name);
	
	public ArrayList<ServerAccess> findAllByServer_NameAndUser_Name(String serverName, String userName);

}
