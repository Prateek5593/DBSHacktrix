package com.dbs.hacktrix.pqrchits.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.hacktrix.pqrchits.domain.Chits;
import org.springframework.stereotype.Repository;

@Repository
public interface ChitsRepo extends JpaRepository<Chits, Integer> {
<<<<<<< HEAD

	List<Chits> findAll();

	Optional<Chits> findById(Integer id);
=======
	List<Chits> findAll();
>>>>>>> 8862f7bcceb79c73815f2bc99678b73fc85b108a
}
