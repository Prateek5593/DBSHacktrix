package com.dbs.hacktrix.pqrchits.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hacktrix.pqrchits.dto.UserRequestDTO;
import com.dbs.hacktrix.pqrchits.service.LoginService;
import com.dbs.hacktrix.pqrchits.util.Response;

@RestController
@RequestMapping("/api/v1/info")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/doLogin")
	public Response<Integer> doLogin(@RequestBody @Validated UserRequestDTO userRequestDTO){
		Response<Integer> response = new Response<>();
		Integer data = loginService.doLogin(userRequestDTO);
		response.setData(data);
		return response;
	}
}
