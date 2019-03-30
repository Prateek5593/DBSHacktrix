package com.dbs.hacktrix.pqrchits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.hacktrix.pqrchits.domain.ChitsUserMapping;

@Repository
public interface ChitsUsersRepo extends JpaRepository<ChitsUserMapping, Integer>{
	
	List<ChitsUserMapping> findAll();
	
	
}
