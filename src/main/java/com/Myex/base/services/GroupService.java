package com.Myex.base.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Myex.base.models.Group;
import com.Myex.base.repositories.GroupRepository;



@Service
public class GroupService {
	
	@Autowired
	private GroupRepository groupRepository;
	
	public List<Group> getAllGroup(){
		List<Group> groups = new ArrayList<Group>();
		Iterator<Group> iterator = groupRepository.findAll().iterator();
		while (iterator.hasNext()) {
			groups.add(iterator.next());
		}
		
		return groups;
	}
	
	public Optional<Group> getGroup(Integer groupId) {
		return groupRepository.findById(groupId);
	}
	
	/*public Group getGroup(String name) {
		return groupRepository.findByName(name);
	}*/
	
	public Group addGroup(Group group) {
		return groupRepository.save(group);
	}
	
	public Group updateGroup(Group group) {
		return groupRepository.save(group);
	}
	
	public void deleteGroup(Integer groupId) {
		groupRepository.deleteById(groupId);
	}
	
}
