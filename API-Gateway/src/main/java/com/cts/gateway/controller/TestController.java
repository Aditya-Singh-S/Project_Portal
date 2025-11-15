package com.cts.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.gateway.service.JwtService;

@RestController
public class TestController {
	
	@Autowired
	JwtService jwtService;
	
	@PreAuthorize("hasRole('HR')")
	@PostMapping("/validate")
	public String validateToken(@RequestParam String token) {
		System.out.println(jwtService.extractRole(token));
		System.out.println(jwtService.extractUsername(token));

		return "Token is valid";
	}
}
