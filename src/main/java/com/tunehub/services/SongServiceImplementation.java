package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.Songs;
import com.tunehub.repository.SongRepository;

@Service
public class SongServiceImplementation implements SongService
{
	@Autowired
	SongRepository sr;

	@Override
	public void addSong(Songs song) {
		sr.save(song);
		
	}

	@Override
	public void updateSong(Songs song) {
		sr.save(song);
		
	}
	
	@Override
	public List<Songs> fetchAll() {
		
		return sr.findAll();
	}
	
	public boolean songExist(String name) {
		Songs song = sr.findByName(name);
		if(song ==null) {
			return false;
		}
		return true;
		
	}

	

}
