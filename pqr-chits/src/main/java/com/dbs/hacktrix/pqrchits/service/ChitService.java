package com.dbs.hacktrix.pqrchits.service;

import java.util.List;

import com.dbs.hacktrix.pqrchits.dto.Chit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.hacktrix.pqrchits.domain.Chits;
import com.dbs.hacktrix.pqrchits.repository.ChitsRepo;

@Service
public class ChitService {
	
	@Autowired
	private ChitsRepo chitsRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	public List<Chits> getAllChits(){
		return chitsRepo.findAll();
	}

	public void addChit(Chit chit){
	    chitsRepo.save(modelMapper.map(chit, Chits.class));
    }
}
