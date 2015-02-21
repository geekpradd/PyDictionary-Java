package pydictionary;
import java.net.*;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

/*
 * Make a HTTP GET request and find out response code
 */
public class request {
	private String link;
	public request (String url){
		this.link = url;
		
	}
	public static void main(String[] args) throws Exception{
		request t = new request("http://pydictionary-geekpradd.rhcloud.com/api/synonym/sporadic");
		t.makeGET();
		System.out.println("All right");
	}
	private void makeGET() throws Exception {
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
		JSONParser parser = new JSONParser();
		JSONArray mysynonyms = (JSONArray) parser.parse(jsonasString);
		System.out.println("Synonyms are: ");
		for (int i=0; i<mysynonyms.size();i++){
			System.out.print(mysynonyms.get(i) + ", ");
		}
	}
}

