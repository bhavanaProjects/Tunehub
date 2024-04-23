package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Playlist;
import com.example.demo.entity.Song;
import com.example.demo.service.PlaylistService;
import com.example.demo.service.SongService;
@Controller
public class PlaylistController {
	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistService playlistService;
	
	@GetMapping("/createPlayList")
	public String createPlayList(Model model)
	{
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createPlayList";
	}
	@PostMapping("/addPlaylist")
	public String addPlayList(@ModelAttribute Playlist playlist) {
		playlistService.addPlaylist(playlist);
		
		// updating song table
		List <Song> songList = playlist.getSongs();
		for(Song s: songList) {
			s.getPlaylists().add(playlist);
		songService.updatedSong(s);
		}
		return "admin";
	}
	@GetMapping("/viewPlayList")
	public String viewPlayList(Model model) {
	List <Playlist> allPlaylist= playlistService.fetchAllPlaylist();
	model.addAttribute("allPlaylist", allPlaylist);
		return"displayPlayList";

	}

}
