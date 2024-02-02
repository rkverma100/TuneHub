package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.PlayList;
import com.tunehub.repository.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService{

	@Autowired
	PlayListRepository repo;
	
	@Override
	public void addPlaylist(PlayList playlist) {
		repo.save(playlist);
		
	}

	@Override
	public List<PlayList> fetchAllPlaylists() {
		return repo.findAll();
	}

}
