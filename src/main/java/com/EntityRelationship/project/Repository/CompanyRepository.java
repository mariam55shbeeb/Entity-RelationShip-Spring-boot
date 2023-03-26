package com.EntityRelationship.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EntityRelationship.project.Model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
