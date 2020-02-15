package com.Myex.base.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Myex.base.models.EmployerUser;



@CrossOrigin(origins = "http://localhost:4200")
public interface EmployerUserRepository extends CrudRepository<EmployerUser, Long> {
	public EmployerUser findByUsername(String name);

}
