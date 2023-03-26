package com.EntityRelationship.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.EntityRelationship.project.Model.Car;
import com.EntityRelationship.project.Model.Person;
import com.EntityRelationship.project.Model.Role;
import com.EntityRelationship.project.Repository.CarRepository;
import com.EntityRelationship.project.Repository.PersonRepository;

@Service
public class CarService  {
	@Autowired
	CarRepository car_transaction;
	@Autowired
	PersonRepository person_transaction;

	public ResponseEntity<Car> getCar( int id) {
        Optional<Car> car= car_transaction.findById(id);
        
        if(car.isPresent()) {
      
        return ResponseEntity.ok().body(car.get());}
        else {
       	
		 return ResponseEntity.notFound().build();			}}



public ResponseEntity<Car> updateCar(Car car,int carId) {
	 
	Optional<Car> op=car_transaction.findById(carId);
	 if(op.isPresent()) {
		 Car updatedCar=op.get();
		 updatedCar.setCar_number(car.getCar_number());
		 car_transaction.save(updatedCar);
		 return ResponseEntity.ok().body(updatedCar);
	 }
	 else 
		 return ResponseEntity.notFound().build();
   }

public ResponseEntity<Car> newCar(Car car,int personId){
		Optional<Person> p= person_transaction.findById(personId);
		if(p.isPresent()) {
			p.get().getCars().add(car);
			car.setPerson(p.get());
			person_transaction.save(p.get());
			return ResponseEntity.ok().body(car);	
		}
		
		else {
			
			return  ResponseEntity.notFound().build();
		}
  }
}

