package com.cts.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.auth.entity.User;
import com.cts.auth.repository.UserRepository;
import com.cts.auth.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	public AuthServiceImpl(UserRepository userRepository) {
		this.userRepo = userRepository;
	}
	
	@Override
	public String register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		verify(user);
		return "User registered succesfully";
	}

	@Override
	public String login(String email, String password) {
		User user = userRepo.findByEmail(email);
		
		//String encodedPassword = encoder.encode(password);
		//System.out.println(encodedPassword);
		System.out.println(user.getPassword());
		
		if(encoder.matches(password, user.getPassword())) {
			return "Login succesfull";
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
