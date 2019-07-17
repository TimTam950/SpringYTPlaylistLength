package io.twinterf.youtubeplaylistlength.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class Crawler {
	
	public String getLength(String url) {
		Document doc;
		Elements elements = new Elements();
		Pattern p = Pattern.compile("([0-9]+):([0-9]{2})");
		ArrayList<Integer> minutes = new ArrayList<>();
		ArrayList<Integer> seconds = new ArrayList<>();
		try {
			doc = Jsoup.connect(url).get();
			elements = doc.getElementsByClass("timestamp");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		elements.forEach((e) ->{
			Matcher m = p.matcher(e.text());
			if (m.find()) {
				minutes.add(Integer.parseInt(m.group(1)));
				seconds.add(Integer.parseInt(m.group(2)));
			}
			
		});
		
		int totalSeconds = 0;
		for(int i = 0; i < minutes.size(); i++) {
			totalSeconds = totalSeconds + (minutes.get(i) * 60) + seconds.get(i);
		}
		
		int finalHours = totalSeconds / 3600;
		int finalMinutes = (totalSeconds % 3600) / 60;
		int finalSeconds = totalSeconds % 60;

		String timeString = String.format("%02d:%02d:%02d", finalHours, finalMinutes, finalSeconds);
		
		return timeString;
	}
	
	
}
