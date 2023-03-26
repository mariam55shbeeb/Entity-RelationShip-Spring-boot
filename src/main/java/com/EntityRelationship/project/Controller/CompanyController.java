package com.EntityRelationship.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EntityRelationship.project.Model.Company;
import com.EntityRelationship.project.Service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService cs;
	 
	@PostMapping("/persons/{personId}/company")
	 ResponseEntity<Company> addNewCompanytoPerson(@PathVariable int personId,@RequestBody Company com) {
		return cs.newCompanytoPerson(com,personId);
	}

	
	@PostMapping("companies")
	ResponseEntity<Company> NewCompany(@RequestBody Company com){
		return cs.NewCompany(com);
	}
	
	
}
