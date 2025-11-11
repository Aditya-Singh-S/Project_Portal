package com.cts.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.auth.entity.User;
import com.cts.auth.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		String response = authService.register(user);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		String response = authService.login(email, password);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/resetPassword")
	public ResponseEntity<String> resetPassword(@RequestParam("email") String email, 
			@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword){
		String response = authService.resetPassword(email, oldPassword, newPassword);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("userLists")
	public ResponseEntity<List<User>> viewAllUsers(){
		List<User> users = authService.viewAll();
		return ResponseEntity.ok(users);
	}
	
}
