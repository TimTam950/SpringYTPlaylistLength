package io.twinterf.youtubeplaylistlength.crawler;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Crawler {
	
	public String getLength(String url) {
		String length = null;
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Elements elements = doc.getElementsByClass("timestamp");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return length;
	}
	
	
}
