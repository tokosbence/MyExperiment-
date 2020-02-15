package com.Myex.base.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Myex.base.models.ScoreTable;
import com.Myex.base.repositories.ScoreTableRepository;





@Service
public class ScoreTableService {
	
	@Autowired
	private ScoreTableRepository sctRepository;
	
	public List<ScoreTable> getAllScore(){
		List<ScoreTable> scores = new ArrayList<ScoreTable>();
		Iterator<ScoreTable> iterator = sctRepository.findAll().iterator();
		while (iterator.hasNext()) {
			scores.add(iterator.next());
		}
		
		return scores;
	}
	
	public ScoreTable addScore(ScoreTable score) {
		return sctRepository.save(score);
	}
	
}
