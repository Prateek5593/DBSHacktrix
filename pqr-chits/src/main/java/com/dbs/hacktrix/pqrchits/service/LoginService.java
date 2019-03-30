package com.dbs.hacktrix.pqrchits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dbs.hacktrix.pqrchits.domain.User;
import com.dbs.hacktrix.pqrchits.dto.UserRequestDTO;
import com.dbs.hacktrix.pqrchits.repository.UserRepo;

@Service
public class LoginService {
	
	@Autowired
	private UserRepo userRepo;
	
	public Integer doLogin(UserRequestDTO userRequestDTO) {
		if(StringUtils.isEmpty(userRequestDTO.getEmail()) || StringUtils.isEmpty(userRequestDTO.getPassword()))
			return null;
		User user = userRepo.findByEmailAndPassword(userRequestDTO.getEmail(), userRequestDTO.getPassword());
		if(null != user) {
			return user.getId();
		}
		return 0;
	}
}
