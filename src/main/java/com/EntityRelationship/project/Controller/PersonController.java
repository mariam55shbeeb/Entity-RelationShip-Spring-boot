package com.EntityRelationship.project.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EntityRelationship.project.Model.Person;
import com.EntityRelationship.project.Model.Role;
import com.EntityRelationship.project.Repository.PersonRepository;
import com.EntityRelationship.project.Repository.RoleRepository;
import com.EntityRelationship.project.Service.PersonService;
import com.EntityRelationship.project.Service.RoleService;

import jakarta.validation.Valid;

@RestController
public class PersonController {

	@Autowired
	PersonService ps;
	@Autowired
	RoleService rs;

	@GetMapping("/persons/{personid}")
	ResponseEntity<Person> getPerson(@Valid @PathVariable int personid) throws Exception {
		return ps.getPerson(personid);
	}

	@PostMapping("/persons")
	ResponseEntity<Person> newPerson(@Valid @RequestBody Person p) {
		return ps.newPerson(p);
	}

	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> update(@PathVariable int id, @Valid @RequestBody Person p) throws Exception {
		return ps.updateInfo(id, p);
	}
	@PutMapping("/persons/{personId}/role")
	ResponseEntity<Role> newRole(@PathVariable int personId, @RequestBody Role r) {
		return rs.assignNewRoleToPerson(r,personId);

}
	}
