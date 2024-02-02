package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.entity.Songs;
import com.tunehub.entity.Users;
import com.tunehub.services.SongService;
import com.tunehub.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UsersService service;
	@Autowired
	SongService songService;
	
	@PostMapping("registration")
	public String addUsers(@ModelAttribute Users user) {
		boolean userStatus = service.emailExist(user.getEmail());
		if(userStatus ==false) {
			service.addUser(user);
			System.out.println("User Added");
		}
		else {
			System.out.println("User already Exixt");
		}
		return "index";
	}
	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session,
			Model model) {
		if(service.validateUser(email, password)==true) 
		{
			String role = service.getUserRole(email);
			session.setAttribute("email", email);
			
			if(role.equals("admin"))
			{
				return "adminHome";
			}
			else {
				Users user = service.getUser(email);
				boolean userStatus = user.isPremium();
				List<Songs> songsList = songService.fetchAll();
				model.addAttribute("songs", songsList);
				
				model.addAttribute("isPremium", userStatus);
				return "customerHome";
			}

		}
		else {
			return "login";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	

}
