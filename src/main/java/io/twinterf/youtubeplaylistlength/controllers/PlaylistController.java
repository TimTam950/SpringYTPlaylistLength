package io.twinterf.youtubeplaylistlength.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.twinterf.youtubeplaylistlength.crawler.Crawler;
import io.twinterf.youtubeplaylistlength.entities.InputString;
import io.twinterf.youtubeplaylistlength.entities.Playlist;
import io.twinterf.youtubeplaylistlength.repositories.PlaylistRepository;

@Controller
public class PlaylistController {
	
	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private Crawler crawler;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		InputString inputString = new InputString();
		model.addAttribute("inputString", inputString);
		return "crawler";
	}
	
	@PostMapping("/")
	public String getLength(@ModelAttribute InputString inputString, Model model) {
		String url = inputString.getText();
		if (playlistRepository.existsById(url)) {
			Playlist playlist = playlistRepository.findById(url).orElse(null);
			if(playlist.getFlag().equals(0)) {
				playlist.setFlag(1);
				model.addAttribute("crawlerResult", playlist.getLength());
				playlistRepository.save(playlist);
				return "crawler";
			} else {
				model.addAttribute("crawlerResult", playlist.getLength());
				return "crawler";
			}
		} else {
			Playlist playlist = new Playlist(url, crawler.getLength(url), 0);
			model.addAttribute("crawlerResult", playlist.getLength());
			playlistRepository.save(playlist);
			return "crawler";
		}
		
	}

}
