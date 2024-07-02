package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDAO;
import com.example.dto.UserDTO;
import com.example.model.User;
import com.example.service.impl.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public String saveRequest(UserDTO userDTO)  {
		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setCityOrLocation(userDTO.getCityOrLocation());
		user.setCountryCode(userDTO.getCountryCode());
		user.setOrganization(userDTO.getOrganization());
		user.setStateOrProvince(userDTO.getStateOrProvince());
		user.setOrganizationUnit(userDTO.getOrganizationUnit());
		userDAO.save(user);

		return "uspjelo" + user.getUsername();
	}

}
