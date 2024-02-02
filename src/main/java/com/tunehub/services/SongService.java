package com.tunehub.services;

import java.util.List;

import com.tunehub.entity.Songs;

public interface SongService {
	
	public void addSong(Songs song);
	
	public void updateSong(Songs song);
	
	public List<Songs> fetchAll();
	
	public boolean songExist(String name);

}
