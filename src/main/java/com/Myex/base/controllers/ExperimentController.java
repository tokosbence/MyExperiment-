package com.Myex.base.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Myex.base.models.Experiment;
import com.Myex.base.services.ExperimentService;


@RestController
@RequestMapping("/experiments")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
public class ExperimentController {
	@Autowired
	private ExperimentService experimentService;
	
	@GetMapping(value="/{experimentId}")
	@CrossOrigin(origins = "http://localhost:4200")
		public Optional<Experiment> getExperiment(@PathVariable("experimentId") Integer experimentId) {
			return experimentService.getExperiment(experimentId);
		}
	
	
	@GetMapping
	//@CrossOrigin(origins = "http://localhost:4200")
	@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
	public List<Experiment> getAllExperiment() {
		return experimentService.getAllExperiment();
	}

	@PostMapping("/new")
	@CrossOrigin(origins = "http://localhost:4200")
    public Experiment addExperiment(@RequestBody Experiment experiment) {
    	return experimentService.addExperiment(experiment);
    }

	@PostMapping("/updateExperiment")
	@CrossOrigin(origins = "http://localhost:4200")
	public Experiment updateExperiment(@RequestBody  Experiment experiment) {
		return experimentService.updateExperiment(experiment);
	}
 
	@DeleteMapping(value = "/{experimentId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteExperiment(@PathVariable("experimentId") Integer experimentId) {
		experimentService.deleteExperiment(experimentId);
	}
	
	
}
