package com.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.entity.Songs;


public interface SongRepository extends JpaRepository<Songs, Integer>
{
	public Songs findByName(String name);

}
