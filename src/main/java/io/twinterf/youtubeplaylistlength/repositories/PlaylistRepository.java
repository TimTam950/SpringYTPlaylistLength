package io.twinterf.youtubeplaylistlength.repositories;

import org.springframework.data.repository.CrudRepository;

import io.twinterf.youtubeplaylistlength.entities.Playlist;

public interface PlaylistRepository extends CrudRepository<Playlist, String> {

}
