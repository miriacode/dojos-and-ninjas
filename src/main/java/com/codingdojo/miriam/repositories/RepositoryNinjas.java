package com.codingdojo.miriam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.miriam.models.Ninja;

@Repository
public interface RepositoryNinjas extends CrudRepository<Ninja, Long>{
	
	List<Ninja> findAll();
	List<Ninja> findById(long id);
	
	Ninja save(Ninja newNinja);
	
}
