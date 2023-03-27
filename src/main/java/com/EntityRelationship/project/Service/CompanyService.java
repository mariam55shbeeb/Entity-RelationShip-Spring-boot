package com.EntityRelationship.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.EntityRelationship.project.Model.Car;
import com.EntityRelationship.project.Model.Company;
import com.EntityRelationship.project.Model.Person;
import com.EntityRelationship.project.Repository.CompanyRepository;
import com.EntityRelationship.project.Repository.PersonRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository company_transaction;
	@Autowired
	PersonRepository person_transaction;
	
	public ResponseEntity<Company> newCompanytoPerson(Company com,int personId){
		Optional<Person> p= person_transaction.findById(personId);
		if(p.isPresent()) {
			
			p.get().getCompanies().add(com);
			com.getPersons().add(p.get());
			person_transaction.save(p.get());
			return ResponseEntity.ok().body(com);	
		}
		
		else {
			
			return  ResponseEntity.notFound().build();
		}
	
	
}

	public ResponseEntity<Company> NewCompany(Company com) {
		    Company added= company_transaction.save(com);
		    return ResponseEntity.ok(added);
	}
	
	
	
	
	}
