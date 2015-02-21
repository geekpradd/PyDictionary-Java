package pydictionary;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class pydictionary {

	public static void main(String[] args) throws Exception{
		pydictionary obj = new pydictionary();
		JSONArray syn = obj.getAntonyms("Hatred");
		//Iterate over List
		System.out.println("Antonyms are: ");
		for (int i=0;i<syn.size();i++){
			System.out.print(syn.get(i)+", ");
		}
	}
	public JSONArray getSynonyms(String word) throws Exception {
		requestsBase core = new requestsBase("http://pydictionary-geekpradd.rhcloud.com/api/synonym/"+word);
		String jsonasString = core.returnHandledOutput();
		JSONParser parser = new JSONParser();
		JSONArray synonyms = (JSONArray) parser.parse(jsonasString);
		return synonyms;
	}
	public JSONArray getAntonyms(String word) throws Exception {
		requestsBase core = new requestsBase("http://pydictionary-geekpradd.rhcloud.com/api/antonym/"+word);
		String jsonasString = core.returnHandledOutput();
		JSONParser parser = new JSONParser();
		JSONArray synonyms = (JSONArray) parser.parse(jsonasString);
		return synonyms;
	}
	public String getTranslation(String word, String gTranslateCode) throws Exception{
		requestsBase trans = new requestsBase("http://pydictionary-geekpradd.rhcloud.com/api/translate/" + gTranslateCode + "/" + word);
		return trans.returnHandledOutput();
	}
	public JSONObject getMeanings(String word) throws Exception{
		requestsBase mean = new requestsBase("http://pydictionary-geekpradd.rhcloud.com/api/meaning/" + word);
		String jsonasString = mean.returnHandledOutput();
		JSONParser parser = new JSONParser();
		return (JSONObject) parser.parse(jsonasString);
	}
}


