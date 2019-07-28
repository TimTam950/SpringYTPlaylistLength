package io.twinterf.youtubeplaylistlength.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.twinterf.youtubeplaylistlength.entities.Playlist;
import io.twinterf.youtubeplaylistlength.repositories.PlaylistRepository;

@Component
public class ScheduledTasks {

	@Autowired
    private PlaylistRepository playlistRepository;
	
    @Scheduled(cron = "	0 0 4 1 1/1 ?")
    public void reportCurrentTime() {
        Iterable<Playlist> playLists = playlistRepository.findAll();
        
        for(Playlist playlist: playLists) {
        	if(playlist.getFlag() == 0) {
        		playlistRepository.delete(playlist);
        	} else {
        		playlist.setFlag(0);
        		playlistRepository.save(playlist);
        	}
        }
    }
}
