package io.twinterf.youtubeplaylistlength;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.twinterf.youtubeplaylistlength.repositories.PlaylistRepository;

@SpringBootApplication
public class YoutubePlaylistLengthApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoutubePlaylistLengthApplication.class, args);
		
		
	}

}
