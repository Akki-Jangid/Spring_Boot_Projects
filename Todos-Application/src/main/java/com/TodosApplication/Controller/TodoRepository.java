package com.TodosApplication.Controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TodosApplication.Model.Todos;


public interface TodoRepository extends JpaRepository<Todos, Integer>{
	
	public List<Todos> findByUsername(String username);
}
