 package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.Songs;
import com.tunehub.services.SongService;

@Controller
public class SongController {
	@Autowired
	SongService service;

	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Songs song)
	{
		boolean status = service.songExist(song.getName());
		if(status==false) {
			service.addSong(song);
			System.out.println("Song Added");
		}
		else {
			System.out.println("Already exist");
		}
		return "adminHome";
	}

	@GetMapping("/viewSongs")
	public String viewSong(Model model)
	{
		List<Songs> songsList = service.fetchAll();
		model.addAttribute("songs", songsList);
		return "displaySongs";
	}
	
	@GetMapping("/playSongs")
	public String playSongs(Model model) {
		
		boolean premiumUser = false;
		
		if(premiumUser == true) {
			List<Songs> songsList = service.fetchAll();
			model.addAttribute("songs", songsList);
			return "displaySongs";
		}
		else {
			return "makePayment";
		}	
	}

}
