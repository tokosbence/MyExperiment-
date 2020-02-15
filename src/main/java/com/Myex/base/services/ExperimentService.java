package com.Myex.base.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Myex.base.models.Experiment;
import com.Myex.base.repositories.ExperimentRepository;

@Service
public class ExperimentService {
	
	@Autowired
	private ExperimentRepository experimentRepository;
	
	public List<Experiment> getAllExperiment(){
		List<Experiment> experiments = new ArrayList<Experiment>();
		Iterator<Experiment> iterator = experimentRepository.findAll().iterator();
		while (iterator.hasNext()) {
			experiments.add(iterator.next());
		}
		
		return experiments;
	}
	
	public Optional<Experiment> getExperiment(Integer experimentId) {
		return experimentRepository.findById(experimentId);
	}
	
	public Experiment getExperiment(String name) {
		return experimentRepository.findByName(name);
	}
	
	public Experiment addExperiment(Experiment experiment) {
		return experimentRepository.save(experiment);
	}
	
	public Experiment updateExperiment(Experiment experiment) {
		return experimentRepository.save(experiment);
	}
	
	public void deleteExperiment(Integer experimentId) {
		experimentRepository.deleteById(experimentId);
	}
	
	
}
