package io.twinterf.youtubeplaylistlength.entities;

import javax.validation.constraints.Pattern;

public class InputString {

	@Pattern(regexp="^https:\\/\\/www\\.youtube\\.com\\/playlist\\?list=[A-Za-z0-9_-]*$", message="Please enter a playlist URL")
	private String text;

	public InputString() {

	}
	
	public InputString(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
