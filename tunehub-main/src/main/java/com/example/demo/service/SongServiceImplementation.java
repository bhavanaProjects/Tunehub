package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Song;
import com.example.demo.repository.SongRepository;

@Service
public class SongServiceImplementation implements SongService {
	@Autowired
	SongRepository repo;
	@Override
	public void addSong(Song song) {
		repo.save(song);
	
		
	}
	@Override
	public List<Song> fetchAllSongs() {
		return repo.findAll();
	}
	@Override
	public boolean songExists(String name) {
		// TODO Auto-generated method stub
		Song song = repo.findByName(name);
		if(song==null) {
			return false;
		}
		else {
		return true;
	}
	}

@Override
public void updatedSong(Song song) {
	// TODO Auto-generated method stub
	repo.save(song);
	
}
}
