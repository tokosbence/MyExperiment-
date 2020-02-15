package com.Myex.base.controllers;

import java.security.Principal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Myex.base.models.EmployerUser;
import com.Myex.base.repositories.EmployerUserRepository;
import com.Myex.base.services.EmployerUserService;






@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployerUserController {
	private EmployerUserRepository employerUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private EmployerUserService userServices;
    
    public EmployerUserController(EmployerUserRepository employerUserRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
    			this.employerUserRepository = employerUserRepository;
    			this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @PostMapping("/sign-up")
    @CrossOrigin(origins = "http://localhost:4200")
    public void signUp(@RequestBody EmployerUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        employerUserRepository.save(user);
    }
    
    @GetMapping("/current")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EmployerUser> GetCurrentUser()
    {
    	SecurityContext securityContext = SecurityContextHolder.getContext();
    	if(securityContext != null) {
    		Authentication authentication = securityContext.getAuthentication();
    		String userName = (String) authentication.getPrincipal();
    		
    		EmployerUser user = employerUserRepository.findByUsername(userName);
    		return ResponseEntity.ok(user);
    	}
    	
    	
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    
    
   @GetMapping("/allusers")
   @CrossOrigin(origins = "http://localhost:4200")
   public List<EmployerUser> getAllUser(){
	   return userServices.getAllUser();
   }
    
    @PostMapping("/adduser")
    @CrossOrigin(origins = "http://localhost:4200")
    public void addUser(@RequestBody EmployerUser user) {
    	userServices.addUser(user);
    }
    
   /* @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("http://localhost:8080/login")
	public Principal user(Principal principal) {
		//logger.info("user logged "+principal);
		return principal;
	}*/
    
}
