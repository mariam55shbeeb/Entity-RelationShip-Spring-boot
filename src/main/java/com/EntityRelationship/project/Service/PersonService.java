package com.EntityRelationship.project.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.EntityRelationship.project.Model.Car;
import com.EntityRelationship.project.Model.Person;
import com.EntityRelationship.project.Model.Role;
import com.EntityRelationship.project.Repository.PersonRepository;
import com.EntityRelationship.project.Repository.RoleRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository person_transaction;
	
	@Autowired
	RoleRepository   role_transaction;
	
	
	
	
	
	
    public ResponseEntity<Person> getPerson(int personId) throws Exception {
    	
    	   Optional<Person> p= person_transaction.findById(personId);
    	  
      	   if(p.isPresent()) {
      		  return  ResponseEntity.ok().body(p.get());
      	   }
      	   else
      		  return ResponseEntity.notFound().build();
    }
    
    
    public ResponseEntity<Person> newPerson(Person p) {
    	
    	   Person savedPerson=person_transaction.save(p);
    	  
    	   return ResponseEntity.ok().body(savedPerson);
    }
    
    
    public ResponseEntity<Person>  updateInfo(int id,Person p) throws Exception{
    	
           	Optional<Person> op=person_transaction.findById(id);
       	 
           	 if(op.isPresent()) {
           		 Person UpdatedPerson=op.get();
           		 UpdatedPerson.setName(p.getName());
       		     UpdatedPerson.setRole(p.getRole());
       		     UpdatedPerson.setCars(p.getCars());
       		     UpdatedPerson.setCompanies(p.getCompanies());
       		     
       		     person_transaction.save(UpdatedPerson);
       		     return ResponseEntity.ok().body(UpdatedPerson);}
           	 else {
           		 
           	     return ResponseEntity.notFound().build();
           	 }
       		    
       		     
          	 }
    
    
  
    }

    
    
    
    

