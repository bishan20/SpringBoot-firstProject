package com.example.FirstProject.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.FirstProject.contollers.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	@Query("select u from User u where u.name=:name") //this is to use custom query
	public User findByName(@Param("name") String name);
}