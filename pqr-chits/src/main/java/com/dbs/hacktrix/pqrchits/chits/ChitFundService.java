package com.dbs.hacktrix.pqrchits.chits;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ChitFundService {
	
	//Register User for a particular  
	@PostMapping("/user/chits/register")
	public ResponseEntity<Void> registerUserToChitFund(
			@PathVariable String username, @RequestBody ChitUser chitUser){
		
		//Todo createdTodo = todoService.save(todo);
		
		//Todo createdTodo = todoJpaRepository.save(todo);
		
		//Location
		//Get current resource url
		///{id}
		/*URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();*/
		URI uri = null;
		return ResponseEntity.created(uri).build();
	} 
	
}
