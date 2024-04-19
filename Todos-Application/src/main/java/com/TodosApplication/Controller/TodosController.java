package com.TodosApplication.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.TodosApplication.Model.Todos;
import com.TodosApplication.Service.AuthenticationService;
import com.TodosApplication.Service.TodosService;

//@Controller
@SessionAttributes("name")
public class TodosController {
	
	@Autowired
	private TodosService todoService;
	
	@RequestMapping(value="todos-list", method=RequestMethod.GET)
	public String listTodos(ModelMap model) {
		String username = getLoggedinUser(model);
		model.put("todos", todoService.findByUsername("Aakash"));
		return "listTodos";
	}

	private String getLoggedinUser(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
	
	

	@RequestMapping(value="addTodo", method=RequestMethod.GET)
	public String addTodos(ModelMap model) {
		String username = getLoggedinUser(model);
		Todos todo = new Todos(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value="addTodo", method=RequestMethod.POST)
	public String addPostTodos(ModelMap model, Todos todo) {
		String username = getLoggedinUser(model);;
		todoService.addTodo(username, todo.getDescription(), todo.getTarget(), false);
		return "redirect:todos-list";
	}

	@RequestMapping("deleteTodo")
	public String deleteTodos(ModelMap model, @RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:todos-list";
	}

	@RequestMapping(value="editTodo", method=RequestMethod.GET)
	public String editTodos(ModelMap model, @RequestParam int id) {
		Todos todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value="editTodo", method=RequestMethod.POST)
	public String editPostTodos(ModelMap model, @RequestParam int id, Todos todo) {
		
//		String username = getLoggedinUser(model);;
//		todo.setUsername(username);
		todoService.editTodo(todo);
		return "redirect:todos-list";
	}
}
