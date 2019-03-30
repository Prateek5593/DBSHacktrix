package com.dbs.hacktrix.pqrchits.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.hacktrix.pqrchits.domain.Chits;

@Repository
public interface ChitsRepo extends JpaRepository<Chits, Integer> {

	List<Chits> findAll();

	Optional<Chits> findById(Integer id);
}
