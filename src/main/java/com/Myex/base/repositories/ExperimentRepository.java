package com.Myex.base.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Myex.base.models.Experiment;

@CrossOrigin(origins = "http://localhost:4200")
public interface ExperimentRepository extends CrudRepository<Experiment, Integer> {
	Optional<Experiment> findById(Integer experimentId);
	Experiment findByName(String name);
	
}
