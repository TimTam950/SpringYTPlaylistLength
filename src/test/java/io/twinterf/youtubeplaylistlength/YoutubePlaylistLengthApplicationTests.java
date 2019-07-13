package io.twinterf.youtubeplaylistlength;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YoutubePlaylistLengthApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	
	public static void main(String args[]) {
		String length = null;
		Document doc;
		Elements elements = new Elements();
		DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		try {
			doc = Jsoup.connect("https://www.youtube.com/playlist?list=PL0qTfdf9DoTgQDG61aOO90_bMUK0XOXMS").get();
			elements = doc.getElementsByClass("timestamp");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		elements.forEach((e) ->{
			System.out.println(e.text());
		}); 
	}

}
