package com.Myex.base.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Myex.base.models.ScoreTable;
import com.Myex.base.services.ScoreTableService;



@RestController
@RequestMapping("/scoretable")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
public class ScoreTableController {
	
	@Autowired
	private ScoreTableService sctservice;
	
	@GetMapping
	//@CrossOrigin(origins = "http://localhost:4200")
	@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
	public List<ScoreTable> getAllScore() {
		return sctservice.getAllScore();
	}
	
	@PostMapping("/new")
	//@CrossOrigin(origins = "http://localhost:4200")
	@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    public ScoreTable addScore(@RequestBody ScoreTable score) {
    	return sctservice.addScore(score);
    }
	
}
