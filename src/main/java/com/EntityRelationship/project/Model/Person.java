package com.EntityRelationship.project.Model;

import java.util.List;

import org.springframework.web.util.pattern.PatternParseException.PatternMessage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//Parent entity --- referencing side  (one to one)
//parent entity --- owner side (one to many)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Persons")
public class Person {
	@Id
	@GeneratedValue
	int id;
	
	@NotBlank
	String name;
	
	@Email(regexp = "[a-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-za-z]{2,3}")
    String email; 
	
	
	@JsonBackReference(value = "person_role")
	@OneToOne(cascade = CascadeType.ALL,targetEntity = Role.class)
	Role role;
	
	@JsonManagedReference(value = "Person_cars")
	@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
	List<Car> cars;
	

	@JsonIgnoreProperties("persons")	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Company> companies;
	
	
	
}
