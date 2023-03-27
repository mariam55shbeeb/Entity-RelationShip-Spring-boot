package com.EntityRelationship.project.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EntityRelationship.project.Model.Role;
import com.EntityRelationship.project.Repository.RoleRepository;
import com.EntityRelationship.project.Service.RoleService;

@RestController
public class RoleController {

	@Autowired
	RoleService rs;

	@GetMapping("/roles/{id}")
	ResponseEntity<Role> getrole(@PathVariable int id) {
		return rs.getRole(id);
	}

	@PostMapping("/roles")
	ResponseEntity<Role> newRole(@RequestBody Role r) {
		return rs.newRole(r);
	}

	@PutMapping("/role/{roleId}")
	ResponseEntity<Role> editRole(@PathVariable int roleId, @RequestBody Role r) {
		return rs.updateRole(roleId, r);
	}
}
