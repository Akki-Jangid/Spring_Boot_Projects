package com.TodosApplication.Service;

import org.springframework.stereotype.Service;

import com.TodosApplication.Model.Todos;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String pass) {
		boolean isValidUsername = username.equalsIgnoreCase("Aakash");
		boolean isValidPass = pass.equalsIgnoreCase("Akki@123");
		
		return isValidUsername && isValidPass;
	}
}
