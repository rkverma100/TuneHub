package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tunehub.entity.PlayList;
import com.tunehub.entity.Songs;
import com.tunehub.services.PlayListService;
import com.tunehub.services.SongService;

@Controller
public class PlayListController {
	@Autowired
	SongService songService;
	@Autowired
	PlayListService playlistService;
	
	@GetMapping("createPlaylist")
	public String createPlaylist(Model model) {
		List<Songs> songList = songService.fetchAll();
		model.addAttribute("songs", songList);
		return "createPlaylist";
	}
		
	@GetMapping("/addPlaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		//updating the playlist table
		playlistService.addPlaylist(playlist);
		//updating the songs table
		System.out.println(playlist);
		List<Songs> songList = playlist.getSongs();
		for(Songs s:songList) {
			s.getPlaylist().add(playlist);
			//update the songs object in database
			songService.updateSong(s);
		}
		return "adminHome";
	}
	
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		
		List<PlayList> allPlaylists= playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylists", allPlaylists);
		return "displayPlaylist";
	}
	
	
}
