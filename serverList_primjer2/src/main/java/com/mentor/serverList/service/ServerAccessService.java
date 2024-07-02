package com.mentor.serverList.service;

import java.util.ArrayList;

import com.mentor.serverList.dto.ServerAccessDTO;
import com.mentor.serverList.model.ServerAccess;

public interface ServerAccessService {

	public ArrayList<ServerAccess> getAll();

	public ArrayList<ServerAccess> getAllByServer(String name);

	public ArrayList<ServerAccess> getAllByUser(String name);

	public String save(ServerAccessDTO recServAccessDTO);

}
