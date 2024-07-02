package com.mentor.serverList.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.serverList.dao.ServerAccessDAO;
import com.mentor.serverList.dao.ServerDAO;
import com.mentor.serverList.dao.UserDAO;
import com.mentor.serverList.dto.ServerAccessDTO;
import com.mentor.serverList.model.Server;
import com.mentor.serverList.model.ServerAccess;
import com.mentor.serverList.model.User;
import com.mentor.serverList.service.ServerAccessService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ServerAccessServiceImpl implements ServerAccessService {

	@Autowired
	ServerDAO serverDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	ServerAccessDAO serverAccessDAO;

	@Override
	public ArrayList<ServerAccess> getAll() {
		return (ArrayList<ServerAccess>) serverAccessDAO.findAll();
	}

	@Override
	public ArrayList<ServerAccess> getAllByServer(String name) {
		return (ArrayList<ServerAccess>) serverAccessDAO.findAllByServer_Name(name);
	}

	@Override
	public ArrayList<ServerAccess> getAllByUser(String name) {
		return (ArrayList<ServerAccess>) serverAccessDAO.findAllByUser_Name(name);
	}

	@Override
	public String save(ServerAccessDTO recServAccessDTO) {
		if (recServAccessDTO.getUserName() == null || recServAccessDTO.getUserName().equals("")
				|| recServAccessDTO.getServerName() == null || recServAccessDTO.getServerName().equals("")) {
			return "Fail, data missing";
		}
		ArrayList<ServerAccess> listOfSA = serverAccessDAO
				.findAllByServer_NameAndUser_Name(recServAccessDTO.getServerName(), recServAccessDTO.getUserName());
		if (listOfSA.isEmpty() == false) {
			return "Fail, user already got access to the server!";
		}

		User user = userDAO.findOneByName(recServAccessDTO.getUserName());
		Server server = serverDAO.findOneByName(recServAccessDTO.getServerName());
		if (user == null || server == null) {
			return "Fail, Server name or User name not correct!";
		}
		ServerAccess sa = new ServerAccess(user, server);

		try {
			serverAccessDAO.save(sa);
		} catch (IllegalArgumentException ex1) {
			log.error("[Access Controller exception in POST: ]", ex1);
			return "Exception in Access Controller POST (ex1), contact admins!";
		} catch (Exception ex2) {
			log.error("[Access Controller exception in POST: ]", ex2);
			return "Exception in Access Controller POST (ex2), contact admins!";
		}
		return "OK, Access saved!";
	}

}
