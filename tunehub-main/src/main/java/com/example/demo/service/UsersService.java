package com.example.demo.service;

import com.example.demo.entity.Users;
public interface UsersService {  
	  public boolean emailExists(String email);

	  public boolean validateUser(String email, String password);

	  public String getRole(String email);

	  public String addUser(Users user);

	 public Users getUser(String email);

	 public void updateUser(Users user);
	}


