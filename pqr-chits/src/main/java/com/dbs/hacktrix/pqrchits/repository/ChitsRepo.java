package com.dbs.hacktrix.pqrchits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.hacktrix.pqrchits.domain.Chits;
import org.springframework.stereotype.Repository;

@Repository
public interface ChitsRepo extends JpaRepository<Chits, Integer> {
	List<Chits> findAll();
}
