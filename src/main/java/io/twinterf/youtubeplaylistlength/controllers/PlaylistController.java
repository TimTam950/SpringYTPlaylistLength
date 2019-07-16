package io.twinterf.youtubeplaylistlength.controllers;

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
	public String getLength(@ModelAttribute InputString inputString) {
		String url = inputString.getText();
		System.out.println(crawler.getLength(url));
		return "crawler";
	}

	@GetMapping(path="/testPutIntoDatabase")
	public @ResponseBody String testPutIntoDatabase() {
		Playlist p = new Playlist("url", "3:00:00", 0);
		playlistRepository.save(p);
		return "hello";
	}
	
	@GetMapping("/testCrawler")
	public @ResponseBody String testCrawler() {
		String length = crawler.getLength("https://www.youtube.com/playlist?list=PL0qTfdf9DoTgQDG61aOO90_bMUK0XOXMS");
		System.out.println(length);
		return "success";
	}
}
