package com.dbs.hacktrix.pqrchits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.hacktrix.pqrchits.domain.Chits;

public interface ChitsRepo extends JpaRepository<Chits, Integer> {

		List<Chits> findAll();
}
