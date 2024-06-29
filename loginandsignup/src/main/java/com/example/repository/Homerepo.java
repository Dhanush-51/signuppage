package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Details;

public interface Homerepo extends JpaRepository<Details,String>{


	Details findByemailAndPassword(String email, String password);
	
}
