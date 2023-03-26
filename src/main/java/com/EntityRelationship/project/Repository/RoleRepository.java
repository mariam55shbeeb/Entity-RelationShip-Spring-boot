package com.EntityRelationship.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EntityRelationship.project.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
