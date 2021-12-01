package pt.ldlim.ether.datapool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONFile {

	private static String JSON_OUTPUT_PATH_DATA = System.getProperty("user.dir") + File.separator + "src"+ File.separator +
			"main"+ File.separator +"resources"+ File.separator +"datapools"+  File.separator +"RegistrationData.json";
	
	/**********	READ JSON	**********/
	public static JSONObject readJSON(String id) throws FileNotFoundException, IOException, ParseException {
		JSONArray data = (JSONArray) readAllJSONData();
		return getDataTestBasedOnId(id, data);
		
	}
	
	public static Object readAllJSONData() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		return parser.parse(new FileReader(JSON_OUTPUT_PATH_DATA));
	}
	
	/**********	DATA TEST SELECTOR	**********/
	public static JSONObject getDataTestBasedOnId(String id, JSONArray data) {
		for(int count=0;count<data.size();count++) {
			JSONObject cenarioData = (JSONObject) data.get(count);
			JSONObject dataTest = (JSONObject) cenarioData.get("tests");
			if (dataTest.get("id").equals(id)) 
				return dataTest;
		}
		return null;
		
	}
	
}
