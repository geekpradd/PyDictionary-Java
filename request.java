package pydictionary;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/*
 * Make a HTTP GET request and find out response code
 */

public class request extends requestsBase{
	public request (String url){
		super(url);
		
	}
	public static void main(String[] args) throws Exception{
		request obj = new request("http://pydictionary-geekpradd.rhcloud.com/api/synonym/general");
		JSONArray syn = obj.getSynonyms();
		//Iterate over List
		System.out.println("Synonyms are: ");
		for (int i=0;i<syn.size();i++){
			System.out.print(syn.get(i)+", ");
		}
	}
	public JSONArray getSynonyms() throws Exception {
		
		String jsonasString = this.returnHandledOutput();
		JSONParser parser = new JSONParser();
		JSONArray synonyms = (JSONArray) parser.parse(jsonasString);
		return synonyms;
	}
}

