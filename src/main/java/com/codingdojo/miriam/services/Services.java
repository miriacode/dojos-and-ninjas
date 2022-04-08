package com.codingdojo.miriam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.miriam.models.Dojo;
import com.codingdojo.miriam.models.Ninja;
import com.codingdojo.miriam.repositories.RepositoryDojos;
import com.codingdojo.miriam.repositories.RepositoryNinjas;


@Service
public class Services {
	
	//Depends on the repository
	private final RepositoryDojos repository_dojos;
	private final RepositoryNinjas repository_ninjas;
	
	public Services(RepositoryDojos repository_dojos, RepositoryNinjas repository_ninjas) {
		super();
		this.repository_dojos = repository_dojos;
		this.repository_ninjas = repository_ninjas;
	}
	
	//Ninjas get all
	public List<Ninja> get_all_ninjas() {
		return repository_ninjas.findAll();
	}
	
	//Ninjas Create - Evaluate
	public Ninja find_ninja(Long id) {
		Optional<Ninja> optionalNinja = repository_ninjas.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	//Ninjas Create
	public Ninja save_ninja(Ninja newNinja) {
		return repository_ninjas.save(newNinja);
	}
	
	
	//--------------------------------------------------------------------------------------------------------
	
	//Dojos get all
		public List<Dojo> get_all_dojos() {
			return repository_dojos.findAll();
		}
		
	//Dojos Create - Evaluate
	public Dojo find_dojo(Long id) {
		Optional<Dojo> optionalDojo = repository_dojos.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
		
	//Dojos Create
	public Dojo save_dojo(Dojo newDojo) {
		return repository_dojos.save(newDojo);
	}
	
	
	
}