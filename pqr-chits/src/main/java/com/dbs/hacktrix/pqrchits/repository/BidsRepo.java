package com.dbs.hacktrix.pqrchits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.hacktrix.pqrchits.domain.Bids;

public interface BidsRepo extends JpaRepository<Bids, Integer> {

	public Bids findBychitsIDUserIDAndActiveStatus(Integer chitsID, Integer userID, boolean activeStatus);

	public Bids findByChitsIDAndActiveStatus(Integer chitsID, boolean activeStatus);

	public Bids findByChitsID(Integer chitsID);

}
