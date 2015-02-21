package pydictionary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class requestsBase{
	private String link;
	public requestsBase(String url){
		this.link = url;
	}
	public String returnHandledOutput() throws Exception{
		URL obj = new URL(this.link);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		//Caste connection to needed type
		con.setRequestMethod("GET");
		int response = con.getResponseCode();
		System.out.println("HTTP response code: " + response);
		//Let's read the content now
		BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
		//Reads the request data into a buffer
		String line;
		StringBuffer r = new StringBuffer();
		//This is a buffer.. We append our strings to it and get a new string
		while ((line = read.readLine())!=null){
			r.append(line);
		}
		String jsonasString = r.toString();
		return jsonasString;
	}
}