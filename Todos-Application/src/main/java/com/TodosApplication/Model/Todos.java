package com.TodosApplication.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todos {
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String description;
	private LocalDate target;
	private boolean done;
	
}
