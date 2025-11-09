package com.cts.auth.service;

import java.util.List;

import com.cts.auth.entity.User;

public interface AuthService {
	
	public String register(User user);
	
	public String login(String email, String password);
	
	public String resetPassword(String email, String oldPassword, String newPassword);
	
	public void verify(User user);
	
	public List<User> viewAll();
	
}
