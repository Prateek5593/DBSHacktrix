package com.dbs.hacktrix.pqrchits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.hacktrix.pqrchits.domain.UserMoneyPerChit;

@Repository
public interface UserMoneyPerChitRepo extends JpaRepository<UserMoneyPerChit, Integer> {
	
	 List<UserMoneyPerChit>  findAllByChitID(Integer chitID);

}
