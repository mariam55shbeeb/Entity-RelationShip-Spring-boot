package com.EntityRelationship.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EntityRelationship.project.Model.Car;

public interface CarRepository  extends JpaRepository<Car, Integer>{

}
