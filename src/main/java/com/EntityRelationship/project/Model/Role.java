package com.EntityRelationship.project.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//child class --- owner side

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Roles")
public class Role {
	
       @Id
       @GeneratedValue
       int id;

       String name;
       
       
       @OneToOne(targetEntity = Person.class, mappedBy= "role",cascade = CascadeType.ALL)
       @JsonManagedReference(value = "person_role")
       Person person;

       

 
       
}
