package com.Myex.base.repositories;

//import java.sql.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.Myex.base.models.Group;



@CrossOrigin(origins = "http://localhost:4200")
public interface GroupRepository extends CrudRepository<Group, Integer> {

	Optional<Group> findById(Integer groupId);
	//Optional<Group> findByDate(Date groupdate);
	//Group findByName(String name);
}
