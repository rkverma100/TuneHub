package com.tunehub.services;

import com.tunehub.entity.Users;

public interface UsersService 
{
	
	public String addUser(Users user);
	
	public boolean emailExist(String email);
	
	public boolean validateUser(String email, String password);
	
	public String getUserRole(String email);
	
	public Users getUser(String email);
	
	public void updateUser(Users user);
}
