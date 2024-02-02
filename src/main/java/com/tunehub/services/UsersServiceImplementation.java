package com.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.Users;
import com.tunehub.repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{

	@Autowired
	UsersRepository repo;
	
	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "user added succesfully";
	}

	@Override
	public boolean emailExist(String email) {
		if(repo.findByEmail(email) == null)
		{
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user = repo.findByEmail(email);
		if(password.equals(user.getPassword()))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getUserRole(String email) {
		Users user = repo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
		
	}
	
	

}
