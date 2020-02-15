package com.Myex.base.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Myex.base.models.ScoreTable;



@CrossOrigin(origins = "http://localhost:4200")
public interface ScoreTableRepository extends CrudRepository<ScoreTable, Integer>{

}
