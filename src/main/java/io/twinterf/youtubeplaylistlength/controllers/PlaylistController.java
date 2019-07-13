package io.twinterf.youtubeplaylistlength.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.twinterf.youtubeplaylistlength.crawler.Crawler;
import io.twinterf.youtubeplaylistlength.entities.Playlist;
import io.twinterf.youtubeplaylistlength.repositories.PlaylistRepository;

@Controller
public class PlaylistController {
	
	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private Crawler crawler;

	@GetMapping(path="/testPutIntoDatabase")
	public @ResponseBody String testPutIntoDatabase() {
		Playlist p = new Playlist("url", "3:00:00", 0);
		playlistRepository.save(p);
		return "hello";
	}
	
//	@GetMapping("/testCrawler")
//	public @ResponseBody String testCrawler() {
//		crawler.getHtml("https://www.youtube.com/playlist?list=PL0qTfdf9DoTgQDG61aOO90_bMUK0XOXMS");
//		return "success";
//	}
}
