package com.dbs.hacktrix.pqrchits.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hacktrix.pqrchits.domain.Chits;
import com.dbs.hacktrix.pqrchits.service.ChitService;
import com.dbs.hacktrix.pqrchits.util.Response;

@RestController
@RequestMapping("/api/v1/info")
public class ChitController {
	
	@Autowired
	private ChitService chitService;
	
	@GetMapping("/getAllChits")
	public Response<List<Chits>> getAllChits(){
		Response<List<Chits>> response = new Response<>();
		List<Chits> data = chitService.getAllChits();
		response.setData(data);
		return response;
	}

}
