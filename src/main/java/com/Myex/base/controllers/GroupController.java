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


import com.Myex.base.models.Group;
import com.Myex.base.services.GroupService;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@GetMapping(value="/{groupId}")
	public Optional<Group> getGroup(@PathVariable("groupId") Integer groupId) {
		return groupService.getGroup(groupId);
	}
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Group> getAllGroup(){
		return groupService.getAllGroup();
	}
	
	@PostMapping("/new")
	@CrossOrigin(origins = "http://localhost:4200")
    public Group addGroup(@RequestBody Group group) {
    	return groupService.addGroup(group);
    }
	
	@PostMapping("/updateGroup")
	public Group updateGroup(@RequestBody  Group group) {
		return groupService.updateGroup(group);
	}
 
	@DeleteMapping(value = "/{groupId}")
	public void deleteGroup(@PathVariable("groupId") Integer groupId) {
		groupService.deleteGroup(groupId);
	}
	

}
