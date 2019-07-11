package io.twinterf.youtubeplaylistlength.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Playlist {

	@Id
	private String id;
	
	private String length;
	
	private Integer flag;
	
	public Playlist() {
		
	}

	public Playlist(String id, String length, Integer flag) {
		this.id = id;
		this.length = length;
		this.flag = flag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	
	
	
}
