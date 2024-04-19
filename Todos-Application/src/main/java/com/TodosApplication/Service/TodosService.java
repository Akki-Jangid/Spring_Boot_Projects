package com.TodosApplication.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.TodosApplication.Model.Todos;

@Service
public class TodosService {

	private static int todoCount=0;
	
	private static List<Todos> todos = new ArrayList<>();
	
	static {
		todos.add(new Todos(++todoCount, "Aakash", "Get Bigger", LocalDate.now().plusMonths(1), false));
		todos.add(new Todos(++todoCount, "Aakash", "Learning Spring Boot", LocalDate.now().plusMonths(3), false));
		todos.add(new Todos(++todoCount, "Aakash", "Learn FrontEnd", LocalDate.now().plusMonths(3), false));
		todos.add(new Todos(++todoCount, "Aakash", "Become Software Engineer", LocalDate.now().plusMonths(6), false));
	}
	
	public List<Todos> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todos todo = new Todos(++todoCount, username, description, targetDate, done);
		todos.add(todo);
	}

	public void deleteTodo(int id) {
		Predicate<? super Todos> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todos findById(int id) {
		Predicate<? super Todos> predicate = todo-> todo.getId()==id;
		Todos todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
}
	
	public void editTodo(Todos todo) {
		// TODO Auto-generated method stub
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}
