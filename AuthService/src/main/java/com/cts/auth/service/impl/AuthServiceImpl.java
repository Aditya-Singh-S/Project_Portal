package com.cts.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.auth.entity.User;
import com.cts.auth.repository.UserRepository;
import com.cts.auth.service.AuthService;
import com.cts.auth.service.JwtService;

@Service
public class AuthServiceImpl implements AuthService {
	
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	public AuthServiceImpl(UserRepository userRepository) {
		this.userRepo = userRepository;
	}
	
	@Override
	public User register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		verify(user);
		return user;
	}

	@Override
	public String login(String email, String password) {
		//User user = userRepo.findByEmail(email);
		
//		if(encoder.matches(password, user.getPassword())) {
//			return "Login succesfull";
//		}
		
		Authentication authentication = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		
		User user = userRepo.findByEmail(email);
		
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getEmail(), user.getRole());
		} 
		
		return "Password not correct";
	}

	@Override
	public String resetPassword(String email, String oldPassword, String newPassword) {
		User user = userRepo.findByEmail(email);
		
		if(encoder.matches(oldPassword, user.getPassword())) {
			user.setPassword(encoder.encode(newPassword));
			userRepo.save(user);
			return "Password changed succesfully";
		} else {
			return "Password didn't match";
		}
		
//		if(user.getPassword().equals(oldPassword)) {
//			user.setPassword(newPassword);
//			userRepo.save(user);
//			return "Password changed succesfully";
//		} else {
//			return "Password didn't match";
//		}

	}

	@Override
	public void verify(User user) {
		user.setVerified(true);
		userRepo.save(user);
	}

	@Override
	public List<User> viewAll() {
		return userRepo.findAll();
	}

}
