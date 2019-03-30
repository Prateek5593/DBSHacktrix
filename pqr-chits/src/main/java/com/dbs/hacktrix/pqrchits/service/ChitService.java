package com.dbs.hacktrix.pqrchits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.hacktrix.pqrchits.domain.Chits;
import com.dbs.hacktrix.pqrchits.repository.ChitsRepo;

@Service
public class ChitService {
	
	@Autowired
	private ChitsRepo chitsRepo;
	
	public List<Chits> getAllChits(){
		return chitsRepo.findAll();
	}
}
