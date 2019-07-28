package io.twinterf.youtubeplaylistlength.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String getLength(@Valid @ModelAttribute("inputString") InputString inputString, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Input Error");
			return "crawler";
		}
		
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
