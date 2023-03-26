package com.EntityRelationship.project.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Cars")
public class Car {
	
	@Id
	@GeneratedValue
	int id ;
	
	String car_number;
	
	@JsonBackReference(value = "Person_cars")
	@ManyToOne(cascade = CascadeType.ALL)
	 Person person;
	
	

	
	
	

}
