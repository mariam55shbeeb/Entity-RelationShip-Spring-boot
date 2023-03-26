package com.EntityRelationship.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.EntityRelationship.project.Model.Person;
import com.EntityRelationship.project.Model.Role;
import com.EntityRelationship.project.Repository.PersonRepository;
import com.EntityRelationship.project.Repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository   role_transaction;
	@Autowired
	PersonRepository  person_transaction;
	
	
	public ResponseEntity<Role> getRole( int id) {
	         Optional<Role> r= role_transaction.findById(id);
	         
	         if(r.isPresent()) {
	       
	         return ResponseEntity.ok().body(r.get());}
	         else {
	        	
			 return ResponseEntity.notFound().build();			}}
	
	
	
	public ResponseEntity<Role> updateRole(Role role,int roleId) {
		 
		Optional<Role> op=role_transaction.findById(roleId);
		 if(op.isPresent()) {
			 Role updatedRole=op.get();
			 updatedRole.setName(role.getName());
			 role_transaction.save(updatedRole);
			 return ResponseEntity.ok().body(updatedRole);
		 }
		 else 
			 return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<Role> newRole(Role r,int personId){
		Optional<Person> p= person_transaction.findById(personId);
		if(p.isPresent()) {
			p.get().setRole(r);
			r.setPerson(p.get());
			person_transaction.save(p.get());
			return ResponseEntity.ok().body(p.get().getRole());	
		}
		
		else {
			
			return  ResponseEntity.notFound().build();
		}
		
		 
	}
	
	

	
	
}
