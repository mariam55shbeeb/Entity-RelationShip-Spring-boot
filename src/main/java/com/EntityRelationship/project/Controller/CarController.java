package com.EntityRelationship.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EntityRelationship.project.Model.Car;
import com.EntityRelationship.project.Model.Role;
import com.EntityRelationship.project.Repository.CarRepository;
import com.EntityRelationship.project.Service.CarService;

@RestController
public class CarController {
	@Autowired
	CarService cr;
	
	@PostMapping("/persons/{personId}/car")
	 ResponseEntity<Car> newRole(@PathVariable int personId,@RequestBody Car car) {
		return cr.newCar(car,personId);
	}

}
