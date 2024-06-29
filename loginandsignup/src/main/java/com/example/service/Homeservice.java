package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Details;
import com.example.repository.Homerepo;

@Service
public class Homeservice {
	@Autowired
	Homerepo rep;
	public Details getdet(String email,String password)
	{
		Details det=rep.findByemailAndPassword(email,password);
		return det;
	}

}
