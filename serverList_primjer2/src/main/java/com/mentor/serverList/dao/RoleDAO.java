package com.mentor.serverList.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mentor.serverList.model.Role;

public interface RoleDAO extends CrudRepository<Role, Long> {

	@Query("")
	public Role findByRole(String role);

}
