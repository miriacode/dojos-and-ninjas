package com.codingdojo.miriam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.miriam.models.Dojo;
import com.codingdojo.miriam.models.Ninja;

@Repository
public interface RepositoryDojos extends CrudRepository<Dojo, Long>{
	
	List<Dojo> findAll();
	List<Dojo> findById(long id);
	
	Dojo save(Dojo newDojo);
	
}
