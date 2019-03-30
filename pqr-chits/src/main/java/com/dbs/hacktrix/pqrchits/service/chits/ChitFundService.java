package com.dbs.hacktrix.pqrchits.service.chits;

import java.net.URI;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dbs.hacktrix.pqrchits.domain.ChitsUserMapping;
import com.dbs.hacktrix.pqrchits.repository.ChitsUsersRepo;

@RestController
public class ChitFundService {
	
	@Autowired
	private ChitsUsersRepo chitUsersRepo;
	
	//Register User for a particular  
	@PostMapping("/api/user/chits/register")
	public void registerUserToChitFund(@RequestBody ChitUser chitUser){
		
		ChitsUserMapping chitUserMapping = new ChitsUserMapping();
		chitUserMapping.setChitId(chitUser.getChitId());
		chitUserMapping.setUserId(chitUser.getUserId());
		chitUserMapping.setStatus("live");
		chitUsersRepo.save(chitUserMapping);
		
	} 
	
}
