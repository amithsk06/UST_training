package ust.example.utilities;

	import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.cucumberexpressions.TypeReference;
	public class SettingsJson {
	    @Test
	    public List<String> test() throws IOException {
	    	String jsonFilePath = System.getProperty("user.dir") + "/src/test/resources/data.json";
	        HashMap<String, String> data = getJsonData(jsonFilePath);
	        System.out.println("AdAD");
	        System.out.println(printJsonData(data));
	       return printJsonData(data);
	    }
	    public HashMap<String, String> getJsonData(String jsonFilePath) throws IOException {
	        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
	        ObjectMapper mapper = new ObjectMapper();
	        HashMap<String, String> data = mapper.readValue(jsonContent, new TypeReference<HashMap<String, String>>() {});
	        return data;
	    }
			List<String> textValues = new ArrayList<String>();
	    public List<String> printJsonData(HashMap<String, String> data) {
	        for (String key : data.keySet()) {
	            textValues.add(data.get(key));
	        }
	        return textValues;
	    }
	}

