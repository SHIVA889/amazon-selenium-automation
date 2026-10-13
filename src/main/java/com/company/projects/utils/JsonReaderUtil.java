package com.company.projects.utils;
import com.company.project.models.RootData;



import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
public class JsonReaderUtil {

	    public static RootData getTestData(String filePath) throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        return mapper.readValue(new File(filePath), RootData.class);
	    }
	

}   
      