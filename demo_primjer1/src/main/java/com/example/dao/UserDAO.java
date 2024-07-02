package com.example.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	public Optional<User> findOneByUsername(String username);

}
