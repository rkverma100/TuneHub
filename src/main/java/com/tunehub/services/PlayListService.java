package com.tunehub.services;

import java.util.List;

import com.tunehub.entity.PlayList;

public interface PlayListService {
	public void addPlaylist(PlayList playlist);
	
	public List<PlayList> fetchAllPlaylists();

}
